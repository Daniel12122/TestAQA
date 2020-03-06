package page;

import base.BasePage;
import base.LoadableComponent;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import model.User;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class LoginPage extends BasePage implements LoadableComponent {

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
        usernameInput.sendKeys(username);
        log.info("Input Username");
        return this;
    }

    @Step
    public LoginPage inputPassword(String password) {
        passwordInput.sendKeys(password);
        log.info("Input password");
        return this;
    }

    @Step
    public MainPage clickLogin() {
        loginBtn.click();
        log.info("Click button Login");
        return new MainPage();
    }

    @Step
    public LoginPage clickRememberMe() {
        rememberMeCheckbox.click();
        log.info("Click remember me checkbox");
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
        assertions.assertThat(isLoaded()).as("Page didn't load!").isTrue();
        assertions.assertThat(loginErrorDisplayed()).as("Error text didn't appear!").isTrue();
        assertions.assertAll();
        log.info("Check that we are on that page and an error message appears.");
        return this;
    }

    @Step
    public LoginPage verifyPageLoaded() {
        assertThat(isLoaded()).as("Page didn't load!").isTrue();
        log.info("Check that we are on that page.");
        return this;
    }

    @Step
    @Override
    public boolean isLoaded() {
        return usernameInput.isDisplayed();
    }
}
