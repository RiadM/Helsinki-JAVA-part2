package reader.criteria;

public class EndsWithQuestionOrExclamationMark implements Criterion{


    @Override
    public boolean complies(String line) {
        int lengthLine = line.length();
        if(line.contains("!") && line.lastIndexOf("!") == lengthLine - 1 || line.contains("?") && line.lastIndexOf("?") == lengthLine - 1){
            return true;
        }
        return false;
    }
}
