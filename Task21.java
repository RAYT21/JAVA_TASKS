import java.lang.Math;
import java.util.ArrayList;

public class Task21 {

    public static void main(String[] args) {
        System.out.println("Task 21 "+ solution(1,0,1));
        System.out.println("Task 22 "+findZip("all zip files are zipped", "zip", 2));
        System.out.println("Task 23 "+checkPerfect(13));
        System.out.println("Task 24 "+flipEndChars("Can, mad, sad."));
        System.out.println("Task 25 "+isValidHexCode("#222223"));
        System.out.println("Task 26 "+same(new int[] {2,2,2}, new int[] {1,2,3}));
        System.out.println("Task 27 "+isKaprekar(297));
        System.out.println("Task 28 "+longestZero("00010000"));
        System.out.println("Task 29 "+nextPrime(61));
        System.out.println("Task 30 "+rigthTriangle(3,5,4));
    }

    public static int solution(double a, double b, double c) {
        double D= Math.sqrt(b*b-4*a*c);
        if (D < 0) {return 0;}
        else if (D == 0) {return 1;}
            else {return 2;}
    }

    public static int findZip(String string, String subString, int n) {
        ArrayList<Integer> entryPos = new ArrayList<>();
        for (int i = 0; i < string.length()-subString.length(); i++) {
            if (string.substring(i,i+subString.length()).equals(subString)){
               entryPos.add(i);
            }
        }
        if (entryPos.size() >= n){return entryPos.get(n-1);}
        else return -1;
    }

    private static boolean checkPerfect(int n){
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum == n;
    }

    public static String flipEndChars(String string){
        if (string.length()<2) return "несовместимо";
        if (string.charAt(0) == string.charAt(string.length()-1)) return "два-это пара";
        char[] line = string.toCharArray();
        char symbol = line[0];
        line[0] = line[line.length - 1];
        line[line.length-1] = symbol;
        return new String(line);
    }

    public static boolean isValidHexCode(String string){
        return string.matches("#[A-F0-9]{6}");
    }


    public static boolean same(int[] arr1, int[] arr2){
        int diffValues1;
        ArrayList<Integer> diffArr1 = new ArrayList<>();
        for (int i : arr1) {
            if (!diffArr1.contains(i)) {
                diffArr1.add(i);
            }
        }
        if(diffArr1.size() == 1) diffValues1 = 0;
        else diffValues1 = diffArr1.size();

        int diffValues2;
        ArrayList<Integer> diffArr2 = new ArrayList<>();
        for (int i : arr2) {
            if (!diffArr2.contains(i)) {
                diffArr2.add(i);
            }
        }
        if(diffArr2.size() == 1)diffValues2 = 0;
        else diffValues2 = diffArr2.size();

        return diffValues1 == diffValues2;
    }

    public static boolean isKaprekar(int n){
        String str = String.valueOf(n*n);
        int Left = str.substring(0, str.length()/2).equals("") ? 0 : Integer.parseInt(str.substring(0, str.length()/2)) ;
        int Right = Integer.parseInt(str.substring(str.length()/2, str.length()));
        return (Left+Right) == n;
    }

    public static String longestZero(String str){
        int zS=0,zE=0,k=0;
        for (int i = 0; i < str.length(); i++) {
            int kIn=0, zSIN=i;
            while( i < str.length() && str.charAt(i) == '0') {
                kIn++;
                i++;
            }
            if (kIn>k) {
                k=kIn;
                zS=zSIN;
                zE=zS+k;
            }
        }
        return str.substring(zS,zE);
    }

    public static int nextPrime(int n){
        for (int i = 2; i < (int)Math.sqrt(n); i++) {
            if ( n%i == 0) {
                while (i < n && n%i == 0){
                    i++;
                    for (int j = i; j < (int)Math.sqrt(n+i); j++) {
                        if ( n%j != 0) {break;}
                    }
                }
                return n+i;
            }
        }
        return n;
    }

    public static boolean rigthTriangle(int x, int y, int z){
        return x*x + y*y == z*z || x*x + z*z == y*y || y*y + z*z == x*x;
    }


}
