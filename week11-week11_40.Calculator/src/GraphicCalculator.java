
import java.awt.*;
import javax.swing.*;

public class GraphicCalculator implements Runnable {
    private JFrame frame;

    @Override
    public void run() {
        JFrame frame = new JFrame("Calculator");
        frame.setPreferredSize(new Dimension(300,200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());
        frame.pack();

        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(3,1);
        container.setLayout(layout);

        JTextField textFieldOutput = new JTextField("0");
        textFieldOutput.setEnabled(false);
        container.add(textFieldOutput);

        JTextField textFieldInput = new JTextField();
        container.add(textFieldInput);

        JButton add = new JButton("+");
        JButton sub = new JButton("-");
        JButton z   = new JButton("Z");
        z.setEnabled(false);

        CalculatorLogic listener = new CalculatorLogic(textFieldInput,textFieldOutput, z);

        add.addActionListener(listener);
        sub.addActionListener(listener);
        z.addActionListener(listener);

        JPanel panel = new JPanel(new GridLayout(1,3));
        panel.add(add);
        panel.add(sub);
        panel.add(z);
        container.add(panel);
    }

    public JFrame getFrame() {
        return frame;
    }
}
