public class Recursion{ 

    public static String name(){
        return "Chen,Tiffany";
    }

    public static double sqrt(double n){
        if (n < 0){
            throw new IllegalArgumentException();
        }
        if (n == 0){
            return 0;
        }
        return algorithm(n, 1);
    }

    private static double algorithm(double n, double original_guess){
        double better_guess = (n / original_guess + original_guess) / 2;
        if (isCloseEnough(better_guess * better_guess, n)){
            return better_guess;
        }
        return algorithm(n, better_guess);
    }

    private static boolean isCloseEnough(double sr, double sq){
        return Math.abs(sq - sr) / sq <= 0.00000000000001;
    }

    public static void main(String[] args){
        System.out.println(sqrt(2));
        System.out.println(sqrt(225));
        System.out.println(sqrt(0));
        //System.out.println(sqrt(-5));
    }

}