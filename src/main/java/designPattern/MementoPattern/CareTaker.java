package designPattern.MementoPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: liuxin
 * @Date: 2020/1/13 16:50
 * @Description:
 */
public class CareTaker {
	private List<Memento> mementoList = new ArrayList<Memento>();

	public void add(Memento state){
		mementoList.add(state);
	}

	public Memento get(int index){
		return mementoList.get(index);
	}
}
