package designPattern.MediatorPattern;

import java.util.Date;

/**
 * @Auther: liuxin
 * @Date: 2020/1/10 17:10
 * @Description:
 */
public class ChatRoom {
	public static void showMessage(User user, String message){
		System.out.println(new Date().toString()
						+ " [" + user.getName() +"] : " + message);
	}
}
