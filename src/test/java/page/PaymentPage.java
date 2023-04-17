package page;

import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static data.DataHelper.getValidCard1Number;

public class PaymentPage {

    private SelenideElement headingCardPayment = $x("//*[text()='Оплата по карте']");
    private SelenideElement cardNumberField = $x("//*[text()='Номер карты']/following-sibling::*/input[@class='input__control']");
    private SelenideElement monthField = $x("//*[text()='Месяц']/following-sibling::*/input[@class='input__control']");
    private SelenideElement yearField = $x("//*[text()='Год']/following-sibling::*/input[@class='input__control']");
    private SelenideElement ownerField = $x("//*[text()='Владелец']/following-sibling::*/input[@class='input__control']");
    private SelenideElement CVCField = $x("//*[text()='CVC/CVV']/following-sibling::*/input[@class='input__control']");
    private SelenideElement buttonContinue = $x("//*[text()='Продолжить']");
    private SelenideElement notificationApproved = $x("//*[text()='Операция одобрена Банком.']");
    private SelenideElement errorCardNumberEmpty = $x("*[text()='Номер карты']/following-sibling::*/input[@class='input__sub']");
    private SelenideElement errorMonthEmpty = $x("//*[text()='Месяц']//following-sibling::span[@class='input__sub']");
    private SelenideElement errorYearEmpty = $x("//*[text()='Год']//following-sibling::span[@class='input__sub']");
    private SelenideElement errorOwnerEmpty = $x("//*[text()='Владелец']//following-sibling::span[@class='input__sub']");
    private SelenideElement errorCVCEmpty = $x("//*[text()='CVC/CVV']//following-sibling::span[@class='input__sub']");
    private SelenideElement errorCardNumberNotValid = $x("//*[text()='Номер карты']/following-sibling::*[text()='Неверный формат']");
    private SelenideElement errorOwnerNumber = $x("//*[text()='Владелец']/following-sibling::*[text()='Неверный формат']");
    private SelenideElement errorMonthNotValid = $x("//*[text()='Месяц']//following-sibling::span[@class='input__sub']");
    private SelenideElement errorYearNotValid = $x("//*[text()='Год']//following-sibling::span[@class='input__sub']");
    private SelenideElement errorMonthSpecialSymbols = $x("//*[text()='Месяц']/following-sibling::*[text()='Неверный формат']");
    private SelenideElement errorOwnerNotValid = $x("//*[text()='Владелец']//following-sibling::span[@class='input__sub']");//поле обязательно
    private SelenideElement errorCVCNotValid = $x("//*[text()='CVC/CVV']//following-sibling::span[@class='input__sub']");
    private SelenideElement errorYearExpired = $x("//*[text()='Год']//following-sibling::span[@class='input__sub']");
    private SelenideElement errorMonthPast = $x("//*[text()='Неверно указан срок действия карты']");
    private SelenideElement notificationError = $x("//*[text()='Ошибка! Банк отказал в проведении операции.']");
    private SelenideElement buttonRequestBank = $x("//*[text()='Отправляем запрос в Банк...']");

    public PaymentPage() {
        headingCardPayment.shouldBe(visible).shouldHave(text("Оплата по карте"));
    }


    public void getNotificationOk() {
        notificationApproved.shouldBe(visible, Duration.ofSeconds(300)).shouldHave(text("Операция одобрена Банком."));
    }

    public void getButtonRequestBank() {
        buttonRequestBank.shouldBe(visible).shouldHave(text("Отправляем запрос в Банк..."));
    }


    public void getNotificationError() {
        notificationError.shouldBe(visible).shouldHave(text("Ошибка! Банк отказал в проведении операции."), Duration.ofSeconds(300));
    }

    public void clickButtonContinue() {
        buttonContinue.click();
    }

    public void fillingAllFieldsValidValues(DataHelper.CardInfo info) {
        cardNumberField.setValue(DataHelper.getValidCard1Number());
        monthField.setValue(DataHelper.getValidMonth());
        yearField.setValue(DataHelper.getValidYear());
        ownerField.setValue(DataHelper.getOwner());
        CVCField.setValue(DataHelper.generateCVC());
        buttonContinue.click();
    }

    public void fillingCardNumberNotRegistered(DataHelper.CardInfo info) {
        cardNumberField.setValue(DataHelper.getNotRegisteredCardNumber());
        monthField.setValue(DataHelper.getValidMonth());
        yearField.setValue(DataHelper.getValidYear());
        ownerField.setValue(DataHelper.getOwner());
        CVCField.setValue(DataHelper.generateCVC());
        buttonContinue.click();
    }

    public void fillingCardNumberLessNumber(DataHelper.CardInfo info) {
        cardNumberField.setValue(DataHelper.getNotValidLessCardNumber());
        monthField.setValue(DataHelper.getValidMonth());
        yearField.setValue(DataHelper.getValidYear());
        ownerField.setValue(DataHelper.getOwner());
        CVCField.setValue(DataHelper.generateCVC());
        buttonContinue.click();
    }

    public void fillingCardNumberEmpty(DataHelper.CardInfo info) {
        monthField.setValue(DataHelper.getValidMonth());
        yearField.setValue(DataHelper.getValidYear());
        ownerField.setValue(DataHelper.getOwner());
        CVCField.setValue(DataHelper.generateCVC());
        buttonContinue.click();
    }

    public void fillingCardNumberNull(DataHelper.CardInfo info) {
        cardNumberField.setValue(DataHelper.getNotValidNullCardNumber());
        monthField.setValue(DataHelper.getValidMonth());
        yearField.setValue(DataHelper.getValidYear());
        ownerField.setValue(DataHelper.getOwner());
        CVCField.setValue(DataHelper.generateCVC());
        buttonContinue.click();
    }

    public void fillingMonthNull(DataHelper.CardInfo info) {
        cardNumberField.setValue(DataHelper.getValidCard1Number());
        monthField.setValue(DataHelper.getNullMonth());
        yearField.setValue(DataHelper.getValidYear());
        ownerField.setValue(DataHelper.getOwner());
        CVCField.setValue(DataHelper.generateCVC());
        buttonContinue.click();
    }

    public void fillingMonthEmpty(DataHelper.CardInfo info) {
        cardNumberField.setValue(DataHelper.getValidCard1Number());
        yearField.setValue(DataHelper.getValidYear());
        ownerField.setValue(DataHelper.getOwner());
        CVCField.setValue(DataHelper.generateCVC());
        buttonContinue.click();
    }

    public void fillingMonthPast(DataHelper.CardInfo info) {
        cardNumberField.setValue(DataHelper.getValidCard1Number());
        monthField.setValue(DataHelper.getPastMonth());
        yearField.setValue(DataHelper.getValidYear());
        ownerField.setValue(DataHelper.getOwner());
        CVCField.setValue(DataHelper.generateCVC());
        buttonContinue.click();
    }

    public void fillingMonthIncorrect(DataHelper.CardInfo info) {
        cardNumberField.setValue(DataHelper.getValidCard1Number());
        monthField.setValue(DataHelper.getIncorrectMonth());
        yearField.setValue(DataHelper.getValidYear());
        ownerField.setValue(DataHelper.getOwner());
        CVCField.setValue(DataHelper.generateCVC());
        buttonContinue.click();
    }

    public void fillingMonthSpecialSymbols(DataHelper.CardInfo info) {
        cardNumberField.setValue(DataHelper.getValidCard1Number());
        monthField.setValue(DataHelper.getSpecialSymbolsMonthAndYear());
        yearField.setValue(DataHelper.getValidYear());
        ownerField.setValue(DataHelper.getOwner());
        CVCField.setValue(DataHelper.generateCVC());
        buttonContinue.click();
    }

    public void fillingYearEmpty(DataHelper.CardInfo info) {
        cardNumberField.setValue(DataHelper.getValidCard1Number());
        monthField.setValue(DataHelper.getValidMonth());
        ownerField.setValue(DataHelper.getOwner());
        CVCField.setValue(DataHelper.generateCVC());
        buttonContinue.click();
    }

    public void fillingYearExpired(DataHelper.CardInfo info) {
        cardNumberField.setValue(DataHelper.getValidCard1Number());
        monthField.setValue(DataHelper.getValidMonth());
        yearField.setValue(DataHelper.getPastYear());
        ownerField.setValue(DataHelper.getOwner());
        CVCField.setValue(DataHelper.generateCVC());
        buttonContinue.click();
    }

    public void fillingOwnerEmpty(DataHelper.CardInfo info) {
        cardNumberField.setValue(DataHelper.getValidCard1Number());
        monthField.setValue(DataHelper.getValidMonth());
        yearField.setValue(DataHelper.getValidYear());
        CVCField.setValue(DataHelper.generateCVC());
        buttonContinue.click();
    }

    public void fillingOwnerNumbers(DataHelper.CardInfo info) {
        cardNumberField.setValue(DataHelper.getValidCard1Number());
        monthField.setValue(DataHelper.getValidMonth());
        yearField.setValue(DataHelper.getValidYear());
        ownerField.setValue(DataHelper.generateCVC());
        CVCField.setValue(DataHelper.generateCVC());
        buttonContinue.click();
    }

    public void fillingOwnerSpecialSymbols(DataHelper.CardInfo info) {
        cardNumberField.setValue(DataHelper.getValidCard1Number());
        monthField.setValue(DataHelper.getValidMonth());
        yearField.setValue(DataHelper.getValidYear());
        ownerField.setValue(DataHelper.getSpecialSymbolsMonthAndYear());
        CVCField.setValue(DataHelper.generateCVC());
        buttonContinue.click();
    }

    public void fillingCVCEmpty(DataHelper.CardInfo info) {
        cardNumberField.setValue(DataHelper.getValidCard1Number());
        monthField.setValue(DataHelper.getValidMonth());
        yearField.setValue(DataHelper.getValidYear());
        ownerField.setValue(DataHelper.getOwner());
        buttonContinue.click();
    }

    public void fillingCVCNull(DataHelper.CardInfo info) {
        cardNumberField.setValue(DataHelper.getValidCard1Number());
        monthField.setValue(DataHelper.getValidMonth());
        yearField.setValue(DataHelper.getValidYear());
        ownerField.setValue(DataHelper.getOwner());
        CVCField.setValue(DataHelper.getNullCVC());
        buttonContinue.click();
    }

    public void fillingCVCSpecialSymbols(DataHelper.CardInfo info) {
        cardNumberField.setValue(DataHelper.getValidCard1Number());
        monthField.setValue(DataHelper.getValidMonth());
        yearField.setValue(DataHelper.getValidYear());
        ownerField.setValue(DataHelper.getOwner());
        CVCField.setValue(DataHelper.getSpecialSymbolsCVC());
        buttonContinue.click();
    }

    public void fillingCVCLessSymbols(DataHelper.CardInfo info) {
        cardNumberField.setValue(DataHelper.getValidCard1Number());
        monthField.setValue(DataHelper.getValidMonth());
        yearField.setValue(DataHelper.getValidYear());
        ownerField.setValue(DataHelper.getOwner());
        CVCField.setValue(DataHelper.generateCVCLessSymbols());
        buttonContinue.click();
    }


    public void getErrorCardNumberEmpty() {
        errorCardNumberEmpty.shouldBe(visible).shouldHave(text("Поле обязательно для заполнения"));
    }

    public void getErrorMonthEmpty() {
        errorMonthEmpty.shouldBe(visible).shouldHave(text("Поле обязательно для заполнения"));
    }

    public void getErrorYearEmpty() {
        errorYearEmpty.shouldBe(visible).shouldHave(text("Поле обязательно для заполнения"));
    }

    public void getErrorOwnerEmpty() {
        errorOwnerEmpty.shouldBe(visible, Duration.ofSeconds(15)).shouldHave(text("Поле обязательно для заполнения"));
    }

    public void getErrorCVCEmpty() {
        errorCVCEmpty.shouldBe(visible).shouldHave(text("Поле обязательно для заполнения"));
    }

    public void getErrorCVCNotValid() {
        errorCVCNotValid.shouldBe(visible).shouldHave(text("Неверный формат"));
    }

    public void getErrorCardNumberNotValid() {
        errorCardNumberNotValid.shouldBe(visible).shouldHave(text("Неверный формат"));


    }

    public void getErrorOwnerNumber() {
        errorOwnerNotValid.shouldBe(visible).shouldHave(text("Неверный формат"));


    }

    public void getErrorMonthNotValid() {
        errorMonthNotValid.shouldBe(visible).shouldHave(text("Неверно указан срок действия карты"));
    }

    public void getErrorMonthSpecialSymbols() {
        errorMonthSpecialSymbols.shouldBe(visible, Duration.ofSeconds(30)).shouldHave(text("Неверный формат"));
    }


    public void getErrorYearNotValid() {
        errorYearNotValid.shouldBe(visible).shouldHave(text("Неверно указан срок действия карты"));
    }

    public void getErrorOwnerNotValid() {
        errorOwnerNotValid.shouldBe(visible).shouldHave(text("Неверный формат заполнения"));
    }


    public void getErrorYearExpired() {
        errorYearExpired.shouldBe(visible).shouldHave(text("Истёк срок действия карты"));
    }
}


