package designPattern.StatePattern;

/**
 * @Auther: liuxin
 * @Date: 2020/1/13 17:16
 * @Description:
 */
public class StopState implements State {
	public void doAction(Context context) {
		System.out.println("Player is in stop state");
		context.setState(this);
	}

	public String toString(){
		return "Stop State";
	}
}
