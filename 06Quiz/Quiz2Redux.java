import java.util.*;
public class Quiz2Redux{ 

    /*Returns an ArrayList<String> that contains all subsets of the
     *characters of String s. Assume s has no duplicate characters.
     *the characters should appear in the same order that they occur 
     *in the original string.
     */

    public static ArrayList<String> combinations(String s){
        ArrayList<String> words = new ArrayList<String>();
        help(s, words, 0, "");
        words.add("");
        Collections.sort(words);
        return words;
    }
  
    private static void help(String s, ArrayList<String> words, int index, String current){
        if (index >= s.length()){
            return;
        }
        help(s, words, index + 1, current + s.substring(index, index + 1));
        help(s, words, index + 1, current);
        words.add(current + s.substring(index, index + 1));
    }

    public static void main(String[] args){
        System.out.println(combinations("bags"));
        System.out.println(combinations("abcd"));
        System.out.println(combinations("kji"));
    }
}