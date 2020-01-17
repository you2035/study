package test;

import java.util.Random;
import java.util.UUID;

/**
 * @Auther: liuxin
 * @Date: 2020/1/17 09:58
 * @Description:
 */
public class UUIDTest {
	public static void main(String[] args) {
		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid);

		System.out.println(getRandomAffixFileName(11));
	}

	public static String getRandomAffixFileName(int length){

		String str="1234567890";

		Random random=new Random();
		StringBuffer sb=new StringBuffer();

		for(int i=0; i<length; ++i){

			int number=random.nextInt(10);

			sb.append(str.charAt(number));
		}

		return sb.toString();
	}
}
