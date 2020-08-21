package javaBase.collection;

import java.util.TreeSet;

/**
 * @Auther: liuxin
 * @Date: 2020/8/21 14:33
 * @Description:
 */
public class SetTest {
	public static void main(String[] args) {
		TreeSet set = new TreeSet();

		set.add("2");
		set.add("3");
		set.add("1");
		set.add("8");
		set.add("4");

		System.out.println(set.toString());

		set.stream().forEach(s -> System.out.print(s+" "));
		System.out.println();
		Object s = set.first();
		System.out.println(s);
	}
}
