package designPattern.StatePattern;

/**
 * @Auther: liuxin
 * @Date: 2020/1/13 17:15
 * @Description:
 */
public class Context {
	private State state;

	public Context(){
		state = null;
	}

	public void setState(State state){
		this.state = state;
	}

	public State getState(){
		return state;
	}
}
