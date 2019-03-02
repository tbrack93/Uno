import java.util.List;

public class Controller{

  private Game game;

  public Controller(){
  }

  public void newGame(){
    this.game = new Game();
    int numberOfPlayers = View.askForPlayers();
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
    View.showStatus(game.getPileCard(), game.getActiveColour());
    View.showOtherPlayers(game.getOtherPlayers());
    View.showYourCards(game.getCurrentPlayer());
    newChoice();
  }

  public void newChoice(){
    int choice = View.showOptions();
    action(choice);
  }

  public void action(int choice){
    int secondChoice;
    if(choice == 1){
      secondChoice = View.chooseCard(game.getCurrentPlayer().getHand());
      playCard(game.getCurrentPlayer().getHand().getCards().get(secondChoice), secondChoice);
    }
    if(choice == 2){
      List<Card> draw;
      draw = game.getDeck().draw(1);
      game.getCurrentPlayer().getHand().addCards(draw);
      View.showDraw(draw.get(0));
    }
    if(game.won = false){
      newTurn();
    }
    newTurn();
  }

  public void playCard(Card card, int index){
    if(card.getColour() == "white" || card.getColour() == game.getActiveColour() ||
      card.getNumber() == game.getActiveNumber() && card.getNumber() != -10){
      game.addToPile(game.getCurrentPlayer().getHand().playCard(index));
    }
    else {
        View.showInvalid();
        newChoice();
    }
  }

  public static void main(String[] args){
  Controller test = new Controller();
  test.newGame();
  }
}

