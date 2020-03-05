package first.factory;

import first.model.User;
import org.apache.commons.lang3.RandomStringUtils;

public class UserFactory {

    private UserFactory() {
    }

    public static User getDefaultUser() {
        return User.builder()
                .email("yurii@ctdev.io")
                .password("4eszXDR%")
                .build();
    }

    public static User getRandomUser() {
        return User.builder()
                .email(RandomStringUtils.randomAlphabetic(10) + "@gmail.com")
                .password(RandomStringUtils.randomAlphanumeric(8))
                .build();
    }
}
