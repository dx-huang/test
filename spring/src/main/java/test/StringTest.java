package test;

/**
 * @Author:hdx
 * @Date:2022/4/8 14:48
 * @Description:
 */
public class StringTest {

    /**
     * 小任务(以下任务要求设计成方法)
     * 	1.设计一个方法 将字符串反转   ok-->ko
     * 	2.设计一个方法 将给定字符串的正序和反序进行连接  ok-->okko
     * 	3.设计一个方法 判断给定字符串是否是回文    abccba   abcba
     * 	4.设计一个方法 将给定的字符串右位移x位置  (helloworld,2) --> ldhellowor
     * 	5.设计一个方法 寻找若干字符串中最长的那个  ab,abc,abcd--->abcd
     * 	6.设计一个方法 统计给定字母在字符串中出现的次数   "this is a test of java","a"--->3
     * 	7.设计一个方法 将给定的字符串每一个首字母大写   "this is a test of java"--->"This Is A Test Of Java"
     * 	8.设计一个方法 获取给定字符串中的全部数字   "za1o1zbp24tcq"--->1124
     */

    public static void main(String[] args) {
//        System.out.println(reverse("hello"));
//        System.out.println(concatReverse("hello"));
//        System.out.println(palindrome("abccba"));
//        System.out.println(shiftRight("helloworld", 2));
//        System.out.println(findLongestStr("aaaaaaaab,abasac,abcd,b"));
//        System.out.println(countLetter("this is a test of java", "i"));
//        System.out.println(firstLetterUpperCase("this is a test of java"));
        System.out.println(findAllNum("za1o1zbp24tcq"));
    }

    //1.设计一个方法 将字符串反转   ok-->ko
    public static String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    //2.设计一个方法 将给定字符串的正序和反序进行连接  ok-->okko
    public static String concatReverse(String str) {
        return str + reverse(str);
    }

    //3.设计一个方法 判断给定字符串是否是回文    abccba   abcba
    public static boolean palindrome(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length/2; i++) {
            if (chars[i] != chars[chars.length-1-i]) {
                return false;
            }
        }
        return true;
    }

    //4.设计一个方法 将给定的字符串右位移x位置  (helloworld,2) --> ldhellowor
    public static String shiftRight(String str,int num) {
        num = num % str.length();
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        int length = chars.length;
        for (int i = length - num; i < length; i++) {
            sb.append(chars[i]);
        }
        for (int i = 0; i < length - num; i++) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    //5.设计一个方法 寻找若干字符串中最长的那个  ab,abc,abcd--->abcd
    public static String findLongestStr(String str) {
        String longest = "";
        try {
            String[] strArray = str.split(",");
            longest = strArray[0];
            for (String s : strArray) {
                if (s.length() > longest.length()) {
                    longest = s;
                }
            }
        }catch (Exception e) {
            return "请输入正确格式";
        }
        return longest;

    }

    //6.设计一个方法 统计给定字母在字符串中出现的次数   "this is a test of java","a"--->3
    public static int countLetter(String str,String letter) {
       return str.length() - str.replace(letter, "").length();
    }

    //7.设计一个方法 将给定的字符串每一个首字母大写   "this is a test of java"--->"This Is A Test Of Java"
    public static String firstLetterUpperCase(String str) {
        String[] strArray = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s : strArray) {
            sb.append(s.substring(0,1).toUpperCase() + s.substring(1) + " ");
        }
        return sb.toString();
    }

    //8.设计一个方法 获取给定字符串中的全部数字   "za1o1zbp24tcq"--->1124
    public static String findAllNum(String str) {
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (c >= 49 && c <= 57) {
                sb.append(c);
            }
        }
        return sb.toString();
    }




}
