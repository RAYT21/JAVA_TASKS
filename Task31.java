import java.util.*;

public class Task31 {
    public static void main(String[] args) {
        System.out.println("Task 31 \n\n"+splitter(10, 7, "hello my name is Bessie and this is my essay"));
        System.out.println("Task 32 "+Arrays.toString(split("((()))(())()()(()())")));
        System.out.println("Task 33.1 "+toCamelCase("snake_ship_lord"));
        System.out.println("Task 33.2 "+toSnakeCase("camelCasePRo"));
        System.out.println("Task 34 "+ overTime(new double[] {9,17,30,1.5}));
        System.out.println("Task 35 "+ BMI("123 pounds", "222 inches"));
        System.out.println("Task 36 "+ bugger(999));
        System.out.println("Task 37 "+ toStarShorthand("77777fafafa2ssxaxasss2adasdvladlasldalaldlaldasl"));
        System.out.println("Task 38 "+ doesRhyme("Sam I jjjaaam!", "Green eggs and haaim."));
        System.out.println("Task 39 "+ trouble(111222929, 22));
        System.out.println("Task 40 "+ countUniqueBooks("$AA$BBCATT$C$$B$", '$'));
    }

    public static String splitter(int n, int k,String string){
        String[] words = string.split(" ");
        String curStr = "";
        String result = "";

        if (n > words.length) return "Wrong esse!";
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (curStr.replace(" ","").length()+ word.length() <=k)
                curStr+=word + " ";
            else{
                result +=curStr+"\n";
                curStr=word+" ";
            }
        }if (curStr.length() > 0) {
            result += curStr + "\n";
        }
        return result;
    }

    public static String[] split(String string){
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            int pS = 0;
            int pE = 0;
            int countX = 0;
            int countY = 0;
            if (string.charAt(i) == '('){
                pS=i;
                countX++;
                i++;
                while (i < string.length() && countX-countY != 0){
                    if (string.charAt(i) == '(') countX++;
                    else if (string.charAt(i) == ')') countY++;
                    i++;
                }

                pE = i;
                list.add(string.substring(pS,pE));
                i--;
            }
        }
        String[] strings = new String[list.size()];
        return strings=list.toArray(strings);
    }

    public static String toCamelCase(String string){
        String[] words = string.split("_");
        String result = words[0];
        for (int i = 1; i < words.length; i++) {
            result+=words[i].substring(0,1).toUpperCase()+words[i].substring(1);
        }
        return result;
    }

    public static String toSnakeCase(String string){
        String result = "";
        for (int i = 0; i < string.length(); i++) {
            if (Character.isUpperCase(string.charAt(i))) {
                result +="_"+string.toLowerCase().charAt(i);
            }
            else result+=string.charAt(i);
        }
        return result;
    }

    public static String overTime(double[] arr){
        double sum = 0;
        for (double i = arr[0]; i < arr[1]; i+=0.25) {
            if (i>17) {sum+=0.25*arr[2]*arr[3];}
            else sum+=0.25*arr[2];
        }
        return String.format("$%.2f",sum);
    }

    public static String BMI (String weight,String height){
        String[] weig = weight.split(" ");
        String[] heig = height.split(" ");
        String result = "";
        double kilos = weig[1].equals("pounds") ? Double.parseDouble(weig[0]) * 0.453592 : Double.parseDouble(weig[0]);
        double meters = heig[1].equals("inches") ? Double.parseDouble(heig[0]) * 0.0254 : Double.parseDouble(heig[0]);
        double val = kilos / (meters * meters);
        val = Math.round(val * 10.0) / 10.0;
        if (val < 18.5) result += val + " Underweight";
        if (val >= 18.5 && val <= 24.5) result += val + " Normal weight";
        if (val >= 25 && val <= 29.9) result += val + " Overweight";
        if (val >= 30) result += val + " Obesity";
        return result;
    }

    public static int bugger(int n){
       int result = 0;
       while (Integer.toString(n).length() > 1){
           int param = n;
           n=1;
           while(param>0) {
               n *=param%10;
               param = param / 10;
           }
           result++;
       }
       return result;
    }

    public static String toStarShorthand(String string){
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<>();
        String result = "";
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (!strings.contains(Character.toString(string.charAt(i)))) {
                strings.add(count,Character.toString(string.charAt(i)));
                numbers.add(count,1);
                for(int j = i+1; j < string.length();j++) {
                    if (string.charAt(j) == string.charAt(i)) {
                        numbers.add(count,numbers.get(count)+1);
                    }
                }
                count++;
            }
        }
        for (int i = 0; i < count; i++) {
           if (numbers.get(i)==1){
               result +=strings.get(i)+"*";
           }
           else if (strings.get(i).matches("[0-9]+")){
               result +="("+numbers.get(i)+"*"+strings.get(i)+")*";
           }
           else result +=numbers.get(i)+strings.get(i)+"*";
        }
        return result.substring(0,result.length()-1);
    }

    public static boolean doesRhyme(String firstString, String secondString){
        String firstLastWord = firstString.substring(firstString.lastIndexOf(" ")+1);
        String secondLastWord = secondString.substring(secondString.lastIndexOf(" ")+1);
        int jCount = 0;
        int fNum = 0, sNum=0;
        for (int i = 0; i < firstLastWord.length(); i++) {
            if (Character.toString(firstLastWord.charAt(i)).matches("[AIOUEYaiouey]")){
                fNum++;
                for (int j = jCount; j < secondLastWord.length(); j++) {
                    jCount++;
                    if (Character.toString(secondLastWord.charAt(j)).matches("[AIOUEYaiouey]")){
                        if (secondLastWord.charAt(j) == firstLastWord.charAt(i)){
                            sNum++;
                            break;
                        }
                    }
                }
            }

        }
         if (sNum==fNum){
             return true;
         }
         else{
             return false;
         }
    }

    public static boolean trouble(int num1, int num2){
        String numberOne = Integer.toString(num1);
        String numberTwo = Integer.toString(num2);
        for (int i = 0; i < numberOne.length()-2; i++) {
            if (numberOne.charAt(i)==numberOne.charAt(i+1) && numberOne.charAt(i)==numberOne.charAt(i+2)){
                for (int j = 0; j < numberTwo.length()-1; j++) {
                    if (numberOne.charAt(i)==numberTwo.charAt(j) && numberOne.charAt(i)==numberTwo.charAt(j+1)){
                        return true;
                    }
                }
            }
        }
        return  false;
    }

    public static int countUniqueBooks(String books, char divider){
        int result=0;
        for (int i = 0; i < books.length(); i++) {
            if ( books.charAt(i) == divider){
                ArrayList<Character> uniqueSymbol = new ArrayList();
                int j = i+1;
                while(j < books.length() && books.charAt(j) != divider){
                    if (!uniqueSymbol.contains(books.charAt(j))){
                        uniqueSymbol.add(books.charAt(j));
                    }
                    j++;
                }
                i = j;
                result+=uniqueSymbol.size();
            }
        }
        return result;
    }
}

