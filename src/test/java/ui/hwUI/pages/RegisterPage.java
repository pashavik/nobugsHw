package ui.hwUI.pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import ui.hwUI.datas.BankAccount;

import static com.codeborne.selenide.Selenide.element;

@Getter
public class RegisterPage {

    SelenideElement firstNameInput = element(Selectors.byId("customer.firstName"));
    SelenideElement lastNameInput = element(Selectors.byId("customer.lastName"));
    SelenideElement addressInput = element(Selectors.byId("customer.address.street"));
    SelenideElement cityInput = element(Selectors.byId("customer.address.city"));
    SelenideElement stateInput = element(Selectors.byId("customer.address.state"));
    SelenideElement zipCodeInput = element(Selectors.byId("customer.address.zipCode"));
    SelenideElement phoneInput = element(Selectors.byId("customer.phoneNumber"));
    SelenideElement ssnInput = element(Selectors.byId("customer.ssn"));
    SelenideElement usernameInput = element(Selectors.byId("customer.username"));
    SelenideElement passwordInput = element(Selectors.byId("customer.password"));
    SelenideElement confirmInput = element(Selectors.byId("repeatedPassword"));;

    SelenideElement registerButton = element(Selectors.byValue("Register"));

    SelenideElement addressError = element(Selectors.byId("customer.address.street.errors"));
    SelenideElement cityError = element(Selectors.byId("customer.address.city.errors"));
    SelenideElement stateError = element(Selectors.byId("customer.address.state.errors"));
    SelenideElement zipCodeError = element(Selectors.byId("customer.address.zipCode.errors"));
    SelenideElement ssnError = element(Selectors.byId("customer.ssn.errors"));
    SelenideElement usernameError = element(Selectors.byId("customer.username.errors"));
    SelenideElement passwordError = element(Selectors.byId("customer.password.errors"));
    SelenideElement confirmPasswordError = element(Selectors.byId("repeatedPassword.errors"));

    public void open(){
        Selenide.open("/parabank/register.htm");
    }
    public void register(BankAccount bankAccount){
        firstNameInput.sendKeys(bankAccount.getFirstName());
        lastNameInput.sendKeys(bankAccount.getLastName());

        if (bankAccount.getAddress() != null) {
            addressInput.sendKeys(bankAccount.getAddress());
        }
        if (bankAccount.getCity() != null) {
            cityInput.sendKeys(bankAccount.getCity());
        }
        if (bankAccount.getState() != null) {
            stateInput.sendKeys(bankAccount.getState());
        }
        if (bankAccount.getZipCode() != null) {
            zipCodeInput.sendKeys(bankAccount.getZipCode());
        }
        if (bankAccount.getZipCode() != null) {
            phoneInput.sendKeys(bankAccount.getPhone());
        }
        if (bankAccount.getSsn() != null) {
            ssnInput.sendKeys(bankAccount.getSsn());
        }
        if (bankAccount.getUsername() != null) {
            usernameInput.sendKeys(bankAccount.getUsername());
        }
        if (bankAccount.getPassword() != null) {
            passwordInput.sendKeys(bankAccount.getPassword());
            confirmInput.sendKeys(bankAccount.getPassword());
        }

        registerButton.click();
    }
}



