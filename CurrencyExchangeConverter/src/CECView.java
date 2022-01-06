import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CECView extends JFrame {
    private final JComboBox<String> fromComboBox;
    private final JComboBox<String> toComboBox;
    private final JButton convertButton = new JButton("convert");
    private final JButton clearButton = new JButton("clear");
    private final JTextField userInput = new JTextField(5);
    private final JTextField converterOutput = new JTextField(5);

    private CECModel viewModel;

    public CECView(CECModel model) {
        viewModel = model;

        userInput.setText("");
        converterOutput.setText("");

        fromComboBox = new JComboBox<>(viewModel.getCurrencies());
        toComboBox = new JComboBox<>(viewModel.getCurrencies());

        JFrame frame = new JFrame("Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 250);

        JPanel comboBoxesPanel = new JPanel();
        comboBoxesPanel.add(fromComboBox);
        comboBoxesPanel.add(toComboBox);
        comboBoxesPanel.setLayout(new FlowLayout());

        JPanel firstFieldPanel = new JPanel();
        JLabel fromLabel = new JLabel("Sum");
        firstFieldPanel.add(fromLabel);
        firstFieldPanel.add(userInput);
        firstFieldPanel.setLayout(new FlowLayout());

        JPanel secondFieldPanel = new JPanel();
        JLabel toLabel = new JLabel("Result");
        secondFieldPanel.add(toLabel);
        secondFieldPanel.add(converterOutput);
        secondFieldPanel.setLayout(new FlowLayout());

        JPanel fieldsPanel = new JPanel();
        fieldsPanel.add(firstFieldPanel);
        fieldsPanel.add(secondFieldPanel);
        fieldsPanel.setLayout(new BoxLayout(fieldsPanel, BoxLayout.Y_AXIS));

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(convertButton);
        buttonsPanel.add(clearButton);
        firstFieldPanel.setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        panel.add(comboBoxesPanel);
        panel.add(fieldsPanel);
        panel.add(buttonsPanel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        frame.setContentPane(panel);
        frame.setVisible(true);
    }

    public void reset() {
        userInput.setText("");
        converterOutput.setText("");
    }

    public JComboBox<String> getFromComboBox() {
        return fromComboBox;
    }

    public JComboBox<String> getToComboBox() {
        return toComboBox;
    }

    public String getUserInput() {
        return userInput.getText();
    }

    public void setConverterOutput(String result) {
        converterOutput.setText(result);
    }

    public void addConverterListener(ActionListener action) {
        convertButton.addActionListener(action);
    }

    public void addClearListener(ActionListener action) {
        clearButton.addActionListener(action);
    }
}
