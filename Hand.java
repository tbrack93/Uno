import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

public class Hand{

private LinkedList<Card> hand;

  public Hand(){
    this.hand = new LinkedList<Card>();
  }

  public void addCards(List<Card> cards){
    hand.addAll(cards);
    Collections.sort(hand, Deck.comp);
  }

  public void playCard(int index){
    hand.remove(index);
    Collections.sort(hand, Deck.comp);
  }

  public int getNumberOfCards(){
    return this.hand.size();
  }

  public List<Card> getCards(){
    return this.hand;
  }


}
