package test.negative;

import first.factory.UserFactory;
import first.model.User;
import first.page.LoginPage;
import org.testng.annotations.Test;


public class SingInNegativeTest {

    User user = UserFactory.getRandomUser();

    @Test
    void loginWithRandomInformation() {
        new LoginPage()
                .login(user);
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
                .verifyErrorMessageDisplayed();
    }

    @Test
    void loginWithoutInformation() {
        new LoginPage()
                .clickLogin();
    }
}
