package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: liuxin
 * @Date: 2020/3/5 15:51
 * @Description:给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数
 * ，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 */
public class TwoSum {
	public static void main(String[] args) {
		int nums[] =new int[]{11,7,2,15};
		int targetArray[] = hashSolution(nums,9);

		for (int i = 0; i < targetArray.length; i++) {
			System.out.println(targetArray[i]);
		}
	}

	//暴力法
	public static int[] solution(int[] nums, int target) {

		if(nums.length <= 1 || nums == null){
			return null;
		}

		for (int i = 0; i < nums.length; i++) {
			for (int j = i+ 1; j < nums.length; j++) {
				if(nums[i]+nums[j] == target){
					return new int[]{i,j};
				}
			}
		}

		return null;
	}

	//hash方式
	public static int[] hashSolution(int[] nums, int target) {
		if (nums == null || nums.length <= 1) {
			return null;
		}
		Map<Integer, Integer> map = new HashMap<>(nums.length);
		for (int i = 0; i < nums.length; i++) {
			int v = target - nums[i];
			Integer exist = map.get(v);
			if (exist != null) {
				return new int[] { exist, i };
			}
			map.put(nums[i], i);
		}

		return null;
	}
}
