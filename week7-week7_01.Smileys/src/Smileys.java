
public class Smileys {

    public static void main(String[] args) {
        // Test your method at least with the following
         printWithSmileys("Method");
         printWithSmileys("Beerbottle");
         printWithSmileys("Interface");
    }
    private static void printWithSmileys(String characterString){

        int size = characterString.length();
        if(size % 2 ==0){
            size += 6 ;
            characterString = ":) " + characterString + " :)";
        } else if(size % 2 != 0){
            size +=7 ;
            characterString = ":) " + characterString + "  :)";
        }

        String smile = "";

        for(int i = 0; i < size / 2; i++){
            smile+=":)";
        }

        System.out.println(smile);
        System.out.println(characterString);
        System.out.println(smile);
    }

}
