// this is effectively the controller (server side)
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;


public class Game{

  private ArrayList<Player> players;
  private Deck deck;
  private LinkedList<Card> pile;
  private String activeColour; // if a wild is player this is not the same as latest pile card
  private Player currentPlayer;
  private boolean won;

  public Game(){
    deck = new Deck();
    pile = new LinkedList<Card>();
    players = new ArrayList<Player>();
  }

  public void start(){
    won = false;
    startingHands();
    addToPile(deck.draw(1));
    currentPlayer = players.get((int) Math.random() * players.size());
  }

  public void startingHands(){
    Hand newHand;
    for(Player player : players){
      newHand = new Hand();
      newHand.addCards(deck.draw(7));
      player.setHand(newHand);
    }
  }

  public Player nextPlayer(){
    currentPlayer = players.get((players.indexOf(currentPlayer) +1) % players.size());
    return currentPlayer;
  }

  public void addPlayer(Player player){
    players.add(player);
  }

  public void removePlayer(Player player){
    players.remove(player);
  }

  public Deck getDeck(){
    return deck;
  }

  public Card getPileCard(){
    return pile.getLast();
  }

  public String getActiveColour(){
    return activeColour;
  }

  public Player getCurrentPlayer(){
    return currentPlayer;
  }

  public List<Player> getOtherPlayers(){
    ArrayList<Player> otherPlayers = new ArrayList<>(players);
    otherPlayers.remove(currentPlayer);
    Comparator<Player> comp = Comparator.comparing(Player::getID);
    Collections.sort(otherPlayers, comp);
    return otherPlayers;
  }

  public void addToPile(List<Card> card){
    pile.addAll(card);
    activeColour = card.get(0).getColour();
  }
}
