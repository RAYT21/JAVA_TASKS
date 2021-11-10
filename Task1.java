public class Task1 {

    public static void main(String[] args) {
        System.out.println(convert(3));
        System.out.println(points(13,12));
        System.out.println(footballPoints(3,4,2));
        System.out.println(divisibleByFive(-55));
        System.out.println(and(true, false));
        System.out.println(howManyWalls(54,1,43));
        System.out.println(squared(5));
        System.out.println(profitableGamble(0.2,50,9));
        System.out.println(frames(10,1));
        System.out.println(mod(5,2));
    }

    public static int convert(int x){
        return x*60;
    }

    public static int points(int x, int y) {
        return x*2+y*3;
    }

    public static int footballPoints(int wins, int draw, int loose){
        return wins*3+draw;
    }

    public static boolean divisibleByFive(int x){
        return (x%5==0);
    }

    public static boolean and(boolean a, boolean b){
        return a && b;
    }

    public static int howManyWalls(int n, int w, int h){
        return n/(w*h);
    }

    public static int squared(int a){
        return a*a;
    }

    public static boolean profitableGamble(double prob,double price, double pay){
        return (prob*price > pay);
    }

    public static int frames(int min, int fps){
        return min*60*fps;
    }

    public static int mod(int a, int b){
        return a-a/b*b;
    }
}