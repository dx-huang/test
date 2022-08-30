import java.util.Objects;

/**
 * @Author:hdx
 * @Date:2022/7/4 15:20
 * @Description:
 */
public class SortTest {

    public static void main(String[] args) {
        // 5 4 8 3 9 1 7 6
        int[] arr = new int[]{5, 4, 8, 3 ,9 ,1 ,7 ,6};
        print(arr);
//        bubble(arr);
//        selection(arr);
        quick(arr,0,arr.length - 1);
        print(arr);
    }

    //插入
    public static void insertion(int[] arr) {
        for (int j = 0; j < arr.length; j++) {

        }

    }

    //快排
    public static void quick(int[] arr,int left,int right) {
        if (left < right) {
            int i = left;
            int j = right;
            int x = arr[i];
            while (i < j) {
                while (i < j && arr[j] > x)
                    j--;
                if (i < j)
                    arr[i++] = arr[j];
                while (i < j && arr[i] < x)
                    i++;
                if (i < j)
                    arr[j--] = arr[i];
            }
            arr[i] = x;
            quick(arr,left,i - 1);
            quick(arr,i + 1,right);
        }
    }

    //选择
    public static void selection(int[] arr) {
        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            swap(arr,min,i);
        }
    }

    //冒泡
    public static void bubble(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr.length - 1 - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    Integer temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }

    public static void swap(int[] arr,int aIndex,int bIndex) {
        int temp = arr[aIndex];
        arr[aIndex] = arr[bIndex];
        arr[bIndex] = temp;
    }

    public static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
