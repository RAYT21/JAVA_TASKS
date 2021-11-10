

public class Task11 {
    
    public static void main(String[] args){
        System.out.println("Task 11 "+ repeat("moscow",2));
        System.out.println("Task 12 "+ differenceMaxMin(new int[] {44,32,86,19}));
        System.out.println("Task 13 "+ isAvgWhole(new int[] {9,2,2,5}));
        System.out.printf("Task 14 "); cumulativeSum(new int[]{1,2,3});
        System.out.println("Task 15 "+ getDecimalPlaces("12"));
        System.out.println("Task 16 "+ fibonacci(7));
        System.out.println("Task 17 "+ isValid("12345"));
        System.out.println("Task 18 "+ isStrangePair("sssp", "paas"));
        System.out.println("Task 19.1 "+ isPrefix("aaa2aw", "aa2-"));
        System.out.println("Task 19.2 "+ isSuffix("aaaa", "-aa2"));
        System.out.println("Task 20 "+ boxSeq(5));
    }

    public static StringBuilder repeat(String string, int count){
        StringBuilder repeatString = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            for (int j = 0; j < count; j++) {
                repeatString.append(string.charAt(i));
            }
        }
        return repeatString;
    }

    public static int differenceMaxMin(int[] array){
        int max = array[0], min=array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) min= array[i];
            if (array[i] > max) max= array[i];
        }
        return max - min;
    }

    public static boolean isAvgWhole(int[] array){
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum +=array[i];
        }
        return (sum/(double)array.length % 1 == 0);
    }

    public static int[] cumulativeSum(int[] array){
        int sum = 0;
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] + sum;
            System.out.print(array[i] + " ");
            sum += array[i];
        }
        System.out.println("]");
        return array;
    }

    public static int getDecimalPlaces(String number){
        String[] splitter = String.valueOf(number).split("\\.");
        if (splitter.length == 1) return 0;
        return splitter[1].length();
    }

    public static int fibonacci(int number){
        int[] arr = new int[number];
        arr[0] = 1;
        arr[1] = 2;
        for (int i = 2; i < arr.length; ++i) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[number-1];
    }

    public static boolean isValid(String index){
        return  (index.length() < 6 && index.matches("\\d+"));
    }

    public static boolean isStrangePair(String a, String b){
        return (a.charAt(0) == b.charAt(b.length()-1) && a.charAt(a.length()-1) == b.charAt(0));
    }

    public static boolean isPrefix(String word, String prefix){
        return word.substring(0,prefix.length()-1).equals(prefix.substring(0,prefix.length()-1)) ;
    }

    public static boolean isSuffix(String word, String suffix){
        return  word.substring(word.length()-suffix.length()+1,word.length()).equals(suffix.substring(1,suffix.length()));
    }

    public static int boxSeq(int n){
        int i = 0;
        int sum = 0;
        while(i < n){
            if (i % 2 == 0) {sum +=3;}
            else {sum-=1;}
            i++;

        }
        return sum;
    }


}
