package algorithm;

import java.util.Arrays;

public class BinSearch {
  public static void main(String[] args) {
    int[] srcArray = {3, 5, 11, 3, 1,2,21, 23, 28, 30, 32, 50, 64, 78, 81, 95, 101};
//    System.out.println(binSearch(srcArray, 28));
//    bubbleSort(srcArray);
    quickSort(srcArray,0,16);
  }

  /**
   * 二分查找普通循环实现
   *
   * @param srcArray 有序数组
   * @param key      查找元素
   * @return
   */
  public static int binSearch(int srcArray[], int key) {
    int mid = srcArray.length / 2;
    // System.out.println("=:"+mid);
    if (key == srcArray[mid]) {
      return mid;
    }
    //二分核心逻辑
    int start = 0;
    int end = srcArray.length - 1;
    while (start <= end) {
      // System.out.println(start+"="+end);
      mid = (end - start) / 2 + start;
      if (key < srcArray[mid]) {
        end = mid - 1;
      } else if (key > srcArray[mid]) {
        start = mid + 1;
      } else {
        return mid;
      }
    }
    return -1;
  }

  /**
   * 二分查找递归实现
   *
   * @param srcArray 有序数组
   * @param start    数组低地址下标
   * @param end      数组高地址下标
   * @param key      查找元素
   * @return 查找元素不存在返回-1
   */
  public static int binSearch(int srcArray[], int start, int end, int key) {
    int mid = (end - start) / 2 + start;
    if (srcArray[mid] == key) {
      return mid;
    }
    if (start >= end) {
      return -1;
    } else if (key > srcArray[mid]) {
      return binSearch(srcArray, mid + 1, end, key);
    } else if (key < srcArray[mid]) {
      return binSearch(srcArray, start, mid - 1, key);
    }
    return -1;
  }

  /**
   * 冒泡排序
   * <p>
   * <p>
   * <p>
   * ①. 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
   * <p>
   * ②. 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
   * <p>
   * ③. 针对所有的元素重复以上的步骤，除了最后一个。
   * <p>
   * ④. 持续每次对越来越少的元素重复上面的步骤①~③，直到没有任何一对数字需要比较。
   *
   * @param arr 待排序数组
   */
  public static void bubbleSort(int[] arr) {
    for (int i = arr.length; i > 0; i--) { //外层循环移动游标
      for (int j = 0; j < i && (j + 1) < i; j++) { //内层循环遍历游标及之后(或之前)的元素
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
          System.out.println("Sorting: " + Arrays.toString(arr));
        }
      }
    }
  }

  /**
   * 快速排序（递归）
   * <p>
   *   快速排序
   *
   * 快速排序使用分治策略来把一个序列（list）分为两个子序列（sub-lists）。步骤为：
   *
   * ①从数列中挑出一个元素，称为”基准”（pivot）。
   *
   * ②重新排序数列，所有比基准值小的元素摆放在基准前面，所有比基准值大的元素摆在基准后面（相同的数可以到任一边）。
   * 在这个分区结束之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
   *
   * ③递归地（recursively）把小于基准值元素的子数列和大于基准值元素的子数列排序。
   *
   * 递归到最底部时，数列的大小是零或一，也就是已经排序好了。这个算法一定会结束，因为在每次的迭代（iteration）中，
   * 它至少会把一个元素摆到它最后的位置去。
   *
   * 代码实现：
   *
   * 用伪代码描述如下：
   *
   * ①i = L; j = R; 将基准数挖出形成第一个坑a[i]。
   *
   * ②j--，由后向前找比它小的数，找到后挖出此数填前一个坑a[i]中。
   *
   * ③i++，由前向后找比它大的数，找到后也挖出此数填到前一个坑a[j]中。
   *
   * ④再重复执行②，③二步，直到i==j，将基准数填入a[i]中。
   *
   * 快速排序采用“分而治之、各个击破”的观念，此为原地（In-place）分区版本。
   * <p>
   * @param arr  待排序数组
   * @param low  左边界
   * @param high 右边界
   */

  public static void quickSort(int[] arr, int low, int high) {
    if (arr.length <= 0) return;
    if (low >= high) return;
    int left = low;
    int right = high;
    int temp = arr[left]; //挖坑1：保存基准的值
    while (left < right) {
      while (left < right && arr[right] >= temp) { //坑2：从后向前找到比基准小的元素，插入到基准位置坑1中
        right--;
      }
      arr[left] = arr[right];
      while (left < right && arr[left] <= temp) { //坑3：从前往后找到比基准大的元素，放到刚才挖的坑2中
        left++;
      }
      arr[right] = arr[left];
    }
    arr[left] = temp; //基准值填补到坑3中，准备分治递归快排
    System.out.println("Sorting: " + Arrays.toString(arr));
    quickSort(arr, low, left - 1);
    quickSort(arr, left + 1, high);
  }
}
