public class JAVA_Practice_1 {

    public static void main (String[] args) {

        String s[] = {"java","c","python","java","c++"};

        for(int i=0; i<s.length; i++){
            for (int j=i+1; j<s.length; j++){
                if(s[i].equals(s[j])){
                    System.out.println("Duplicate value is : "+s[i]);
                }
            }
        }
    }
}