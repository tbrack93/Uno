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
}

public void newTurn(){
  View.startTurn(game.nextPlayer());
  View.showStatus(game.getPileCard(), game.getActiveColour());
  View.showOtherPlayers(game.getOtherPlayers());
  View.showYourCards(game.getCurrentPlayer());
}


public static void main(String[] args){
  Controller test = new Controller();
  test.newGame();
  test.newTurn();
  test.newTurn();
  test.newTurn();
}

}
