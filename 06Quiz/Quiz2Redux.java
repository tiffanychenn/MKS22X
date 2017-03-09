import java.util.*;
public class Quiz2Redux{ 

    /*Returns an ArrayList<String> that contains all subsets of the
     *characters of String s. Assume s has no duplicate characters.
     *the characters should appear in the same order that they occur 
     *in the original string.
     */

    public static ArrayList<String> combinations(String s){
        ArrayList<String>words = new ArrayList<String>();
        help( words , /*fill this in with more */);
        Collections.sort(words);
        return words;
    }
  
    private static void help( ArrayList<String> words, 
                             /*fill this in with more arguments*/ ){
        /*METHOD TO BE WRITTEN BY YOU.*/ 
    }
}