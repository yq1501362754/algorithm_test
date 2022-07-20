package org.demo.test;

import org.junit.jupiter.api.Test;

/**
 * @author yanqi
 */
public class Search {

  /**
   * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
   * <p>
   * <p>
   * 示例 1:
   * <p>
   * 输入: nums = [-1,0,3,5,9,12], target = 9 输出: 4 解释: 9 出现在 nums 中并且下标为 4 示例 2:
   * <p>
   * 输入: nums = [-1,0,3,5,9,12], target = 2 输出: -1 解释: 2 不存在 nums 中因此返回 -1
   * <p>
   * <p>
   * 提示：
   * <p>
   * 你可以假设 nums 中的所有元素是不重复的。 n 将在 [1, 10000]之间。 nums 的每个元素都将在 [-9999, 9999]之间。 题解: 在升序数组  中寻找目标值 ，对于特定下标 ，比较  和  的大小：
   * <p>
   * 如果 ，则下标  即为要寻找的下标；
   * <p>
   * 如果 ，则  只可能在下标  的左侧；
   * <p>
   * 如果 ，则  只可能在下标  的右侧。
   * <p>
   * 基于上述事实，可以在有序数组中使用二分查找寻找目标值。
   * <p>
   * 二分查找的做法是，定义查找的范围 ，初始查找范围是整个数组。每次取查找范围的中点 ，比较num[mid]和target 的大小，如果相等则mid即为要寻找的下标，如果 num[mid]>target 那么height 缩小一半 如果num[mid]<target 那么low 将加一半。
   * <p>
   * 由于每次查找都会将查找范围缩小一半，因此二分查找的时间复杂度是 ，其中height是数组的长度。
   * <p>
   * 二分查找的条件是查找范围不为空，即 。如果  在数组中，二分查找可以保证找到 ，返回  在数组中的下标。如果  不在数组中，则当  时结束查找，返回 。
   */
  public int binarySearch(int[] nums, int target) {
    int low = 0;
    int height = nums.length - 1;
    while (low <= height) {
      int mid = (height - low) / 2 + low;
      int num = nums[mid];
      if (num == target) {
        return mid;
      } else if (num > target) {
        height = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return -1;
  }

  @Test
  public void binarySearchTest() {
    int nums[] = new int[]{-1, 0, 3, 5, 9, 12};
    System.out.println(binarySearch(nums, 12));

  }
}
