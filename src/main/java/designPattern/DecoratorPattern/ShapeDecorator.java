package designPattern.DecoratorPattern;

/**
 * @Auther: liuxin
 * @Date: 2020/1/6 15:27
 * @Description:
 */
public abstract class ShapeDecorator implements Shape{
	protected Shape decoratedShape;

	public ShapeDecorator(Shape decoratedShape){
		this.decoratedShape = decoratedShape;
	}

	public void draw(){
		decoratedShape.draw();
	}
}
