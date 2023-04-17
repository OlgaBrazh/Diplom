package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class StartPage {

    private SelenideElement heading = $x("//*[@id='root']");
    private SelenideElement buttonBuy = $x("//*[text()='Купить']");
    private SelenideElement buttonBuyInCredit = $x("//*[text()='Купить в кредит']");

    public StartPage() {
        heading.shouldBe(visible);
    }

    public PaymentPage goToPaymentPage() {
        buttonBuy.click();
        return new PaymentPage();
    }

    public CreditPage goToCreditPage() {
        buttonBuyInCredit.click();
        return new CreditPage();
    }
}


