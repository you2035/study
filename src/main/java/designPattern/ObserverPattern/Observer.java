package designPattern.ObserverPattern;

/**
 * @Auther: liuxin
 * @Date: 2020/1/13 17:01
 * @Description:
 */
public abstract class Observer {
	protected Subject subject;
	public abstract void update();
}
