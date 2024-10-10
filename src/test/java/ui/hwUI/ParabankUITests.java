package ui.hwUI;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ui.hwUI.datas.BankAccount;
import ui.hwUI.pages.RegisterPage;
import utils.RandomData;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.element;

public class ParabankUITests {

    @BeforeAll
    public static void setUp(){
        Configuration.baseUrl = "https://parabank.parasoft.com";
        Configuration.timeout = 10;
    }

    @Test
    public void userCanNotCreateAccountWithOnlyFirstNameAndLastName(){

        RegisterPage registerPage = new RegisterPage();
        registerPage.open();

        BankAccount bankAccount = BankAccount.builder()
                        .firstName(RandomData.randomString())
                        .lastName(RandomData.randomString())
                        .build();

        registerPage.register(bankAccount);

        registerPage.getAddressError().shouldHave(Condition.exactText("Address is required."));
        registerPage.getCityError().shouldHave(Condition.exactText("City is required."));
        registerPage.getStateError().shouldHave(Condition.exactText("State is required."));
        registerPage.getZipCodeError().shouldHave(Condition.exactText("Zip Code is required."));
        registerPage.getSsnError().shouldHave(Condition.exactText("Social Security Number is required."));
        registerPage.getUsernameError().shouldHave(Condition.exactText("Username is required."));
        registerPage.getPasswordError().shouldHave(Condition.exactText("Password is required."));
        registerPage.getConfirmPasswordError().shouldHave(Condition.exactText("Password confirmation is required."));
    }

    @Test
    public void successfulRegistration(){
        RegisterPage registerPage = new RegisterPage();
        registerPage.open();

        BankAccount bankAccount = BankAccount.builder()
                .firstName(RandomData.randomString())
                .lastName(RandomData.randomString())
                .address(RandomData.randomString())
                .city(RandomData.randomString())
                .state(RandomData.randomString())
                .zipCode(RandomData.randomString())
                .phone(RandomData.randomString())
                .ssn(RandomData.randomString())
                .username(RandomData.randomString())
                .password(RandomData.randomString())
                .build();

        registerPage.register(bankAccount);

        SelenideElement successWelcome = element(Selectors.byCssSelector("#rightPanel > p"));
        successWelcome.shouldBe(visible, Duration.ofSeconds(5));
        Assertions.assertEquals("ParaBank | Customer Created", Selenide.title());
        Assertions.assertEquals("Your account was created successfully. You are now logged in.", successWelcome.text());
    }

}
