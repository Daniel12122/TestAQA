package base;

import manager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage  {

    public final WebDriverWait wait;
    public WebDriver driver = DriverManager.getInstance().getDriver();
    private String baseURL = "https://www.google.com.ua";

    public  BasePage(){
        PageFactory.initElements(DriverManager.getInstance().getDriver(), this);
        wait = new WebDriverWait(DriverManager.getInstance().getDriver(), 10);
    }
}
