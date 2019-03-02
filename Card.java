public class Card{

  public enum Action {Skip, Draw2, Reverse};
  public enum Wild {Wild, Wild_Draw4};
  public enum Colour {Green, Yellow, Blue, Red};

  private Colour colour;
  private Wild wild;
  private Action action;
  private Integer number;

  public Card(Colour colour, int number){
    this.colour = colour;
    this.number = number;
  }

  public Card(Colour colour, Action action){
    this.colour = colour;
    this.action = action;
  }

  public Card(Wild wild){
    this.wild = wild;
  }

  public String getColour(){
    if(this.colour != null){
      return this.colour.name();
    }
    return "white";
  }

  public int getNumber(){
    if(this.number != null){
      return this.number;
    }
    return -10;
  }

  public String getAction(){
    if(this.action != null){
      return this.action.name();
    }
    return null;
  }

  public String getWild(){
    if(this.wild != null){
      return this.wild.name();
    }
    return null;
  }

  public boolean match(Card card){
    return this.getColour() == card.getColour() || this.getNumber() == card.getNumber() || this.getColour() == "white";
  }

  // @Override
  // public int compareTo(Card other){
  //   if(this.getColour().compareTo(other.getColour()) == 0){
  //     return this.getNumber() - other.getNumber();
  //   }
  //   return this.getColour().compareTo(other.getColour());
  // }

  public String toString(){
    if(this.getWild() != null){
      return this.getWild();
    }
    if(this.getAction() == null){
      return this.getColour() + " : " + this.getNumber();
    }
    return this.getColour() + " : " + this.getAction();
  }
}
