package bsu.rfe.java.group8.lab2.KOROTCHENKO.var10;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class MainFrame extends JFrame {

    private static final int WIDTH = 600;
    private static final int HEIGHT = 320;

    private Double mem1 = 0.0;
    private Double mem2 = 0.0;
    private Double mem3 = 0.0;

    private JTextField textFieldX;
    private JTextField textFieldY;
    private JTextField textFieldZ;

    private JTextField textFieldResult;
    private JTextField textFieldMem;

    private ButtonGroup radioButtons = new ButtonGroup();
    private ButtonGroup radioButtons1 = new ButtonGroup();

    private Box hboxFormulaType = Box.createHorizontalBox();
    private Box hboxVarType = Box.createHorizontalBox();
    private int formulaId = 1;
    private int varId = 1;

    public Double calculate1(Double x, Double y, Double z) {
        return (Math.sin(Math.PI*y*y) + Math.log(y*y)) / (Math.sin(Math.PI*z*z) + Math.sin(x) + Math.log(z*z) + x*x + Math.exp(Math.cos(z*x)));
    }

    public Double calculate2(Double x, Double y, Double z) {

        return (Math.pow(Math.sin(Math.pow(z, y)), 2) / Math.pow(1 + Math.pow(x,3), 0.5));
    }

    private void addRadioButton(String buttonName, final int formulaId) {
        JRadioButton button = new JRadioButton(buttonName);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                MainFrame.this.formulaId = formulaId;

            }
        });
        radioButtons.add(button);
        hboxFormulaType.add(button);
    }

    private void addRadioButton_var(String buttonName, final int varId) {
        JRadioButton button = new JRadioButton(buttonName);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                MainFrame.this.varId = varId;
                if (varId == 1) textFieldMem.setText(mem1.toString());
                if (varId == 2) textFieldMem.setText(mem2.toString());
                if (varId == 3) textFieldMem.setText(mem3.toString());
            }
        });
        radioButtons1.add(button);
        hboxVarType.add(button);
    }

    public MainFrame() {
        super("Вычисление формулы");
        setSize(WIDTH, HEIGHT);
        Toolkit kit = Toolkit.getDefaultToolkit();

        setLocation((kit.getScreenSize().width - WIDTH) / 2, (kit.getScreenSize().height - HEIGHT) / 2);
        hboxFormulaType.add(Box.createHorizontalGlue());
        addRadioButton("Формула 1", 1);
        addRadioButton("Формула 2", 2);
        radioButtons.setSelected(radioButtons.getElements().nextElement().getModel(), true);
        hboxFormulaType.add(Box.createHorizontalGlue());
        hboxFormulaType.setBorder(BorderFactory.createLineBorder(Color.YELLOW));

        hboxVarType.add(Box.createHorizontalGlue());
        addRadioButton_var("Память 1", 1);
        addRadioButton_var("Память 2", 2);
        addRadioButton_var("Память 3", 3);
        radioButtons1.setSelected(radioButtons1.getElements().nextElement().getModel(), true);
        hboxVarType.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        hboxVarType.add(Box.createHorizontalGlue());


        JLabel labelForX = new JLabel("X:");
        textFieldX = new JTextField("0", 10);
        textFieldX.setMaximumSize(textFieldX.getPreferredSize());

        JLabel labelForY = new JLabel("Y:");
        textFieldY = new JTextField("0", 10);
        textFieldY.setMaximumSize(textFieldY.getPreferredSize());

        JLabel labelForZ = new JLabel("Z:");
        textFieldZ = new JTextField("0", 10);
        textFieldZ.setMaximumSize(textFieldZ.getPreferredSize());
        Box hboxVariables = Box.createHorizontalBox();
        hboxVariables.setBorder(BorderFactory.createLineBorder(Color.RED));
        hboxVariables.add(Box.createHorizontalGlue());
        hboxVariables.add(labelForX);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldX);
        hboxVariables.add(Box.createHorizontalStrut(50));
        hboxVariables.add(labelForY);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldY);
        hboxVariables.add(Box.createHorizontalStrut(50));
        hboxVariables.add(labelForZ);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldZ);
        hboxVariables.add(Box.createHorizontalGlue());

        JLabel labelForResult = new JLabel("Результат:");

        textFieldResult = new JTextField("0", 20);
        textFieldResult.setMaximumSize(
                textFieldResult.getPreferredSize());
        Box hboxResult = Box.createHorizontalBox();
        hboxResult.add(Box.createHorizontalGlue());
        hboxResult.add(labelForResult);
        hboxResult.add(Box.createHorizontalStrut(10));
        hboxResult.add(textFieldResult);
        hboxResult.add(Box.createHorizontalGlue());
        hboxResult.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        JLabel labelForMem = new JLabel("Переменная:");

        textFieldMem = new JTextField("0", 20);
        textFieldMem.setMaximumSize(
                textFieldMem.getPreferredSize());
        Box hboxMem = Box.createHorizontalBox();
        hboxMem.add(Box.createHorizontalGlue());
        hboxMem.add(labelForMem);
        hboxMem.add(Box.createHorizontalStrut(10));
        hboxMem.add(textFieldMem);
        hboxMem.add(Box.createHorizontalGlue());
        hboxMem.setBorder(BorderFactory.createLineBorder(Color.BLUE));


        JButton buttonCalc = new JButton("Вычислить");
        buttonCalc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                try {

                    Double mem1_ = Double.parseDouble(textFieldX.getText());
                    Double mem2_ = Double.parseDouble(textFieldY.getText());
                    Double mem3_ = Double.parseDouble(textFieldZ.getText());
                    if (formulaId == 1){
                        textFieldResult.setText(Double.toString(calculate1(mem1_, mem2_, mem3_)));
                    }
                    else {
                        textFieldResult.setText(Double.toString(calculate2(mem1_, mem2_, mem3_)));
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MainFrame.this,
                            "Ошибка в формате записи числа с плавающей точкой", "Ошибочный формат числа",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        JButton buttonReset = new JButton("Очистить поля");
        buttonReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                textFieldX.setText("0");
                textFieldY.setText("0");
                textFieldZ.setText("0");
                textFieldResult.setText("0");
            }
        });
        Box hboxButtons = Box.createHorizontalBox();
        hboxButtons.add(Box.createHorizontalGlue());
        hboxButtons.add(buttonCalc);
        hboxButtons.add(Box.createHorizontalStrut(30));
        hboxButtons.add(buttonReset);
        hboxButtons.add(Box.createHorizontalGlue());
        hboxButtons.setBorder(
                BorderFactory.createLineBorder(Color.GREEN));

        JButton buttonM = new JButton("M+");
        JButton buttonMC = new JButton("MC");
        buttonM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Double result = Double.parseDouble(textFieldResult.getText());
                    if (varId == 1) {
                        mem1 += result;
                        textFieldMem.setText(mem1.toString());
                    }
                    else if (varId == 2) {
                        mem2 += result;
                        textFieldMem.setText(mem2.toString());
                    }
                    else
                    {
                        mem3 += result;
                        textFieldMem.setText(mem3.toString());
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MainFrame.this,
                            "Ошибка в формате записи числа с плавающей точкой", "Ошибочный формат числа",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        buttonMC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (varId == 1) {
                        mem1 = 0.0;
                        textFieldMem.setText("0");
                    }
                    else if (varId == 2) {
                        mem2 = 0.0;
                        textFieldMem.setText("0");
                    }
                    else {
                        mem3 = 0.0;
                        textFieldMem.setText("0");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MainFrame.this,
                            "Ошибка в формате записи числа с плавающей точкой", "Ошибочный формат числа",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        Box hboxButtonsM = Box.createHorizontalBox();
        //hboxButtonsM.add(Box.createHorizontalGlue());
        hboxButtonsM.add(buttonM);
        hboxButtonsM.add(Box.createHorizontalGlue());
        // hboxButtonsM.add(Box.createHorizontalStrut(30));
        hboxButtonsM.add(buttonMC);
        // hboxButtonsM.add(Box.createHorizontalGlue());
        hboxButtonsM.setBorder(BorderFactory.createLineBorder(Color.GREEN));

        Box contentBox = Box.createVerticalBox();
        contentBox.add(Box.createVerticalGlue());
        contentBox.add(hboxFormulaType);
        contentBox.add(hboxVariables);
        contentBox.add(hboxMem);
        contentBox.add(hboxResult);
        contentBox.add(hboxButtons);contentBox.add(hboxVarType);
        contentBox.add(hboxButtonsM);
        contentBox.add(Box.createVerticalGlue());
        getContentPane().add(contentBox, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}