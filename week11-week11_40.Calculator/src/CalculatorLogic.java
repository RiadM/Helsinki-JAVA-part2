import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorLogic implements ActionListener {

    private JTextField input;
    private JTextField output;
    private JButton zbutton;


    public CalculatorLogic(JTextField input, JTextField output, JButton zbutton) {
        this.input = input;
        this.output = output;
        this.zbutton = zbutton;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        JButton e = (JButton) ae.getSource();
        try{
            if(e.getText().contains("+")){
            int sum = Integer.parseInt(this.input.getText()) + Integer.parseInt(this.output.getText());
            this.output.setText(sum + "");
            this.input.setText("");
            }
            if(e.getText().contains("-")){
                int sub = Integer.parseInt(this.output.getText()) - Integer.parseInt(this.input.getText());
                this.output.setText("" + sub);
                this.input.setText("");
            }
            if(e.getText().contains("Z")){
                this.output.setText("0");
                this.input.setText("");
                zbutton.setEnabled(false);

            }
            if(!this.output.getText().contains("0")){
              zbutton.setEnabled(true);
            }
        }catch (Exception x){
            this.input.setText("");
        }
    }
}
