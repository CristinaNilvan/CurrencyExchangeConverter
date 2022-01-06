import java.text.DecimalFormat;
import java.util.Arrays;

public class CECModel {
    private static final String[] currencies = new String[] {"EUR", "USD", "RON"};
    private static final double[][] currenciesValues = { { 1, 1.12, 4.95 }, { 0.89, 1, 4.40 }, { 0.23, 0.15, 1 }};
    private static final DecimalFormat decimalFormat = new DecimalFormat("0.00");

    private double result;

    public void reset() {
        result = 0;
    }

    public String[] getCurrencies() {
        return currencies;
    }

    public void convert(String fromCurrency, double fromCurrencyValue, String toCurrency) {
        int fromCurrencyIndex = Arrays.asList(currencies).indexOf(fromCurrency);
        int toCurrencyIndex = Arrays.asList(currencies).indexOf(toCurrency);

        double currencyRate = currenciesValues[fromCurrencyIndex][toCurrencyIndex];

        result = currencyRate * fromCurrencyValue;
    }

    public String getToCurrencyValue() {
        return decimalFormat.format(result);
    }
}
