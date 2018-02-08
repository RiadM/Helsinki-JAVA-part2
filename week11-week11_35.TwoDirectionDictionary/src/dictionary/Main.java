package dictionary;

public class Main {
    public static void main(String[] args) {
        // Test your dictionary here
        MindfulDictionary s = new MindfulDictionary("test/words.txt");
        s.load();
        s.translate("olut");
        s.save();
    }
}
