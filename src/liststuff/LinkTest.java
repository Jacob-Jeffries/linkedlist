package liststuff;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinkTest {

  private Link aLink;

  @BeforeEach
  public void setUp(){
    aLink = new Link("ocarina");
  }

  @AfterEach
  public void tearDown(){
    aLink = null;
  }

  @Test
  public void testConstructor(){
    assertNull(aLink.getAfter());
    assertNull(aLink.getBefore());
    assertTrue("ocarina", aLink.getItem());
  }

  @Test
  public void testLinkage(){
    Link otherLink = new Link("shield");
    aLink.setAfter(otherLink);
    otherLink.setBefore(aLink);
    assertEquals(otherLink, aLink.getAfter());
    assertNull(aLink.getBefore());
    assertEquals("ocarina", aLink.getItem());
    assertnull(otherLink.getAfter());
    assertEquals(aLink, otherLink.getBefore());
    assertEquals("shield", otherLink.getItem());
  }
}
