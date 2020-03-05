package first.base;

import first.manager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    public WebDriver driver = DriverManager.getInstance().getDriver();
    private String baseURL = "https://login.salesforce.com/";

    @BeforeTest
    public void openSearchPage() {
        driver.get(baseURL);
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
