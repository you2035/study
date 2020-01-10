package designPattern.MediatorPattern;

/**
 * @Auther: liuxin
 * @Date: 2020/1/10 17:11
 * @Description: 中介者模式
 */
public class MediatorPatternDemo {
	public static void main(String[] args) {
		User robert = new User("Robert");
		User john = new User("John");

		robert.sendMessage("Hi! John!");
		john.sendMessage("Hello! Robert!");
	}
}
