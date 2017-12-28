import java.util.Scanner;

public class TextUserInterface {

    private Scanner reader ;
    private Dictionary dictionary;

    public TextUserInterface(Scanner reader, Dictionary dictionary) {
        this.reader = reader;
        this.dictionary = dictionary;
    }

    public void start(){

        System.out.println("Statements:");
        System.out.println("    add - adds a word pair to the dictionary");
        System.out.println("    translate - asks a word and prints its translation");
        System.out.println("    quit - quits the text user interface\n");

        while(true){
            System.out.print("Statement:");
            String userInput = this.reader.nextLine();

            if(userInput.equalsIgnoreCase("quit")){
                System.out.println("Cheers!");
                break;
            }
            else if(userInput.equalsIgnoreCase("add")){
                System.out.print("In Finnish: ");
                String wordInput = this.reader.nextLine();
                System.out.print("Translation: ");
                String wordTranslated = this.reader.nextLine();
                dictionary.add(wordInput,wordTranslated);
            }
            else if(userInput.equalsIgnoreCase("translate")){
                System.out.print("Give a word: ");
                System.out.println(dictionary.translate(this.reader.nextLine()));
            }

            else{
                System.out.println("Unknown statement");
            }
            System.out.println("");
        }
    }
    public void quit(){

    }
}
