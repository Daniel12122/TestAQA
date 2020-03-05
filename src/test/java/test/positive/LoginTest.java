package test.positive;

import first.base.BaseTest;
import first.factory.UserFactory;
import first.model.User;
import first.page.LoginPage;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends BaseTest {

    @Test
    void userCanLogin() {
        User user = UserFactory.getDefaultUser();

          new LoginPage()
                .login(user);
        assertThat(new LoginPage().isLoaded()).as("").isTrue();
    }
}
