package designPattern.DecoratorPattern;

/**
 * @Auther: liuxin
 * @Date: 2020/1/6 11:31
 * @Description:
 */
public class Rectangle implements Shape {
	@Override
	public void draw() {
		System.out.println("Shape: Rectangle");
	}
}
