import java.util.List;

public class Player{

  private String name;
  private int id;
  private String username;
  private String password;
  private int wins;
  private int loses;
  private Hand hand;
  private static int idCounter = 1;

  public Player(String name){
    this.name = name;
    this.id = idCounter;
    idCounter++;
  }

  public Player(String name, String username, String password){
    this.name = name;
    this.username = username;
    this.password = password;
    this.id = idCounter;
    idCounter++;
  }

  public void setHand(Hand hand){
    this.hand = hand;
  }

  public void addCards(List<Card> cards){
    this.hand.addCards(cards);
  }

  public Hand getHand(){
    return this.hand;
  }

  public boolean hasNoCards(){
    return hand.empty();
  }

  public boolean unoCondition(){
    return hand.getNumberOfCards() == 1;
  }

  public Card getCardAt(int index){
    return hand.getCards().get(index);
  }

  public String getName(){
    return this.name;
  }

  public Card playCard(int index){
    return hand.playCard(index);
  }

  public int getID(){
    return this.id;
  }

  public boolean checkPassword(String password){
    return this.password == password;
  }

}
