package designPattern.Bridge;

/**
 * @Auther: liuxin
 * @Date: 2020/1/3 16:13
 * @Description:
 */
public class GreenCircle implements DrawAPI {
	@Override
	public void drawCircle(int radius, int x, int y) {
		System.out.println("Drawing Circle[ color: green, radius: "
						+ radius +", x: " +x+", "+ y +"]");
	}
}
