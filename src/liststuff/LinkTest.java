package liststuff;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinkTest {

  @BeforeEach
  public void setUp(){}

  @AfterEach
  public void tearDown(){}

  @Test
  public void testFail(){
    fail("this will fail");
  }
}
