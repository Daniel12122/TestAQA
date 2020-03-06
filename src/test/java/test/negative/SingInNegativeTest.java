package test.negative;

import base.BaseTest;
import factory.UserFactory;
import model.User;
import page.LoginPage;
import org.testng.annotations.Test;


public class SingInNegativeTest extends BaseTest {

    User user = UserFactory.getRandomUser();

    @Test
    void loginWithRandomInformation() {
        new LoginPage()
                .login(user);
        new LoginPage()
                .verifyErrorMessageDisplayed();
    }

    @Test
    void loginWithoutPassword() {
        new LoginPage()
                .loginWithoutPassword(user)
                .verifyErrorMessageDisplayed();
    }

    @Test
    void loginWithoutUsername() {
        new LoginPage()
                .loginWithoutUsername(user)
                .verifyPageLoaded();
    }

    @Test
    void loginWithoutInformation() {
        new LoginPage()
                .clickLogin();
        new LoginPage()
                .verifyPageLoaded();
    }
}
