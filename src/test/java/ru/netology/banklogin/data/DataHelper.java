package ru.netology.banklogin.data;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;


import java.util.Locale;

public class DataHelper {
    private static final Faker FAKER = new Faker(new Locale("en"));

    private DataHelper() {
    }

    public static AuthInfo getUserAuthInfoTestData() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static AuthInfo generateRandomUser() {
        return new AuthInfo(
                generateRandomLogin(),
                generateRandomPassword()
        );
    }

    private static String generateRandomLogin() {
        return FAKER.name().username();
    }

    public static String generateRandomPassword() {
        return FAKER.internet().password();
    }

    public static VerificationCode generateRandomVerificationCode() {
        return new VerificationCode(FAKER.numerify("######"));
    }

    @Value
    public static class AuthInfo {
        String login;
        String password;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class VerificationCode {
        String code;
    }

    @Value
    public static class User {
        String id;
        String login;
        String password;
        boolean active;
    }
}