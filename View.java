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

}
