package clicker.ui;

import clicker.applicationlogic.PersonalCalculator;

import java.awt.*;
import javax.swing.*;

public class UserInterface implements Runnable {
    private JFrame frame;
    private PersonalCalculator personalCalculator;

    public UserInterface(PersonalCalculator personalCalculator) {
        this.personalCalculator = personalCalculator;
    }

    @Override
    public void run() {
        frame = new JFrame("Click Effect");
        frame.setPreferredSize(new Dimension(200, 100));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        BorderLayout layout = new BorderLayout();
        container.setLayout(layout);

        JLabel label = new JLabel("0");
        JButton button = new JButton("Click!");

        ClickListener listen = new ClickListener(this.personalCalculator, label);
        button.addActionListener(listen);

        container.add(label,BorderLayout.NORTH);
        container.add(button, BorderLayout.SOUTH);
    }

    public JFrame getFrame() {
        return frame;
    }
}
