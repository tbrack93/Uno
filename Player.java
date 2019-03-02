import java.util.List;

public class Player{

  private String name;
  private int id;
  private String username;
  private String password;
  private int wins;
  private int loses;
  private Hand hand;
  private static idCounter;

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

  public Hand getHand(){
    return this.hand;
  }

  public String getName(){
    return this.name;
  }

  public String checkPassword(String password){
    return this.password == password;
  }

}
