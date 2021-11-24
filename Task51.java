import java.util.*;

public class Task51 {

    public static void main(String[] args) {
        System.out.println("Task51: " + bell(2));
        System.out.println("Task52: "+ translateWord("shimp")); // доделать
        // написать для строки
        System.out.println("Task53: "+ validColor("rgba(0,0,0,0)"));
        System.out.println("Task54: "+ stripUrlParams("https://vk.com?a=1&b=2&a=2","b"));
        System.out.println("Task55: "+ Arrays.toString(getHashTags("Whya Jimmi You, So, Boorrow"))); //подкумать как переделать
        System.out.println("Task56: "+ ulam(206));
        System.out.println("Task57: "+ longest("abscaaaaa"));
        System.out.println("Task58: "+ convertToRoman(300));
        System.out.println("Task59: "+ formula("10 * 5 = 50 = 35 + 15  + 13"));
        System.out.println("Task60: "+ polindrome(112111230L));
    }

    public static int bell(int n) {
        int[][] bellTriangle = new int[n + 1][n + 1];
        bellTriangle[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            bellTriangle[i][0] = bellTriangle[i - 1][i - 1];
            for (int j = 1; j <= i; j++) {
                bellTriangle[i][j] = bellTriangle[i - 1][j - 1] + bellTriangle[i][j - 1];
            }
        }
        return bellTriangle[n][0];
    }

    public static String translateWord(String string){
        if (string.isEmpty()) return "incorrect";
        String consonantsEnglish = "qwrtplkjhgfdszxcvbnm";
        if (consonantsEnglish.indexOf(Character.toLowerCase(string.charAt(0))) != -1) {
            return string.substring(1)+string.charAt(0)+"ay";
        }
        return string+"yay";
    }

    public static boolean validColor(String string){
        int i = string.indexOf("(");
        String[] split = string.substring(i+1,string.length()-1).split(",");
        if (string.substring(0,i).equals("rgb") && split.length==3){
            for (int j = 0; j < split.length; j++) {
                if (Integer.parseInt(split[j]) < 0 && Integer.parseInt(split[j]) > 255){
                    return false;
                }
            }
            return true;
        }
        if(string.substring(0,i).equals("rgba")  && split.length==4){
            if (Integer.parseInt(split[split.length-1]) < 0 && Integer.parseInt(split[split.length-1]) > 1){
                return false;
            }
            for (int j = 0; j < split.length-1; j++) {
                if (Integer.parseInt(split[j]) < 0 && Integer.parseInt(split[j]) > 255){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static String stripUrlParams(String url, String ...paramsToStrip) {
        String str = "";
        if (!url.contains("?"))
            return url;
        else {
            str = url.substring(url.indexOf("?") + 1);
            url = url.substring(0, url.indexOf("?") + 1);
        }
        char[] params = str.toCharArray();
        StringBuilder print = new StringBuilder();
        for (char param : params) {
            if (Character.isLetter(param))
                if (!(print.toString().contains(String.valueOf(param)))) {
                    if (paramsToStrip.length > 0) {
                        for (String arg : paramsToStrip) {
                            if (!(arg.contains(String.valueOf(param))))
                                print.append(str, str.lastIndexOf(param), str.lastIndexOf(param) + 3).append("&");
                        }
                    }
                    else print.append(str, str.lastIndexOf(param), str.lastIndexOf(param) + 3).append("&");
                }
        }
        return url + print.substring(0, print.length()-1);
    }

    public static String[] getHashTags(String string){
        String[] split = string.split("[\\s,]+");
        for (int i = 0; i < split.length; i++) {
            if (split[0].length() < split[i].length()){
                String tmp = split[i];
                for (int j = i; j > 0; j--) {
                    split[j]= split[j-1];
                }
                split[0]=tmp;
            }
        }
        String[] result = new String[3];
        return result = Arrays.copyOfRange(split,0,3);
    }

    public static int ulam(int n){
        int[] arr = new int[n];
        arr[0]=1;
        arr[1]=2;
        int len=2, next=3;
        while (next < Integer.MAX_VALUE && len < n){
            int count = 0;
            for (int i = 0; i < len; i++){
                for (int j = len-1; j > i; j--){
                    if (arr[i] + arr[j] == next && arr[i] != arr[j])
                        count++;
                    else if (count > 1)
                        break;
                }
                if (count > 1)
                    break;
            }
            if (count == 1) {
                arr[len] = next;
                len++;
            }
            next++;
        }
        return arr[n-1];
    }

    public static String longest(String string){
        Map visited = new HashMap<>();
        String subString = "";
        int strX = 0;
        for (int endX = 0; endX < string.length(); endX++) {
            char currChar = string.charAt(endX);
            if (visited.containsKey(currChar)) {
                strX = Math.max((int)visited.get(currChar)+1, strX);
            }
            if (subString.length() < endX - strX + 1) {
                subString = string.substring(strX, endX + 1);
            }
            visited.put(currChar, endX);
        }
        return subString;
    }

    public static String convertToRoman(int n){
        if (n<1 || n>3999) return "incorrect";
        StringBuilder str = new StringBuilder();
        Map<Integer, String> roman = new LinkedHashMap<Integer,String>()
        {
            {
                put(1000,"M");put(900,"CM");put(500,"D");put(400,"CD");
                put(100,"C"); put(90,"XC"); put(50,"L"); put(40,"XL");
                put(10,"X");  put(9,"IX");  put(5,"V");  put(4,"IV");
                put(1,"I");
            }
        };

        for (Map.Entry<Integer, String> entry : roman.entrySet()) {
            int key = entry.getKey();
            if(n/key!=0){
                for (int i = 0; i < (n/key); i++) {
                    str.append(roman.get(key));
                }
                n%=key;
            }
        }
        return str.toString();
    }

    public static boolean formula(String formula){
        String[] tokens = formula.split(" ");
        ArrayList<Integer> ans = new ArrayList<>();
        int m = 0;
        if (!Character.isDigit(tokens[0].charAt(0))) return false;
        else ans.add(m, Integer.parseInt(tokens[0]));
        for (int i = 0; i < tokens.length; i++) {
            switch (tokens[i]){
                case "+":
                    ans.add(m, ans.get(m)+Integer.parseInt(tokens[i+1]));
                    break;
                case "-":
                    ans.add(m, ans.get(m)-Integer.parseInt(tokens[i+1]));
                    break;
                case "*":
                    ans.add(m, ans.get(m)*Integer.parseInt(tokens[i+1]));
                    break;
                case "/":
                    ans.add(m, ans.get(m)/Integer.parseInt(tokens[i+1]));
                    break;
                case "=":
                    m++;
                    ans.add(m, Integer.parseInt(tokens[i+1]));
                    break;
                default:
                    break;
            }
        }
        for (int i = 0; i < m; i++) {
            if (ans.get(i) != ans.get(i+1)){
                return false;
            }
        }
        return true;
    }

    public static boolean polindrome(long init){
        StringBuilder string = new StringBuilder(Long.toString(init));
        while(string.length() >0){
            if(string.toString().equals(string.reverse().toString())){
                return true;
            }
            StringBuilder tmpStr=new StringBuilder();
            for (int i = 0; i < string.length()-1; i+=2) {
                tmpStr.append((string.charAt(i)+string.charAt(i+1)-2*'0'));
            }
            string=tmpStr;
        }
        return false;
    }
}