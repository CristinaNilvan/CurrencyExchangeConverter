import java.awt.event.*;

public class CECController {
    private CECModel controllerModel;
    private CECView controllerView;

    public CECController(CECModel model, CECView view) {
        controllerModel = model;
        controllerView = view;

        view.addConverterListener(new ConverterListener());
        view.addClearListener(new ClearListener());
    }

    class ConverterListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput = controllerView.getUserInput();
            double fromCurrencyValue = Double.parseDouble(userInput);

            String fromCurrency = String.valueOf(controllerView.getFromComboBox().getSelectedItem());
            String toCurrency = String.valueOf(controllerView.getToComboBox().getSelectedItem());

            controllerModel.convert(fromCurrency, fromCurrencyValue, toCurrency);
            controllerView.setConverterOutput(controllerModel.getToCurrencyValue());
        }
    }

    class ClearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            controllerModel.reset();
            controllerView.reset();
        }
    }
}
