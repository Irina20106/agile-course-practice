package ru.unn.agile.numbersIn-words.model;
import java.text.DecimalFormat;
public final class NumbersInWords {
    private static final String[] tensNames = {
            ""," Ten"," Twenty"," Thirty"," Forty"," Fifty"," Sixty"," Seventy"," Eighty"," Ninety"
    };
    private static final String[] numNames = {
            ""," One"," Two"," Three"," Four"," Five"," Six"," Seven"," Eight"," Nine"," Ten",
            " Eleven"," Twelve"," Thirteen"," Fourteen"," Fifteen"," Sixteen"," Seventeen"," Eighteen"," Nineteen"
    };

    private static final int TEN = 10;
    private static final int HUNDRED = 100;
    private static final int ZERO = 0;
    private static final int THREE = 3;
    private static final int SIX = 6;
    private static final int NINE = 9;
    private static final int TWELVE = 12;

    private NumbersInWords() {
        /* constructor not needed here */
    }
    private static String convertLessThanOneThousand(final int number) {
        String soFar;
        int newNumber = number;
        if (number % HUNDRED < 20){
            soFar = numNames[number % HUNDRED];
            newNumber = number / HUNDRED;
        }
        else {
            soFar = numNames[number % TEN];
            newNumber = number / TEN;
            soFar = tensNames[newNumber % TEN] + soFar;
            newNumber = newNumber / TEN;
        }
        if (number == 0) return soFar;
        return numNames[newNumber] + " hundred" + soFar;
    }
    public static String convert(long number) {
        if (number == 0) {
            return "zero";
        }
        String snumber = Long.toString(number);
        String mask = "000000000000";
        DecimalFormat df = new DecimalFormat(mask);
        snumber = df.format(number);

        int billions = Integer.parseInt(snumber.substring(ZERO,THREE));
        int millions  = Integer.parseInt(snumber.substring(THREE,SIX));
        int hundredThousands = Integer.parseInt(snumber.substring(SIX,NINE));
        int thousands = Integer.parseInt(snumber.substring(NINE,TWELVE));

        String tradBillions;
        switch (billions) {
            case 0:
                tradBillions = "";
                break;
            default :
                tradBillions = convertLessThanOneThousand(billions) + " billion ";
        }
        String result =  tradBillions;

        String tradMillions;
        switch (millions) {
            case 0:
                tradMillions = "";
                break;
            default :
                tradMillions = convertLessThanOneThousand(millions) + " million ";
        }
        result =  result + tradMillions;

        String tradHundredThousands;
        switch (hundredThousands) {
            case 0:
                tradHundredThousands = "";
                break;
                default :
                    tradHundredThousands = convertLessThanOneThousand(hundredThousands) + " thousand ";
        }
        result =  result + tradHundredThousands;

        String tradThousand;
        tradThousand = convertLessThanOneThousand(thousands);
        result =  result + tradThousand;
        return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
    }
}
