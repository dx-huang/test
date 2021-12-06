import java.util.Scanner;

/**
 * @Author:hdx
 * @Date:2021/9/17 17:37
 */
public class Score {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学生成绩（按n结束成绩录入）：");
        Double[] a = new Double[100];
        int count = 0;
        while (true) {
            String score = scanner.next();
            if ("n".equals(score)) break;
            a[count++] = Double.parseDouble(score);

        }
        Double sum = 0.0;
        System.out.println("学生成绩：");
        for (int i = 0; i < count; i++) {
            System.out.print(a[i] + " ");
            sum +=  a[i];
        }
        Double average = sum / count;
        System.out.println("学生成绩的平均值：" + average);
    }
}
