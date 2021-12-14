import java.text.DecimalFormat;

public class CECModel {
    private static final Double[] fromRON = new Double[] {0.2, 0.22};       //EUR, USD
    private static final Double[] fromEUR = new Double[] {4.95, 1.12};      //RON, USD
    private static final Double[] fromUSD = new Double[] {4.38, 0.88};      //RON, EUR
    private static final DecimalFormat decimalFormat = new DecimalFormat("0.00");

    private double result;

    public void reset() {
        result = 0;
    }

    public void convert(String fromCurrency, double fromCurrencyValue, String toCurrency) {
        if (fromCurrency.equals("RON")) {
            if (toCurrency.equals("EUR")) {
                result = fromRON[0] * fromCurrencyValue;
                return;
            }

            if (toCurrency.equals("USD")) {
                result = fromRON[1] * fromCurrencyValue;
                return;
            }
        }

        if (fromCurrency.equals("EUR")) {
            if (toCurrency.equals("RON")) {
                result = fromEUR[0] * fromCurrencyValue;
                return;
            }

            if (toCurrency.equals("USD")) {
                result = fromEUR[1] * fromCurrencyValue;
                return;
            }
        }

        if (fromCurrency.equals("USD")) {
            if (toCurrency.equals("RON")) {
                result = fromUSD[0] * fromCurrencyValue;
                return;
            }

            if (toCurrency.equals("USD"))
                result = fromUSD[1] * fromCurrencyValue;
        }
    }

    public String getToCurrencyValue() {
        return decimalFormat.format(result);
    }
}
