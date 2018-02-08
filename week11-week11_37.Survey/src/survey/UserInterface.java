package survey;

import java.awt.*;
import javax.swing.*;

public class UserInterface implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        // Create your app here

        frame  = new JFrame("Survey");
        frame.setPreferredSize(new Dimension(200,300));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }


    public void createComponents(Container container){
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);

        container.add(new JLabel("Are you?"));
        JCheckBox yes = new JCheckBox("Yes!");
        JCheckBox no  = new JCheckBox("No!");

        ButtonGroup group1 = new ButtonGroup();
        group1.add(yes);
        group1.add(no);

        container.add(yes);
        container.add(no);

        container.add(new JLabel("Why?"));
        JRadioButton reasonOne = new JRadioButton("No Reason.");
        JRadioButton reasonTwo = new JRadioButton("Because it is fun!");

        ButtonGroup group2 = new ButtonGroup();
        group2.add(reasonOne);
        group2.add(reasonTwo);

        container.add(reasonOne);
        container.add(reasonTwo);

        container.add(new JButton("Done!"));
    }

    public JFrame getFrame() {
        return frame;
    }
}
