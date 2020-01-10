package designPattern.JavaProxy;

/**
 * @Auther: liuxin
 * @Date: 2020/1/8 14:34
 * @Description:
 */
public class RealSubject implements Subject{
	@Override
	public int sellBooks() {
		System.out.println("卖书");
		return 1 ;
	}

	@Override
	public String speak() {
		System.out.println("说话");
		return "张三";
	}
}
