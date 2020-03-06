package test.positive;

import base.BaseTest;
import factory.UserFactory;
import model.User;
import page.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    void userCanLogin() {
        User user = UserFactory.getDefaultUser();

          new LoginPage()
                .login(user)
                  .verifyPageLoaded();
    }
}
