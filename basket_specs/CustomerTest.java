import static org.junit.Assert.*;
import org.junit.*;
import basket.*;



public class CustomerTest{

  Customer customer;

  @Before
  public void before(){
    customer = new Customer(true);
  }

  @Test
  public void Testcard(){
    assertEquals(true, customer.getCard());
  }
}