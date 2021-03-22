public class StringUtils {
    public static int countVowels(String str){
        int count=0;
        String vowels="aeiou";
        for(var i:str.toLowerCase().toCharArray()){
            if(vowels.indexOf(i)!=-1){
                count++;
            }
        }
        return count;
    }

    public static String reverse(String str){
        String reversed="";
        for(int i=str.length()-1;i>=0;i--){
            reversed+=str.charAt(i);
        }
        return reversed;
    }
}
