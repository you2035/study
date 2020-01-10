package designPattern.CommandPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: liuxin
 * @Date: 2020/1/10 16:48
 * @Description:
 */
public class Broker {
	private List<Order> orderList = new ArrayList<Order>();

	public void takeOrder(Order order){
		orderList.add(order);
	}

	public void placeOrders(){
		for (Order order : orderList) {
			order.execute();
		}
		orderList.clear();
	}
}
