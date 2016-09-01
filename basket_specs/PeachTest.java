import static org.junit.Assert.*;
import org.junit.*;
import basket.*;

public class PeachTest{

  Peach peach;

  @Before
  public void before(){
    peach = new Peach(10,2);
  }

  @Test
  public void TestPrice(){
    assertEquals(10, peach.getPrice());
  }

  @Test
  public void TestQuantity(){
    assertEquals(2, peach.getQuantity());
  }
}