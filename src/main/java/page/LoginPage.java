package page;

import action.ElementActions;
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
        log.info("Input Username - "+ username);
        usernameInput.sendKeys(username);
        return this;
    }

    @Step
    public LoginPage inputPassword(String password) {
        log.info("Input password - " + password);
        passwordInput.sendKeys(password);
        return this;
    }

    @Step
    public MainPage clickLogin() {
        log.info("Click button Login");
        loginBtn.click();
        return new MainPage();
    }

    @Step
    public LoginPage clickRememberMe() {
        log.info("Click remember me checkbox");
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
        return ElementActions.isDisplayed(errorMessages);
    }

    @Step
    public LoginPage verifyErrorMessageDisplayed(){
        log.info("Check that we are on that page and an error message appears.");
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(isLoaded()).as("Page didn't load!").isTrue();
        assertions.assertThat(loginErrorDisplayed()).as("Error text didn't appear!").isTrue();
        assertions.assertAll();
        return this;
    }

    @Step
    public LoginPage verifyPageLoaded() {
        log.info("Check that we are on that page.");
        assertThat(isLoaded()).as("Page didn't load!").isTrue();
        return this;
    }

    @Step
    @Override
    public boolean isLoaded() {
        return ElementActions.isDisplayed(usernameInput);
    }
}
