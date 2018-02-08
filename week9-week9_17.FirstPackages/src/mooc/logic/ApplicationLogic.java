package mooc.logic;

import mooc.ui.TextUserInterface;
import mooc.ui.UserInterface;

public class ApplicationLogic {
    private UserInterface x;

    public ApplicationLogic(UserInterface ui) {
         this.x = ui;
    }

    public void execute(int howManyTimes){
        while(howManyTimes!=0){
            System.out.println("The application logic works");
           this.x.update();
            howManyTimes--;
        }
    }
}
