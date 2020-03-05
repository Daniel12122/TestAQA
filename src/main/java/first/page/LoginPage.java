package first.page;


import first.base.BasePage;
import first.model.User;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Slf4j
public class LoginPage extends BasePage {

    @FindBy(css = "#username")
    private WebElement usernameInput;

    @FindBy(css = "#password")
    private WebElement passwordInput;

    @FindBy(css = "#Login")
    private WebElement loginBtn;

    @FindBy(css = "#rememberUn")
    private WebElement rememberMeCheckbox;

    @FindBy(css = "#error")
    private WebElement errorMessages;

    @Step
    public LoginPage inputUsername(String username) {
        wait.until(ExpectedConditions.elementToBeClickable(usernameInput));
        usernameInput.sendKeys(username);
        return this;
    }

    @Step
    public LoginPage inputPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(passwordInput));
        passwordInput.sendKeys(password);
        return this;
    }

    @Step
    public MainPage clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        loginBtn.click();
        return new MainPage();
    }

    @Step
    public LoginPage clickRememberMe() {
        wait.until(ExpectedConditions.elementToBeClickable(rememberMeCheckbox));
        rememberMeCheckbox.click();
        return this;
    }

    public MainPage login(User user) {
        inputUsername(user.getEmail());
        inputPassword(user.getPassword());
        clickRememberMe();
        clickLogin();
        return new MainPage();
    }

    public LoginPage loginWithoutPassword(User user) {
        inputUsername(user.getEmail());
        clickLogin();
        return this;
    }

    public LoginPage loginWithoutUsername(User user) {
        inputPassword(user.getPassword());
        clickLogin();
        return this;
    }

    @Step
    public boolean loginErrorDisplayed() {
        return errorMessages.isDisplayed();
    }

    @Step
    public LoginPage verifyErrorMessageDisplayed(){
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(isLoaded()).as("").isTrue();
        assertions.assertThat(loginErrorDisplayed()).as("").isTrue();
        assertions.assertAll();
        return this;
    }

    @Step
    @Override
    public boolean isLoaded() {
        return usernameInput.isDisplayed();
    }
}
