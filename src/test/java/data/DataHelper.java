package data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class DataHelper {

    private DataHelper() {

    }

    /*Метод для получения карты 1 с валидным номером*/
    public static String getValidCard1Number() {

        return "4444 4444 4444 4441";
    }

    /*Метод для получения карты 2 с валидным номером*/
    private static String getValidCard2Number() {

        return "4444 4444 4444 4442";
    }

    /*Метод получения номера незарегистрированной карты*/
    public static String getNotRegisteredCardNumber() {

        return "0123 4465 7890 4442";
    }

    /*Метод получения невалидного номера карты (короткий номер)*/
    public static String getNotValidLessCardNumber() {

        return "365";
    }

    public static String getNotValidNullCardNumber() {

        return "0000 0000 0000 0000";
    }

    /*Метод для получения валидного значения месяца*/
    public static String getValidMonth() {
        return LocalDate.now().plusMonths(6).format(DateTimeFormatter.ofPattern("MM"));
    }

    /*Метод для получения значения прошедшего месяца*/
    public static String getPastMonth() {
        return LocalDate.now().minusMonths(2).format(DateTimeFormatter.ofPattern("MM"));
    }

    /*Метод для получения несуществующего значения месяца*/
    public static String getIncorrectMonth() {

        return "13";
    }

    /*Метод для получения нулевого значения месяца*/
    public static String getNullMonth() {

        return "00";
    }

    public static String getNullYear() {

        return "00";
    }

    /*Метод для получения комбинации из двух специальных символов для введения в поля Месяц и Год*/
    public static String getSpecialSymbolsMonthAndYear() {
        Random random = new Random();
        String[] specialSymbols = new String[]{"!", "\"", "#", "$", "%", "&"};
        var fistSymbol = specialSymbols[random.nextInt(6)];
        var secondSymbol = specialSymbols[random.nextInt(6)];
        return fistSymbol + secondSymbol;
    }

    /*Метод для получения валидного значения года*/
    public static String getValidYear() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yy"));
    }

    /*Метод для получения значения прошедшего года*/
    public static String getPastYear() {
        return LocalDate.now().minusYears(2).format(DateTimeFormatter.ofPattern("yy"));
    }

    /*Метод для получения валидного значения поля Владелец*/

    public static String getOwner() {
        Faker faker = new Faker();
        return faker.name().fullName();
    }

    /*Метод для получения числовой комбинации поля Владелец*/
    private static String getIncorrectOwner() {
        return "12345";
    }

    /*Метод для генерации кода СVC из трех символов*/
    public static String generateCVC() {
        Faker faker = new Faker();
        return (faker.numerify("###"));
    }

    /*Метод для генерации кода СVC из двух символов*/
    public static String generateCVCLessSymbols() {
        Faker faker = new Faker();
        return (faker.numerify("##"));
    }


    /*Метод для получения нулевого значения поля CVC*/
    public static String getNullCVC() {

        return "000";
    }

    /*Метод для получения комбинации из трех специальных символов для введения в поле CVC*/
    public static String getSpecialSymbols() {
        Random random = new Random();
        String[] specialSymbols = new String[]{"!", "\"", "#", "$", "%", "&"};
        var Symbol1 = specialSymbols[random.nextInt(6)];
        var Symbol2 = specialSymbols[random.nextInt(6)];
        var Symbol3 = specialSymbols[random.nextInt(6)];
        return Symbol1 + Symbol2 + Symbol3;
    }


    @Value
    public static class CardInfo {
        private String cardNumber;
        private String month;
        private String year;
        private String cardOwner;
        private String cvc;
    }

    public static CardInfo getValidCardInfo() {
        return new CardInfo(getValidCard1Number(), getValidMonth(), getValidYear(), getOwner(), generateCVC());
    }

    public static CardInfo getCardInfoNotRegisteredCard() {
        return new CardInfo(getNotRegisteredCardNumber(), getValidMonth(), getValidYear(), getOwner(), generateCVC());
    }

    public static CardInfo getCardInfoLessCardNumber() {
        return new CardInfo(getNotValidLessCardNumber(), getValidMonth(), getValidYear(), getOwner(), generateCVC());
    }

    public static CardInfo getCardInfoEmptyCardNumber() {
        return new CardInfo("", getValidMonth(), getValidYear(), getOwner(), generateCVC());
    }

    public static CardInfo getCardInfoNullCardNumber() {
        return new CardInfo(getNotValidNullCardNumber(), getValidMonth(), getValidYear(), getOwner(), generateCVC());
    }

    public static CardInfo getCardInfoNullMonth() {
        return new CardInfo(getValidCard1Number(), getNullMonth(), getValidYear(), getOwner(), generateCVC());
    }

    public static CardInfo getCardInfoEmptyMonth() {
        return new CardInfo(getValidCard1Number(), "", getValidYear(), getOwner(), generateCVC());
    }

    public static CardInfo getCardInfoPastMonth() {
        return new CardInfo(getValidCard1Number(), getPastMonth(), getValidYear(), getOwner(), generateCVC());
    }

    public static CardInfo getCardInfoIncorrectMonth() {
        return new CardInfo(getValidCard1Number(), getIncorrectMonth(), getValidYear(), getOwner(), generateCVC());
    }

    public static CardInfo getCardInfoSpecialSymbolsInMonth() {
        return new CardInfo(getValidCard1Number(), getSpecialSymbolsMonthAndYear(), getValidYear(), getOwner(), generateCVC());
    }

    public static CardInfo getCardInfoEmptyYear() {
        return new CardInfo(getValidCard1Number(), getValidMonth(), "", getOwner(), generateCVC());
    }

    public static CardInfo getCardInfoExpiredYear() {
        return new CardInfo(getValidCard1Number(), getValidMonth(), getPastYear(), getOwner(), generateCVC());
    }

    public static CardInfo getCardInfoEmptyOwner() {
        return new CardInfo(getValidCard1Number(), getValidMonth(), getValidYear(), "", generateCVC());
    }

    public static CardInfo getCardInfoNumbersOwner() {
        return new CardInfo(getValidCard1Number(), getValidMonth(), getValidYear(), getIncorrectOwner(), generateCVC());
    }

    public static CardInfo getCardInfoSpecialSymbolsInOwner() {
        return new CardInfo(getValidCard1Number(), getValidMonth(), getValidYear(), getSpecialSymbols(), generateCVC());
    }

    public static CardInfo getCardInfoEmptyCVC() {
        return new CardInfo(getValidCard1Number(), getValidMonth(), getValidYear(), getOwner(), "");
    }

    public static CardInfo getCardInfoNullCVC() {
        return new CardInfo(getValidCard1Number(), getValidMonth(), getValidYear(), getOwner(), getNullCVC());
    }

    public static CardInfo getCardInfoSpecialSymbolsInCVC() {
        return new CardInfo(getValidCard1Number(), getValidMonth(), getValidYear(), getOwner(), getSpecialSymbols());
    }

    public static CardInfo getCardInfoLessSymbolsInCVC() {
        return new CardInfo(getValidCard1Number(), getValidMonth(), getValidYear(), getOwner(), generateCVCLessSymbols());
    }


}
