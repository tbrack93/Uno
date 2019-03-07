import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Deck{

  private LinkedList<Card> cards;
  public static  Comparator<Card> comp = Comparator.comparing(Card::getColour).
                                         thenComparing(Card::getNumber);
  public Deck() {
    Card[] deck = new Card[108]; //faster to add to an array
    int counter = 0;

    for(Card.Colour colour : Card.Colour.values()){
      deck[counter] = new Card(colour, 0);
      counter++;
      for(int i = 1; i < 10; i++){
        deck[counter] = new Card(colour, i);
        deck[counter+1] = new Card(colour, i);
        counter = counter + 2;
      }
      for(Card.Action action : Card.Action.values()){
        deck[counter] = new Card(colour, action);
        deck[counter + 1] = new Card(colour, action);
        counter = counter + 2;
      }
    }


    for(Card.Wild wild : Card.Wild.values()){
      for(int l = 0; l < 4; l++){
        deck[counter] = new Card(wild);
        counter++;
      }
    }
    cards = new LinkedList(Arrays.asList(deck));
    Collections.shuffle(cards); // multiple shuffles to increase randomness
    Collections.shuffle(cards);
    Collections.shuffle(cards);
    // for(Card c : cards){
    //    System.out.println(c);
    //  }
  }

   // for if deck runs out
   public Deck(List<Card> pile){
      this.cards = (LinkedList<Card>) pile;
      Collections.shuffle(cards);
      Collections.shuffle(cards);
    }

  public LinkedList<Card> draw(int number){
    LinkedList<Card> draw = new LinkedList<>();
    for(int i = 0; i < number; i++){
      if(cards.size() > 0){
        draw.add(this.cards.remove());
      }
    }
    return draw;
  }

  public int cardsLeft(){
    return cards.size();
  }


  public static void main(String[] args){
    // Deck deck = new Deck();
    // for(Card c : deck.cards){
    //   System.out.println(c);
    // }
    // System.out.println(deck.cards.size());
    // System.out.println(deck.draw(12));
    // System.out.println(deck.cards.size());

  }
}
