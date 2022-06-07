package generics;

import java.util.TreeSet;

public class ComparableTeste {

	public static void main(String[] args) {
		
		TreeSet<Integer> nums = new TreeSet<Integer>();
		
		nums.add(10);
		nums.add(1);
		nums.add(1);
		nums.add(6);
		nums.add(18);
		nums.add(-13);
		nums.add(110);
		nums.add(59);
		nums.add(2);
		nums.add(48);
		
		for (Integer integer : nums) {
			System.out.println(integer);
		}
	}
}
