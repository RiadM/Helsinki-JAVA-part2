
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {

    public List<String> read(String file) throws FileNotFoundException {
        File fileRead = new File(file);
        Scanner scanner = new Scanner(fileRead);
        ArrayList<String> arrayFile = new ArrayList();

        while(scanner.hasNext()){
            arrayFile.add(scanner.nextLine());
        }
        return arrayFile;
    }

    public void save(String file, String text) throws IOException {
        FileWriter writer = new FileWriter(file);
        writer.write(text);
        writer.close();
    }

    public void save(String file, List<String> texts) throws IOException {
        FileWriter writer = new FileWriter(file);
        for(String str: texts){
            writer.write(str + "\n");
        }
        writer.close();
    }
}
