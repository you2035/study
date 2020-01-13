package designPattern.MementoPattern;

/**
 * @Auther: liuxin
 * @Date: 2020/1/13 16:49
 * @Description:
 */
public class Memento {
	private String state;

	public Memento(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}
}
