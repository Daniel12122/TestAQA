package base;

import manager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    public WebDriver driver = DriverManager.getInstance().getDriver();

    @BeforeTest
    public void openSearchPage() {
        driver.get("https://login.salesforce.com/");
    }

    @AfterTest
    public void  close(){
        try {
            if (driver!= null){
                driver.quit();
            }
        }finally{
            driver = null;
        }
    }
}
