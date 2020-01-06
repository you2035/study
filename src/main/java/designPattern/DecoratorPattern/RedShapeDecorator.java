package designPattern.DecoratorPattern;

/**
 * @Auther: liuxin
 * @Date: 2020/1/6 15:28
 * @Description:
 */
public class RedShapeDecorator extends ShapeDecorator {
	public RedShapeDecorator(Shape decoratedShape) {
		super(decoratedShape);
	}

	@Override
	public void draw() {
		decoratedShape.draw();
		setRedBorder(decoratedShape);
	}

	private void setRedBorder(Shape decoratedShape){
		System.out.println("Border Color: Red");
	}
}
