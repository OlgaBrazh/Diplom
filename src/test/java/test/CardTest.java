package test;

import com.codeborne.selenide.logevents.SelenideLogger;
import data.DataHelper;
import data.SQLHelper;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.PaymentPage;
import page.StartPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.*;

public class CardTest {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }


    @BeforeEach
    void setUp() {
        open("http://localhost:8080");
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    public void shouldBuyByPaymentCardAllValidValuesHappyPath1() {

        var paymentPage = new StartPage().goToPaymentPage();
        var cardInfo = DataHelper.getValidCardInfo();
        paymentPage.fillingCardForm(cardInfo);
        paymentPage.getButtonRequestBank();
        paymentPage.getNotificationOk();
        var paymentStatus = SQLHelper.getPaymentStatus();
        assertEquals("APPROVED", paymentStatus);

    }

    @Test
    public void shouldBuyByCreditAllValidValuesHappyPath2() {

        var creditPage = new StartPage().goToCreditPage();
        var cardInfo = DataHelper.getValidCardInfo();
        creditPage.fillingCardForm(cardInfo);
        creditPage.getButtonRequestBank();
        creditPage.getNotificationOk();
        var creditStatus = SQLHelper.getCreditStatus();
        assertEquals("APPROVED", creditStatus);

    }

    @Test
    public void shouldBuyByPaymentCardNotRegisteredNegativeTest1() {

        var paymentPage = new StartPage().goToPaymentPage();
        var cardInfo = DataHelper.getCardInfoNotRegisteredCard();
        paymentPage.fillingCardForm(cardInfo);
        paymentPage.getButtonRequestBank();
        paymentPage.getNotificationError();

        //var transactionId = SQLHelper.getTransactionId();
        //var paymentID = SQLHelper.getPaymentId();
        //assertEquals(transactionId, paymentID);
        //assertNull(paymentStatus);
        //assertEquals(transactionId, paymentID);

    }

    @Test
    public void shouldBuyByCreditCardNotRegisteredNegativeTest2() {

        var creditPage = new StartPage().goToCreditPage();
        var cardInfo = DataHelper.getCardInfoNotRegisteredCard();
        creditPage.fillingCardForm(cardInfo);
        creditPage.getButtonRequestBank();
        creditPage.getNotificationError();


    }

    @Test
    public void shouldBuyByPaymentCardLessCardNumberNegativeTest3() {

        var paymentPage = new StartPage().goToPaymentPage();
        var cardInfo = DataHelper.getCardInfoLessCardNumber();
        paymentPage.fillingCardForm(cardInfo);
        paymentPage.getErrorCardNumberNotValid();

    }

    @Test
    public void shouldBuyByCreditLessCardNumberNegativeTest4() {

        var creditPage = new StartPage().goToCreditPage();
        var cardInfo = DataHelper.getCardInfoLessCardNumber();
        creditPage.fillingCardForm(cardInfo);
        creditPage.getErrorCardNumberNotValid();

    }

    @Test
    public void shouldBuyByPaymentCardNumberEmptyNegativeTest5() {

        var paymentPage = new StartPage().goToPaymentPage();
        var cardInfo = DataHelper.getCardInfoEmptyCardNumber();
        paymentPage.fillingCardForm(cardInfo);
        paymentPage.getErrorCardNumberEmpty();

    }

    @Test
    public void shouldBuyByCreditCardNumberEmptyNegativeTest6() {

        var creditPage = new StartPage().goToPaymentPage();
        var cardInfo = DataHelper.getCardInfoEmptyCardNumber();
        creditPage.fillingCardForm(cardInfo);
        creditPage.getErrorCardNumberEmpty();

    }

    @Test
    public void shouldBuyByPaymentCardNumberNullNegativeTest7() {

        var paymentPage = new StartPage().goToPaymentPage();
        var cardInfo = DataHelper.getCardInfoNullCardNumber();
        paymentPage.fillingCardForm(cardInfo);
        paymentPage.getErrorCardNumberNotValid();

    }

    @Test
    public void shouldBuyByCreditCardNumberNullNegativeTest8() {

        var creditPage = new StartPage().goToCreditPage();
        var cardInfo = DataHelper.getCardInfoNullCardNumber();
        creditPage.fillingCardForm(cardInfo);
        creditPage.getErrorCardNumberNotValid();

    }

    @Test
    public void shouldBuyByPaymentMonthNullNegativeTest9() {

        var paymentPage = new StartPage().goToPaymentPage();
        var cardInfo = DataHelper.getCardInfoNullMonth();
        paymentPage.fillingCardForm(cardInfo);
        paymentPage.getErrorMonthNotValid();

    }

    @Test
    public void shouldBuyByCreditMonthNullNegativeTest10() {

        var creditPage = new StartPage().goToCreditPage();
        var cardInfo = DataHelper.getCardInfoNullMonth();
        creditPage.fillingCardForm(cardInfo);
        creditPage.getErrorMonthNotValid();

    }

    @Test
    public void shouldBuyByPaymentMonthEmptyNegativeTest11() {

        var paymentPage = new StartPage().goToPaymentPage();
        var cardInfo = DataHelper.getCardInfoEmptyMonth();
        paymentPage.fillingCardForm(cardInfo);
        paymentPage.getErrorMonthEmpty();

    }

    @Test
    public void shouldBuyByCreditMonthEmptyNegativeTest12() {

        var creditPage = new StartPage().goToCreditPage();
        var cardInfo = DataHelper.getCardInfoEmptyMonth();
        creditPage.fillingCardForm(cardInfo);
        creditPage.getErrorMonthEmpty();

    }

    @Test
    public void shouldBuyByPaymentPastMonthNegativeTest13() {

        var paymentPage = new StartPage().goToPaymentPage();
        var cardInfo = DataHelper.getCardInfoPastMonth();
        paymentPage.fillingCardForm(cardInfo);
        paymentPage.getErrorMonthNotValid();

    }

    @Test
    public void shouldBuyByCreditPastMonthNegativeTest14() {

        var creditPage = new StartPage().goToCreditPage();
        var cardInfo = DataHelper.getCardInfoPastMonth();
        creditPage.fillingCardForm(cardInfo);
        creditPage.getErrorMonthNotValid();
    }

    @Test
    public void shouldBuyByPaymentIncorrectMonthNegativeTest15() {

        var paymentPage = new StartPage().goToPaymentPage();
        var cardInfo = DataHelper.getCardInfoIncorrectMonth();
        paymentPage.fillingCardForm(cardInfo);
        paymentPage.getErrorMonthNotValid();

    }

    @Test
    public void shouldBuyByCreditIncorrectMonthNegativeTest16() {

        var creditPage = new StartPage().goToCreditPage();
        var cardInfo = DataHelper.getCardInfoIncorrectMonth();
        creditPage.fillingCardForm(cardInfo);
        creditPage.getErrorMonthNotValid();

    }

    @Test
    public void shouldBuyByPaymentMonthSpecialSymbolsNegativeTest17() {

        var paymentPage = new StartPage().goToPaymentPage();
        var cardInfo = DataHelper.getCardInfoSpecialSymbolsInMonth();
        paymentPage.fillingCardForm(cardInfo);
        paymentPage.getErrorMonthSpecialSymbols();

    }

    @Test
    public void shouldBuyByCreditMonthSpecialSymbolsNegativeTest18() {

        var creditPage = new StartPage().goToCreditPage();
        var cardInfo = DataHelper.getCardInfoSpecialSymbolsInMonth();
        creditPage.fillingCardForm(cardInfo);
        creditPage.getErrorMonthSpecialSymbols();

    }

    @Test
    public void shouldBuyByPaymentYearEmptyNegativeTest19() {

        var paymentPage = new StartPage().goToPaymentPage();
        var cardInfo = DataHelper.getCardInfoEmptyYear();
        paymentPage.fillingCardForm(cardInfo);
        paymentPage.getErrorYearEmpty();

    }

    @Test
    public void shouldBuyByPaymentYearEmptyNegativeTest20() {

        var creditPage = new StartPage().goToCreditPage();
        var cardInfo = DataHelper.getCardInfoEmptyYear();
        creditPage.fillingCardForm(cardInfo);
        creditPage.getErrorYearEmpty();

    }

    @Test
    public void shouldBuyByPaymentYearExpiredNegativeTest21() {

        var paymentPage = new StartPage().goToPaymentPage();
        var cardInfo = DataHelper.getCardInfoExpiredYear();
        paymentPage.fillingCardForm(cardInfo);
        paymentPage.getErrorYearExpired();

    }

    @Test
    public void shouldBuyByCreditYearExpiredNegativeTest22() {

        var creditPage = new StartPage().goToCreditPage();
        var cardInfo = DataHelper.getCardInfoExpiredYear();
        creditPage.fillingCardForm(cardInfo);
        creditPage.getErrorYearExpired();

    }

    @Test
    public void shouldBuyByPaymentOwnerEmptyNegativeTest23() {

        var paymentPage = new StartPage().goToPaymentPage();
        var cardInfo = DataHelper.getCardInfoEmptyOwner();
        paymentPage.fillingCardForm(cardInfo);
        paymentPage.getErrorOwnerEmpty();

    }

    @Test
    public void shouldBuyByPaymentOwnerEmptyNegativeTest24() {

        var creditPage = new StartPage().goToCreditPage();
        var cardInfo = DataHelper.getCardInfoEmptyOwner();
        creditPage.fillingCardForm(cardInfo);
        creditPage.getErrorOwnerEmpty();

    }

    @Test
    public void shouldBuyByPaymentOwnerNumbersNegativeTest25() {

        var paymentPage = new StartPage().goToPaymentPage();
        var cardInfo = DataHelper.getCardInfoNumbersOwner();
        paymentPage.fillingCardForm(cardInfo);
        paymentPage.getErrorOwnerNumber();

    }

    @Test
    public void shouldBuyByCreditOwnerNumbersNegativeTest26() {

        var creditPage = new StartPage().goToCreditPage();
        var cardInfo = DataHelper.getCardInfoNumbersOwner();
        creditPage.fillingCardForm(cardInfo);
        creditPage.getErrorOwnerNumber();

    }

    @Test
    public void shouldBuyByPaymentOwnerSpecialSymbolsNegativeTest27() {

        var paymentPage = new StartPage().goToPaymentPage();
        var cardInfo = DataHelper.getCardInfoSpecialSymbolsInOwner();
        paymentPage.fillingCardForm(cardInfo);
        paymentPage.getErrorOwnerNumber();

    }

    @Test
    public void shouldBuyByCreditOwnerSpecialSymbolsNegativeTest28() {

        var creditPage = new StartPage().goToCreditPage();
        var cardInfo = DataHelper.getCardInfoSpecialSymbolsInOwner();
        creditPage.fillingCardForm(cardInfo);
        creditPage.getErrorOwnerNumber();

    }

    @Test
    public void shouldBuyByPaymentCVCEmptyNegativeTest29() {

        var paymentPage = new StartPage().goToPaymentPage();
        var cardInfo = DataHelper.getCardInfoEmptyCVC();
        paymentPage.fillingCardForm(cardInfo);
        paymentPage.getErrorCVCEmpty();

    }


    @Test
    public void shouldBuyByCreditCVCEmptyNegativeTest30() {
        var creditPage = new StartPage().goToCreditPage();
        var cardInfo = DataHelper.getCardInfoEmptyCVC();
        creditPage.fillingCardForm(cardInfo);
        creditPage.getErrorCVCEmpty();

    }

    @Test
    public void shouldBuyByPaymentCVCNullNegativeTest31() {

        var paymentPage = new StartPage().goToPaymentPage();
        var cardInfo = DataHelper.getCardInfoNullCVC();
        paymentPage.fillingCardForm(cardInfo);
        paymentPage.getErrorCVCNotValid();

    }

    @Test
    public void shouldBuyByCreditCVCNullNegativeTest32() {

        var creditPage = new StartPage().goToCreditPage();
        var cardInfo = DataHelper.getCardInfoNullCVC();
        creditPage.fillingCardForm(cardInfo);
        creditPage.getErrorCVCNotValid();

    }

    @Test
    public void shouldBuyByPaymentCVCSpecialSymbolsNegativeTest33() {

        var paymentPage = new StartPage().goToPaymentPage();
        var cardInfo = DataHelper.getCardInfoSpecialSymbolsInCVC();
        paymentPage.fillingCardForm(cardInfo);
        paymentPage.getErrorCVCNotValid();

    }

    @Test
    public void shouldBuyByCreditCVCSpecialSymbolsNegativeTest34() {

        var creditPage = new StartPage().goToCreditPage();
        var cardInfo = DataHelper.getCardInfoSpecialSymbolsInCVC();
        creditPage.fillingCardForm(cardInfo);
        creditPage.getErrorCVCNotValid();

    }

    @Test
    public void shouldBuyByPaymentCVCSpecialSymbolsNegativeTest35() {

        var paymentPage = new StartPage().goToPaymentPage();
        var cardInfo = DataHelper.getCardInfoLessSymbolsInCVC();
        paymentPage.fillingCardForm(cardInfo);
        paymentPage.getErrorCVCNotValid();

    }

    @Test
    public void shouldBuyByCreditCVCSpecialSymbolsNegativeTest36() {

        var creditPage = new StartPage().goToCreditPage();
        var cardInfo = DataHelper.getCardInfoLessSymbolsInCVC();
        creditPage.fillingCardForm(cardInfo);
        creditPage.getErrorCVCNotValid();

    }


}













