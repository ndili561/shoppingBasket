package basket;
import java.util.*;

public class Basket{
  private Map<Item,Integer>shoppingBasket;
  private Customer customer;



  public Basket(Customer aCustomer){
    shoppingBasket = new HashMap<Item,Integer>();
    this.customer = aCustomer;

  }

  public Map<Item,Integer> getBasket(){
    return shoppingBasket;
  }


  public void addItem(Item aItem){
    shoppingBasket.put(aItem,aItem.getPrice()*aItem.getQuantity());
  }

  public void removeItem(Item aItem){
    shoppingBasket.remove(aItem);
  }

  public void emptyBasket(){
    shoppingBasket.clear();
  }

  public int totalBasket(){
    int result = 0;
    for(Item item : this.shoppingBasket.keySet()){
      result+=this.shoppingBasket.get(item);
    }
    return result;
  }

  public void buyOneGetOneFree(){
    for(Item item : this.getBasket().keySet()){
      if(item.getQuantity()>=2){
        int quantity = item.getQuantity();
        if (quantity%2==0){
          this.getBasket().put(item, item.getPrice() * item.getQuantity()/2);
        }else{
          float result = (float)item.getQuantity() / 2;
          int quant = Math.round(result);
          this.getBasket().put(item, item.getPrice() * quant);
        } 
      }
    }
  }

  public int discount(){
    int total = 0;
    if(this.totalBasket()>20){
     total+=this.totalBasket() * 10 / 100;
    }
    return total;
  }  

  public boolean getCustomerLoyalty(){
    if(this.getCustomer().getCard()){
      return true;
    }else{
      return false;
    }
  }

  private Customer getCustomer(){
    return customer;
  }

  public int discountForLoyalty(){
    int result=this.totalBasket();
    if(getCustomerLoyalty()){
     float total=(float)this.totalBasket() * 2 / 100;
      int discount=Math.round(total);
     result-=discount;
     
    }
    return result;
  }
}