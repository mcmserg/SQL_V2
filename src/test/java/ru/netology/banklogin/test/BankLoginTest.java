package ru.netology.banklogin.test;


import org.junit.jupiter.api.*;
import ru.netology.banklogin.data.DataHelper;
import ru.netology.banklogin.data.SQLHelper;
import ru.netology.banklogin.page.LoginPade;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.banklogin.data.SQLHelper.cleanAuthCode;
import static ru.netology.banklogin.data.SQLHelper.cleanDatabase;

public class BankLoginTest {
    LoginPade loginPade;
    DataHelper.AuthInfo authInfo = DataHelper.getUserAuthInfoTestData();

    @AfterAll
    static void tearDownA() {
        cleanDatabase();
    }

    @AfterEach
    void tearDown() {
        cleanAuthCode();
    }

    @BeforeEach
    void setUp() {
        loginPade = open("http://localhost:9999", LoginPade.class);
    }

    @Test
    @DisplayName("Should successfully login to dashboard with exist login and password from sut test data")
    void shouldSuccessfullogin() {
        var verificationPage = loginPade.validLogin(authInfo);
        var verificationCode = SQLHelper.getVerificationCode();
        verificationPage.validVerify(verificationCode.getCode());

    }

}
