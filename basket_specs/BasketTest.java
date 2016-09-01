import static org.junit.Assert.*;
import org.junit.*;
import basket.*;
import java.util.*;

public class BasketTest{

  Basket basket1;
  Customer customer;

  @Before
  public void before(){
    customer = new Customer(true);
    basket1 = new Basket(customer);

  }

  @Test
  public void TestBasket(){
    Map<Item,Integer> basket = basket1.getBasket();
    assertEquals(0, basket.size());
  }



  @Test
  public void TestAddItem(){
    Peach peach = new Peach(10, 1);
    basket1.addItem(peach);
    assertEquals(1, basket1.getBasket().size());
  }

  @Test
  public void TestRemoveItem(){
    Peach peach = new Peach(10, 1);
    basket1.addItem(peach);
    basket1.removeItem(peach);
    assertEquals(0, basket1.getBasket().size());
  }

  @Test
  public void TestEmptyBasket(){
    Peach peach = new Peach(10, 1);
    basket1.addItem(peach);
    Celery celery = new Celery(10, 1);
    basket1.addItem(celery);
    basket1.emptyBasket();
    assertEquals(0, basket1.getBasket().size());
  }

  @Test
  public void TestTotal(){
    Peach peach = new Peach(10, 2);
    Peach peach2 = new Peach(10, 1);
    basket1.addItem(peach);
    basket1.addItem(peach2);
    assertEquals(30, basket1.totalBasket());
  }


  @Test
  public void TestBuyOneGetOneFree(){
    Basket basket = new Basket(customer);
    Peach peach = new Peach(10, 5);
    basket.addItem(peach);
    basket.buyOneGetOneFree();
    assertEquals(30, basket.totalBasket());
  }

  @Test
  public void TestDiscount(){
    Peach peach = new Peach(20, 2);
    basket1.addItem(peach);
    assertEquals(4, basket1.discount());
  }

  @Test
  public void TestCustomerLoyalty(){
    assertEquals(true, basket1.getCustomerLoyalty());
  }

  @Test
  public void TestDiscountLoyalty(){
    Peach peach = new Peach(20, 2);
    basket1.addItem(peach);
    assertEquals(39, basket1.discountForLoyalty());
  }

}