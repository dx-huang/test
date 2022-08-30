import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author:hdx
 * @Date:2022/8/30 13:51
 * @Description:
 */
public class TimeUtils {

    public static void main(String[] args) {
        System.out.println(getNotTimeStr());
    }

    public static int getNotTimeTimeStamp() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    public static String getNotTimeStr() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = sdf.format(new Date());
        return nowTime;
    }

    public static String getNotTimeStr(String pattern) {
        if (pattern == null) pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String nowTime = sdf.format(new Date());
        return nowTime;
    }
}
