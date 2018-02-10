
public class Main {

    public static void main(String[] args) {
        // write test code here
        System.out.println(isAWeekDay("eae"));
        System.out.println(allVowels("aei") + " - " + allVowels("allo"));
        System.out.println(clockTime("22:12"));
        System.out.println(clockTime("24:22:23"));
    }

    //Regex for weekdays
    public static boolean isAWeekDay(String string){
        if(string.matches("mon|t(ue|hu)|wed|fri|s(at|un)")){
            return true;
        }else{
            return false;
        }
    }

    //Return true if there's only vowel in the string
    public static boolean allVowels(String string){
        if(string.matches("[aeiouäö]*")){
            return true;
        }else{
            return false;
        }
    }

    //Look if the format is hh:mm:ss
    public static boolean clockTime(String string){
        if(string.matches("((0|1)([0-9])||(2)([0-3])):([0-5])([0-9]):([0-5])([0-9])")){
            return true;
        }else{
            return false;
        }
    }
}
