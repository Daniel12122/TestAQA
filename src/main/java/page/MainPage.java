package page;

import action.ElementActions;
import base.BasePage;
import base.LoadableComponent;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class MainPage extends BasePage implements LoadableComponent {

    @FindBy(css = ".input ")
    private WebElement verificationCodeInput;

    @Step
    public MainPage verifyPageLoaded() {
        log.info("Check that we are on that page.");
        assertThat(isLoaded()).as("Page didn't load!").isTrue();
        return this;
    }

    @Override
    public boolean isLoaded() {
        return ElementActions.isDisplayed(verificationCodeInput);
    }
}
