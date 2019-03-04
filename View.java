import java.util.Scanner;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class View{

  private static Scanner sc = new Scanner(System.in);

  public static int askForPlayers(){
    System.out.println("How many people will play?");
    return sc.nextInt();
  }

  public static String askForPlayerName(int count){
    System.out.println("What is player" + count + "'s name?");
    return sc.next();
  }

  public static void startTurn(Player player){
    System.out.println();
    System.out.println(player.getName() + "'s turn!");
    System.out.println("----------------");
    delay(500);
  }

  public static void showStatus(Card pileCard, String activeColour){
    System.out.println("Latest card on pile is: " + pileCard);
    System.out.println("Active Colour is: " + activeColour);
    System.out.println();
    delay(500);
  }

  public static void showOtherPlayers(List<Player> others){
    for(Player player : others){
      System.out.println(player.getName() + " has " + player.getHand().getNumberOfCards() + " cards left.");
      System.out.println();
      delay(200);
    }
  }

  public static void showYourCards(Player player){
    System.out.println("You have in your hand: ");
    int i = 1;
    for(Card card :player.getHand().getCards()){
      System.out.println(i + ": " + card + " ");
      i++;
    }
    delay(500);
  }

  public static int showOptions(){
    System.out.println();
    System.out.println("What would you like to do?");
    System.out.println("1. Play a card");
    System.out.println("2. Play a card and say UNO");
    System.out.println("3. Draw a card");
    System.out.println("4. Quit");
    return sc.nextInt();
  }

  public static int chooseCard(Hand cards){
    System.out.println();
    System.out.println("Which card would you like to play?");
    System.out.println("Choose from 1 to " + cards.getNumberOfCards());
    return sc.nextInt() -1;
  }

  public static void showDraw(List<Card> cards){
    System.out.println();
    for(Card c : cards){
      System.out.println("You drew " + c);
      delay(200);
    }
  }

  public static void showInvalid(){
    System.out.println();
    System.out.print("That card is not valid.");
    System.out.print(" Please play a card that matches the current pile's");
    System.out.print(" colour or number. Or play a wild card.");
    System.out.print(" If you cannot play a card you must draw a card.");
  }

  public static int getColourChoice(){
    System.out.println();
    System.out.println("You have played a Wild card. Please choose which colour to set:");
    System.out.println("1: Blue");
    System.out.println("2: Green");
    System.out.println("3: Red");
    System.out.println("4: Yellow");
    return sc.nextInt()-1;
  }

  public static void showDrawPenalty(int cards){
    System.out.println();
    System.out.println("A draw card was played, so you must draw " + cards + " cards!");
    delay(200);
  }

  public static void showSkip(){
    System.out.println();
    System.out.println("A skip card was played, so you lose your turn!");
    delay(200);
  }

  public static void showWinner(String player){
    System.out.println();
    System.out.println(player + " has no more cards and has won!");
    delay(200);
  }

  public static String playAgain(){
    System.out.println();
    System.out.println("Would you like to play again? Y/N");
    return sc.next();
  }

  public static void showUnoPenalty(){
    System.out.println();
    System.out.println("You didn't say UNO so you have to draw two cards!");
    delay(200);
  }

  public static void stopCryingWolf(){
    System.out.println();
    System.out.println("Why are you shouting UNO? You have more than one card! Crying wolf will be punished. Maybe.");
    delay(200);
  }

  public static void tooFewPlayers(){
    System.out.println();
    System.out.println("Must have at least 2 players. Playing on your own is no fun.");
    delay(200);
  }

  public static void delay(int millis){ // to try and make it easier to read output on command line
    try{
      TimeUnit.MILLISECONDS.sleep(millis);
    }
    catch (InterruptedException ie) {
    }
  }
}
