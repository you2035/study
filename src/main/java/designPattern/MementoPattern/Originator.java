package designPattern.MementoPattern;

/**
 * @Auther: liuxin
 * @Date: 2020/1/13 16:50
 * @Description:
 */
public class Originator {
	private String state;

	public void setState(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}

	public Memento saveStateToMemento(){
		return new Memento(state);
	}

	public void getStateFromMemento(Memento Memento){
		state = Memento.getState();
	}
}
