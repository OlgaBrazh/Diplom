package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CreditPage {

    private SelenideElement headingCardCredit = $x("//*[text()='Кредит по данным карты']");
    private SelenideElement cardNumberField = $x("//*[text()='Номер карты']/following-sibling::*/input[@class='input__control']");
    private SelenideElement monthField = $x("//*[text()='Месяц']/following-sibling::*/input[@class='input__control']");
    private SelenideElement yearField = $x("//*[text()='Год']/following-sibling::*/input[@class='input__control']");
    private SelenideElement ownerField = $x("//*[text()='Владелец']/following-sibling::*/input[@class='input__control']");
    private SelenideElement CVCField = $x("//*[text()='CVC/CVV']/following-sibling::*/input[@class='input__control']");
    private SelenideElement buttonContinue = $x("//*[text()='Продолжить']");
    private SelenideElement buttonRequestBank = $x("//*[text()='Отправляем запрос в Банк...']");
    private SelenideElement notificationApproved = $x("//*[text()='Операция одобрена Банком.']");
    private SelenideElement notificationError = $x("//*[text()='Ошибка! Банк отказал в проведении операции.']");


    private SelenideElement errorCardNumber = $x("//*[text()='Номер карты']//following-sibling::span[@class='input__sub']");
    private SelenideElement errorMonth = $x("//*[text()='Месяц']/following-sibling::span[@class='input__sub']");

    private SelenideElement errorYear = $x("//*[text()='Год']//following-sibling::span[@class='input__sub']");
    private SelenideElement errorOwner = $x("//*[text()='Владелец']/following-sibling::span[@class='input__sub']");
    private SelenideElement errorCVC = $x("//*[text()='CVC/CVV']/following-sibling::span[@class='input__sub']");


    public CreditPage() {

        headingCardCredit.shouldBe(visible);
    }

    public void getNotificationOk() {
        notificationApproved.shouldBe(visible, Duration.ofSeconds(300));
    }

    public void getButtonRequestBank() {
        buttonRequestBank.shouldBe(visible, Duration.ofSeconds(300));
    }


    public void getNotificationError() {
        notificationError.shouldBe(visible, Duration.ofSeconds(300));
    }

    public void clickButtonContinue() {

        buttonContinue.click();
    }

    public void getErrorCardNumberEmpty() {
        errorCardNumber.shouldHave(text("Поле обязательно для заполнения")).shouldBe(visible);
    }

    public void getErrorCardNumberNotValid() {
        errorCardNumber.shouldHave(text("Неверный формат")).shouldBe(visible);
    }

    public void getErrorMonthEmpty() {
        errorMonth.shouldHave(text("Поле обязательно для заполнения")).shouldBe(visible);
    }

    public void getErrorMonthSpecialSymbols() {
        errorMonth.shouldHave(text("Неверный формат")).shouldBe(visible);
    }

    public void getErrorMonthNotValid() {
        errorMonth.shouldHave(text("Неверно указан срок действия карты")).shouldBe(visible);
    }

    public void getErrorYearEmpty() {
        errorYear.shouldHave(text("Поле обязательно для заполнения")).shouldBe(visible);
    }

    public void getErrorYearExpired() {
        errorYear.shouldHave(text("Истёк срок действия карты")).shouldBe(visible);
    }

    public void getErrorYearNotValid() {
        errorYear.shouldHave(text("Неверно указан срок действия карты")).shouldBe(visible);
    }

    public void getErrorOwnerEmpty() {
        errorOwner.shouldHave(text("Поле обязательно для заполнения")).shouldBe(visible, Duration.ofSeconds(15));
    }

    public void getErrorOwnerNumber() {
        errorOwner.shouldHave(text("Неверный формат")).shouldBe(visible);
    }

    public void getErrorOwnerNotValid() {
        errorOwner.shouldHave(text("Неверный формат заполнения")).shouldBe(visible);
    }

    public void getErrorCVCEmpty() {
        errorCVC.shouldHave(text("Поле обязательно для заполнения")).shouldBe(visible);
    }

    public void getErrorCVCNotValid() {
        errorCVC.shouldHave(text("Неверный формат")).shouldBe(visible);
    }

    public void fillingCardForm(DataHelper.CardInfo info) {
        cardNumberField.setValue(DataHelper.getValidCard1Number());
        monthField.setValue(DataHelper.getValidMonth());
        yearField.setValue(DataHelper.getValidYear());
        ownerField.setValue(DataHelper.getOwner());
        CVCField.setValue(DataHelper.generateCVC());
        buttonContinue.click();
    }
}
