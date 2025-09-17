import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
//import page.SamokatMainPage;
//import steps.FillAboutUser;
//import steps.OrderPageSteps;


public class BaseTests {
    WebDriver driver = new FirefoxDriver();

   //public SamokatMainPage samokatMainPage;
   //public TestPageSamokat testPageSamokat;
   // public OrderPageSteps orderPageSteps;
    //public FillAboutUser fillAboutUser;



    @Before
    public void startUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
       // testPageSamokat = new TestPageSamokat();
       // orderPageSteps = new OrderPageSteps();
      //samokatMainPage = new SamokatMainPage();
        // fillAboutUser = new FillAboutUser();
    }


  //  @After
  // public void tearDown(){
   //    driver.quit();
  // }

}
