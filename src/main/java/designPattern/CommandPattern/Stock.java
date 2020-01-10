package designPattern.CommandPattern;

/**
 * @Auther: liuxin
 * @Date: 2020/1/10 16:46
 * @Description:
 */
public class Stock {
	private String name = "ABC";
	private int quantity = 10;

	public void buy(){
		System.out.println("Stock [ Name: "+name+", Quantity: " + quantity +" ] bought");
	}
	public void sell(){
		System.out.println("Stock [ Name: "+name+", Quantity: " + quantity +" ] sold");
	}
}
