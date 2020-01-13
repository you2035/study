package designPattern.StatePattern;

/**
 * @Auther: liuxin
 * @Date: 2020/1/13 17:14
 * @Description:
 */
public class StartState implements State{
	public void doAction(Context context) {
		System.out.println("Player is in start state");
		context.setState(this);
	}

	public String toString(){
		return "Start State";
	}
}
