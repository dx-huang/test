import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @Author:hdx
 * @Date:2021/9/17 17:20
 */
public class Area {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请依次输入长方体的长、宽、高（每输入一次数字后按回车）:");
        double length = scanner.nextDouble();
        double width = scanner.nextDouble();
        double high = scanner.nextDouble();
        DecimalFormat df = new DecimalFormat("#0.00");
        String volume = df.format(area(length, width) * high);
        System.out.println("长方体的体积：" + volume);
//        test.main();
    }


    public static Double area(Double length, Double width) {
        DecimalFormat df = new DecimalFormat("#0.00");
        return Double.valueOf(df.format(length * width));
    }
}
