package test;

import data.DataHelper;
import data.SQLHelper;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.PaymentPage;
import page.StartPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.*;

public class CardTest {

    @BeforeEach
    void setUp() {
        open("http://localhost:8080");
    }

    @Test
    public void shouldBuyByPaymentCardAllValidValuesHappyPath1() {

        var paymentPage = new StartPage().goToPaymentPage();
        var cardInfo = DataHelper.getValidCardInfo();
        paymentPage.fillingAllFieldsValidValues(cardInfo);
        paymentPage.getButtonRequestBank();
        paymentPage.getNotificationOk();
        var paymentStatus = SQLHelper.getPaymentStatus();
        assertEquals("APPROVED", paymentStatus);

    }

    @Test
    public void shouldBuyByCreditAllValidValuesHappyPath2() {

        var creditPage = new StartPage().goToCreditPage();
        var cardInfo = DataHelper.getValidCardInfo();
        creditPage.fillingAllFieldsValidValues(cardInfo);
        creditPage.getButtonRequestBank();
        creditPage.getNotificationOk();
        var creditStatus = SQLHelper.getCreditStatus();
        assertEquals("APPROVED", creditStatus);

    }

    @Test
    public void shouldBuyByPaymentCardNotRegisteredNegativeTest1() {

        var paymentPage = new StartPage().goToPaymentPage();
        var cardInfo = DataHelper.getValidCardInfo();
        paymentPage.fillingCardNumberNotRegistered(cardInfo);
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
        var cardInfo = DataHelper.getValidCardInfo();
        creditPage.fillingCardNumberNotRegistered(cardInfo);
        creditPage.getButtonRequestBank();
        creditPage.getNotificationError();


    }

    @Test
    public void shouldBuyByPaymentCardLessCardNumberNegativeTest3() {

        var paymentPage = new StartPage().goToPaymentPage();
        var cardInfo = DataHelper.getValidCardInfo();
        paymentPage.fillingCardNumberLessNumber(cardInfo);
        paymentPage.getErrorCardNumberNotValid();

    }

    @Test
    public void shouldBuyByCreditLessCardNumberNegativeTest4() {

        var creditPage = new StartPage().goToCreditPage();
        var cardInfo = DataHelper.getValidCardInfo();
        creditPage.fillingCardNumberLessNumber(cardInfo);
        creditPage.getErrorCardNumberNotValid();

    }

    @Test
    public void shouldBuyByPaymentCardNumberEmptyNegativeTest5() {

        var paymentPage = new StartPage().goToPaymentPage();
        var cardInfo = DataHelper.getValidCardInfo();
        paymentPage.fillingCardNumberEmpty(cardInfo);
        paymentPage.getErrorCardNumberEmpty();

    }

    @Test
    public void shouldBuyByCreditCardNumberEmptyNegativeTest6() {

        var creditPage = new StartPage().goToPaymentPage();
        var cardInfo = DataHelper.getValidCardInfo();
        creditPage.fillingCardNumberEmpty(cardInfo);
        creditPage.getErrorCardNumberEmpty();

    }

    @Test
    public void shouldBuyByPaymentCardNumberNullNegativeTest7() {

        var paymentPage = new StartPage().goToPaymentPage();
        var cardInfo = DataHelper.getValidCardInfo();
        paymentPage.fillingCardNumberNull(cardInfo);
        paymentPage.getErrorCardNumberNotValid();

    }

    @Test
    public void shouldBuyByCreditCardNumberNullNegativeTest8() {

        var creditPage = new StartPage().goToCreditPage();
        var cardInfo = DataHelper.getValidCardInfo();
        creditPage.fillingCardNumberNull(cardInfo);
        creditPage.getErrorCardNumberNotValid();

    }

    @Test
    public void shouldBuyByPaymentMonthNullNegativeTest9() {

        var paymentPage = new StartPage().goToPaymentPage();
        var cardInfo = DataHelper.getValidCardInfo();
        paymentPage.fillingMonthNull(cardInfo);
        paymentPage.getErrorMonthNotValid();

    }

    @Test
    public void shouldBuyByCreditMonthNullNegativeTest10() {

        var creditPage = new StartPage().goToCreditPage();
        var cardInfo = DataHelper.getValidCardInfo();
        creditPage.fillingMonthNull(cardInfo);
        creditPage.getErrorMonthNotValid();

    }

    @Test
    public void shouldBuyByPaymentMonthEmptyNegativeTest11() {

        var paymentPage = new StartPage().goToPaymentPage();
        var cardInfo = DataHelper.getValidCardInfo();
        paymentPage.fillingMonthEmpty(cardInfo);
        paymentPage.getErrorMonthEmpty();

    }

    @Test
    public void shouldBuyByCreditMonthEmptyNegativeTest12() {

        var creditPage = new StartPage().goToCreditPage();
        var cardInfo = DataHelper.getValidCardInfo();
        creditPage.fillingMonthEmpty(cardInfo);
        creditPage.getErrorMonthEmpty();

    }

    @Test
    public void shouldBuyByPaymentPastMonthNegativeTest13() {

        var paymentPage = new StartPage().goToPaymentPage();
        var cardInfo = DataHelper.getValidCardInfo();
        paymentPage.fillingMonthPast(cardInfo);
        paymentPage.getErrorMonthNotValid();

    }

    @Test
    public void shouldBuyByCreditPastMonthNegativeTest14() {

        var creditPage = new StartPage().goToCreditPage();
        var cardInfo = DataHelper.getValidCardInfo();
        creditPage.fillingMonthPast(cardInfo);
        //creditPage.getErrorMonthPast();
        creditPage.getErrorMonthNotValid();
    }

    @Test
    public void shouldBuyByPaymentIncorrectMonthNegativeTest15() {

        var paymentPage = new StartPage().goToPaymentPage();
        var cardInfo = DataHelper.getValidCardInfo();
        paymentPage.fillingMonthIncorrect(cardInfo);
        paymentPage.getErrorMonthNotValid();

    }

    @Test
    public void shouldBuyByCreditIncorrectMonthNegativeTest16() {

        var creditPage = new StartPage().goToCreditPage();
        var cardInfo = DataHelper.getValidCardInfo();
        creditPage.fillingMonthIncorrect(cardInfo);
        creditPage.getErrorMonthNotValid();

    }

    @Test
    public void shouldBuyByPaymentMonthSpecialSymbolsNegativeTest17() {

        var paymentPage = new StartPage().goToPaymentPage();
        var cardInfo = DataHelper.getValidCardInfo();
        paymentPage.fillingMonthSpecialSymbols(cardInfo);
        paymentPage.getErrorMonthSpecialSymbols();

    }

    @Test
    public void shouldBuyByCreditMonthSpecialSymbolsNegativeTest18() {

        var creditPage = new StartPage().goToCreditPage();
        var cardInfo = DataHelper.getValidCardInfo();
        creditPage.fillingMonthSpecialSymbols(cardInfo);
        creditPage.getErrorMonthSpecialSymbols();

    }

    @Test
    public void shouldBuyByPaymentYearEmptyNegativeTest19() {

        var paymentPage = new StartPage().goToPaymentPage();
        var cardInfo = DataHelper.getValidCardInfo();
        paymentPage.fillingYearEmpty(cardInfo);
        paymentPage.getErrorYearEmpty();

    }

    @Test
    public void shouldBuyByPaymentYearEmptyNegativeTest20() {

        var creditPage = new StartPage().goToCreditPage();
        var cardInfo = DataHelper.getValidCardInfo();
        creditPage.fillingYearEmpty(cardInfo);
        creditPage.getErrorYearEmpty();

    }

    @Test
    public void shouldBuyByPaymentYearExpiredNegativeTest21() {

        var paymentPage = new StartPage().goToPaymentPage();
        var cardInfo = DataHelper.getValidCardInfo();
        paymentPage.fillingYearExpired(cardInfo);
        paymentPage.getErrorYearExpired();

    }

    @Test
    public void shouldBuyByCreditYearExpiredNegativeTest22() {

        var creditPage = new StartPage().goToCreditPage();
        var cardInfo = DataHelper.getValidCardInfo();
        creditPage.fillingYearExpired(cardInfo);
        creditPage.getErrorYearExpired();

    }

    @Test
    public void shouldBuyByPaymentOwnerEmptyNegativeTest23() {

        var paymentPage = new StartPage().goToPaymentPage();
        var cardInfo = DataHelper.getValidCardInfo();
        paymentPage.fillingOwnerEmpty(cardInfo);
        paymentPage.getErrorOwnerEmpty();

    }

    @Test
    public void shouldBuyByPaymentOwnerEmptyNegativeTest24() {

        var creditPage = new StartPage().goToCreditPage();
        var cardInfo = DataHelper.getValidCardInfo();
        creditPage.fillingOwnerEmpty(cardInfo);
        creditPage.getErrorOwnerEmpty();

    }

    @Test
    public void shouldBuyByPaymentOwnerNumbersNegativeTest25() {

        var paymentPage = new StartPage().goToPaymentPage();
        var cardInfo = DataHelper.getValidCardInfo();
        paymentPage.fillingOwnerNumbers(cardInfo);
        paymentPage.getErrorOwnerNumber();

    }

    @Test
    public void shouldBuyByCreditOwnerNumbersNegativeTest26() {

        var creditPage = new StartPage().goToCreditPage();
        var cardInfo = DataHelper.getValidCardInfo();
        creditPage.fillingOwnerNumbers(cardInfo);
        creditPage.getErrorOwnerNumber();

    }

    @Test
    public void shouldBuyByPaymentOwnerSpecialSymbolsNegativeTest27() {

        var paymentPage = new StartPage().goToPaymentPage();
        var cardInfo = DataHelper.getValidCardInfo();
        paymentPage.fillingOwnerSpecialSymbols(cardInfo);
        paymentPage.getErrorOwnerNumber();

    }

    @Test
    public void shouldBuyByCreditOwnerSpecialSymbolsNegativeTest28() {

        var creditPage = new StartPage().goToCreditPage();
        var cardInfo = DataHelper.getValidCardInfo();
        creditPage.fillingOwnerSpecialSymbols(cardInfo);
        creditPage.getErrorOwnerNumber();

    }

    @Test
    public void shouldBuyByPaymentCVCEmptyNegativeTest29() {

        var paymentPage = new StartPage().goToPaymentPage();
        var cardInfo = DataHelper.getValidCardInfo();
        paymentPage.fillingCVCEmpty(cardInfo);
        paymentPage.getErrorCVCEmpty();

    }


    @Test
    public void shouldBuyByCreditCVCEmptyNegativeTest30() {
        var creditPage = new StartPage().goToCreditPage();
        var cardInfo = DataHelper.getValidCardInfo();
        creditPage.fillingCVCEmpty(cardInfo);
        creditPage.getErrorCVCEmpty();

    }

    @Test
    public void shouldBuyByPaymentCVCNullNegativeTest31() {

        var paymentPage = new StartPage().goToPaymentPage();
        var cardInfo = DataHelper.getValidCardInfo();
        paymentPage.fillingCVCNull(cardInfo);
        paymentPage.getErrorCVCNotValid();

    }

    @Test
    public void shouldBuyByCreditCVCNullNegativeTest32() {

        var creditPage = new StartPage().goToCreditPage();
        var cardInfo = DataHelper.getValidCardInfo();
        creditPage.fillingCVCNull(cardInfo);
        creditPage.getErrorCVCNotValid();

    }

    @Test
    public void shouldBuyByPaymentCVCSpecialSymbolsNegativeTest33() {

        var paymentPage = new StartPage().goToPaymentPage();
        var cardInfo = DataHelper.getValidCardInfo();
        paymentPage.fillingCVCSpecialSymbols(cardInfo);
        paymentPage.getErrorCVCNotValid();

    }

    @Test
    public void shouldBuyByCreditCVCSpecialSymbolsNegativeTest34() {

        var creditPage = new StartPage().goToCreditPage();
        var cardInfo = DataHelper.getValidCardInfo();
        creditPage.fillingCVCSpecialSymbols(cardInfo);
        creditPage.getErrorCVCNotValid();

    }

    @Test
    public void shouldBuyByPaymentCVCSpecialSymbolsNegativeTest35() {

        var paymentPage = new StartPage().goToPaymentPage();
        var cardInfo = DataHelper.getValidCardInfo();
        paymentPage.fillingCVCLessSymbols(cardInfo);
        paymentPage.getErrorCVCNotValid();

    }

    @Test
    public void shouldBuyByCreditCVCSpecialSymbolsNegativeTest36() {

        var creditPage = new StartPage().goToCreditPage();
        var cardInfo = DataHelper.getValidCardInfo();
        creditPage.fillingCVCLessSymbols(cardInfo);
        creditPage.getErrorCVCNotValid();

    }


}













