package designPattern.ProxyPattern;

/**
 * @Auther: liuxin
 * @Date: 2020/1/6 16:46
 * @Description: 代理模式
 */
public class ProxyPatternDemo {
	public static void main(String[] args) {
		Image image = new ProxyImage("test_10mb.jpg");

		// 图像将从磁盘加载
		image.display();
		System.out.println("");
		// 图像不需要从磁盘加载
		image.display();
	}
}
