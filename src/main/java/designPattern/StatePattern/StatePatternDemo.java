package designPattern.StatePattern;

/**
 * @Auther: liuxin
 * @Date: 2020/1/13 17:16
 * @Description: 状态模式
 */
public class StatePatternDemo {
	public static void main(String[] args) {
		Context context = new Context();

		StartState startState = new StartState();
		startState.doAction(context);

		System.out.println(context.getState().toString());

		StopState stopState = new StopState();
		stopState.doAction(context);

		System.out.println(context.getState().toString());
	}
}
