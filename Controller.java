import java.util.List;

public class Controller{

  private Game game;

  public Controller(){
  }

  public void newGame(){
    this.game = new Game();
    int numberOfPlayers = View.askForPlayers();
    while(numberOfPlayers < 2){
      View.tooFewPlayers();
      numberOfPlayers = View.askForPlayers();
    }
    String name;
    Player player;
    for(int i =1; i < numberOfPlayers+1; i++){
      name = View.askForPlayerName(i);
      game.addPlayer(new Player(name));
    }
    game.start();
    newTurn();
  }

  public void newTurn(){
    View.startTurn(game.nextPlayer());
    if(game.getActiveColour() == "black"){
      wild();
    }
    View.showStatus(game.getPileCard(), game.getActiveColour());
    View.showOtherPlayers(game.getOtherPlayers());
    int drawPenalty = game.getDrawPenalty();
    if(drawPenalty > 0){
      View.showDrawPenalty(drawPenalty);
      draw(drawPenalty);
      game.setDrawPenalty(0);
    }
    if(game.getSkip() == true){
      View.showSkip();
      game.skipped();
      newTurn();
    } else {
      View.showYourCards(game.getCurrentPlayer());
      newChoice();
    }
  }

  public void newChoice(){
    int choice = View.showOptions();
    action(choice);
  }

  public void action(int choice){
    int secondChoice;
    if(choice == 1 || choice == 2){
      secondChoice = View.chooseCard(game.getCurrentPlayer().getHand());
      playCard(game.getCurrentPlayer().getCardAt(secondChoice), secondChoice);
      if(game.unoCondition() == true && choice != 2){
        View.showUnoPenalty();
        draw(2);
      } else if(game.unoCondition() == false && choice == 2){
        View.stopCryingWolf();
      }
    }
    if(choice == 3){
      draw(1);
    }
    if(choice == 4){
      System.exit(0);
    }
    if(game.hasWon()){
      View.showWinner(game.getCurrentPlayer().getName());
      if(View.playAgain().contains("Y")){
        newGame(); // doesn't work?
      }
      else{
        System.exit(0);
      }
    }
    newTurn();
  }

  public void draw(int cards){
    int deckRemaining = game.deckRemaining();
   if(cards > deckRemaining){
      List<Card> draw = game.draw(deckRemaining);
      View.showDraw(draw);
      View.pileToDeck();
      game.pileToDeck();
      draw(cards - deckRemaining);
    } else {
      List<Card> draw = game.draw(cards);
      View.showDraw(draw);
    }
  }

  public void playCard(Card card, int index){
    if(card.getColour() == "black" || card.getColour() == game.getActiveColour() ||
      card.getNumber() == game.getActiveNumber() && card.getNumber() != -10){
      game.addToPile(game.getCurrentPlayer().playCard(index));
    }
    else {
      View.showInvalid();
      newChoice();
    }
    if(card.getAction() == "Skip"){
      game.skipTurn();
    }
    if(card.getAction() == "Draw2"){
      game.setDrawPenalty(2);
    }
    if(card.getAction() == "Reverse"){
      game.reverse();
     }
  if(card.getWild() == "Wild"){
    wild();
  }
  if(card.getWild() == "Wild_Draw4"){
    wild();
    game.setDrawPenalty(4);
    game.skipTurn();
  }
}


public void wild(){
  int newColour = View.getColourChoice();
  game.wildResult(newColour);
}


public static void main(String[] args){
  Controller test = new Controller();
  test.newGame();
}
}

