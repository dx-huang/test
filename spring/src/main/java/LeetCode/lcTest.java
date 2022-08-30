package LeetCode;

import java.util.*;

/**
 * @Author:hdx
 * @Date:2022/5/18 11:01
 * @Description:
 */
public class lcTest {


    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum(nums);
        for (int i = 0; i < lists.size(); i++) {
            for (int i1 = 0; i1 < lists.get(i).size(); i1++) {
                System.out.print(lists.get(i).get(i1) + " ");
            }
            System.out.println();
        }
//        HashSet<HashSet<Integer>> setHashSet = new HashSet<>();
//        setHashSet.add(new HashSet<>(Arrays.asList(1,2,3)));
//        setHashSet.add(new HashSet<>(Arrays.asList(3,2,1)));
//        System.out.println(setHashSet.size());
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length <= 2) return null;
        HashSet<HashSet<Integer>> setSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int i1 = 1 + i; i1 < nums.length; i1++) {
                for (int i2 = 2 + i; i2 < nums.length; i2++) {
                    if (nums[i] + nums[i1] + nums[i2] == 0) {
                        setSet.add(new HashSet<>(Arrays.asList(nums[i],nums[i1],nums[i2])));
                    }
                }
            }
        }
        List<List<Integer>> listList = new LinkedList<>();
        Iterator<HashSet<Integer>> iterator = setSet.iterator();
        while (iterator.hasNext()) {
            listList.add(new ArrayList<>(iterator.next()));
        }
        return listList;

    }



}
