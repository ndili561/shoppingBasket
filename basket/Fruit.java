package basket;

public abstract class Fruit implements Item{
  int price;
  int quantity;

  public int getPrice(){
    return price;
  }

  public void setPrice(int aPrice){
    this.price = aPrice;
  }

  public int getQuantity(){
    return quantity;
  }

  public void setQuantity(int aQuantity){
    this.quantity = aQuantity;
  }




}