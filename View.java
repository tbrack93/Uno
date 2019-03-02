import java.util.Scanner;
import java.util.List;

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
  }

  public static void showStatus(Card pileCard, String activeColour){
    System.out.println("Latest card on pile is: " + pileCard);
    System.out.println("Active Colour is: " + activeColour);
  }

  public static void showOtherPlayers(List<Player> others){
    for(Player player : others){
      System.out.println(player.getName() + " has " + player.getHand().getNumberOfCards() + " cards left.");
    }
  }

  public static void showYourCards(Player player){
    System.out.println("You have in your hand: ");
    int i = 1;
    for(Card card :player.getHand().getCards()){
      System.out.println(i + ": " + card + " ");
      i++;
    }
  }

  public static int showOptions(){
    System.out.println();
    System.out.println("What would you like to do?");
    System.out.println("1. Play a card");
    System.out.println("2. Draw a card");
    System.out.println("3. Quit");
    return sc.nextInt();
  }

  public static int chooseCard(Hand cards){
    System.out.println();
    System.out.println("Which card would you like to play?");
    System.out.println("Choose from 1 to " + cards.getNumberOfCards());
    return sc.nextInt() -1;
  }

  public static void showDraw(Card card){
    System.out.println();
    System.out.println("You drew " + card);
  }

  public static void showInvalid(){
    System.out.println();
    System.out.println("That card is not valid");
    System.out.println("Please play a card that matches the current pile's");
    System.out.println("colour or number. Or play a wild card.");
    System.out.println("If you cannot play a card you must draw a card.");
  }

}
