
public class Main {

    public static void main(String[] args) {
        int[] t = {1, 2, 3, 4};
        System.out.println(build(t));
    }

    public static String build(int[] t) {
        StringBuilder stb = new StringBuilder();
        stb.append("{\n");

        int i = 1;
        for(int tt: t){
            if(i % 4 == 0 && i != t.length){
                stb.append(" " + tt + ",\n");
            }
            else if(i == t.length){
                stb.append(" " + tt + "\n}");
            }
            else{
                stb.append(" " + tt + ",");
            }
            i++;
        }

        return stb.toString();
    }
}
