package wordinspection;

        import java.io.File;

public class Main {

    public static void main(String[] args) {
        // test your code here


        WordInspection ss = new WordInspection( new File("src/wordList.txt") );
        System.out.println(ss.wordsWhichContainAllVowels().size());

    }
}
