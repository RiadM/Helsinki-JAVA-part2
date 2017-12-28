public class Change {

    private char fromCharacter;
    private char toCharacter;

    public Change(char fromCharacter, char toCharacter) {
        this.fromCharacter = fromCharacter;
        this.toCharacter = toCharacter;
    }

    public String change(String characterString){

        String returnString = "";
        int size = characterString.length();

        for(int i = 0; i < size; i++){
            if(characterString.charAt(i) == this.fromCharacter){
                returnString += this.toCharacter;
            } else{
                returnString += characterString.charAt(i);
            }
        }
        return returnString;
    }
}
