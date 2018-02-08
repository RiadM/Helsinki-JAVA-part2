import java.io.File;
import java.util.Scanner;

public class Printer {
    private File file;

    public Printer(String fileName) throws Exception{
        this.file = new File(fileName);
    }

    public void printLinesWhichContain(String word) throws Exception{

        Scanner reader = new Scanner(this.file);
        while(reader.hasNext()){
            String lineRead = reader.nextLine();
            if(lineRead.contains(word) == true || word.isEmpty()){
                System.out.println(lineRead);
            }
        }
        reader.close();
    }
}
