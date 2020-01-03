package designPattern.Bridge;

/**
 * @Auther: liuxin
 * @Date: 2020/1/3 16:14
 * @Description:
 */
public abstract class Shape {
	protected DrawAPI drawAPI;
	protected Shape(DrawAPI drawAPI){
		this.drawAPI = drawAPI;
	}
	public abstract void draw();
}
