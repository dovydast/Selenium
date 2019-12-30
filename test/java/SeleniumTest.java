import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumTest {
    @BeforeTest
    public void testSetup(){
       // Selenium.setup();
        Selenium.setupTwitch();
    }

    /*@Test
    public void testSearchByKeyword(){
        Selenium.searchByKeyword("Baranauskas");
    }

     */

    @Test
    public void testRegisterTwitchAccount(){
        Selenium.registerTwitchAccount("dovisprime2","osrslietuva",2,"14","1997","fatima.breelyn@owee.org");

    }
    @Test
    public void testRegisterTwitchAccount2(){
        Selenium.setupTwitch();
        Selenium.registerTwitchAccount("dovisprime3","osrslietuva",4,"24","1998","mccray.donzell@owee.org");

    }

    @AfterTest
    public void closeTest(){
     Selenium.quit();
    }

}
