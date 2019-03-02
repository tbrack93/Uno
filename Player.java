import java.util.List;

public class Player{

  private String name;
  private int id;
  private String username;
  private String password;
  private int wins;
  private int loses;
  private Hand hand;
  private static int idCounter;

  public Player(String name){
    this.name = name;
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

  public Hand getHand(){
    return this.hand;
  }

  public String getName(){
    return this.name;
  }

  public int getID(){
    return this.id;
  }

  public boolean checkPassword(String password){
    return this.password == password;
  }

}
