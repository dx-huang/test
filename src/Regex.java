import com.sun.xml.internal.ws.util.StringUtils;

/**
 * @author HDX
 * @date 2021/8/2
 * @Description 正则表达式测试
 */
public class Regex {
    public static void main(String[] args) {
        //1.小于8位
        System.out.println("1:"+checkPasswordFormal("12ja@"));
        //2.大于16
        System.out.println("2:"+checkPasswordFormal("12ja@456789zxvbn,m=shj"));
        //3.8-16位 纯数字
        System.out.println("3:"+checkPasswordFormal("0123456789"));
        //4.8-16位 纯字母
        System.out.println("4:"+checkPasswordFormal("zxcvbnmasd"));
        //5.8-16位 纯字符
        System.out.println("5:"+checkPasswordFormal("!#$%^$@!!#$@"));
        //6.8-16位 数字+字母
        System.out.println("6:"+checkPasswordFormal("12ja456zxcv"));
        //7.8-16位 数字+字符
        System.out.println("7:"+checkPasswordFormal("123456@!#%"));
        //8.8-16位 字母+字符
        System.out.println("8:"+checkPasswordFormal("asdfghj@!$"));
        //9.8-16位 数字+字母+字符
        System.out.println("9:"+checkPasswordFormal("12ja#aDdja@"));
        System.out.println("9:"+checkPasswordFormal("aj12#Aadja@"));
        System.out.println("9:"+checkPasswordFormal("@12ja#aDdja"));
        System.out.println("9:"+checkPasswordFormal("@ja#aFAadja12"));
        System.out.println("9:"+checkPasswordFormal("@ja#adAASAja12"));
        System.out.println("10:"+checkPasswordFormal("ABCabc012!@#"));


    }


    public static boolean checkPasswordFormal(String value) {
//        String letterRegex = "[a-zA-Z]";
//        String numRegex = "[0-9]";
//        String charRegex = "[`~!@#$^&*()=|{}':;',\\\\[\\\\].<>/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？+-/]";
//        if (value.matches(letterRegex)) {
//            System.out.println("1");
//        }
//        if (value.matches(numRegex)) {
//            System.out.println("2");
//        }
//        if (value.matches(charRegex)){
//            System.out.println("3");
//        }
//        return value.matches(letterRegex) && value.matches(numRegex) && value.matches(charRegex)
//                && (value.length() >= 8 && value.length() <= 16);
        String regex = "^(?![A-Za-z0-9]+$)(?![A-Za-z\\W]+$)(?![0-9\\W]+$)[a-zA-Z0-9\\W]{8,16}$";
        return value.matches(regex);
    }
}
