package designPattern.CommandPattern;

/**
 * @Auther: liuxin
 * @Date: 2020/1/10 16:47
 * @Description:
 */
public class SellStock implements Order {
	private Stock abcStock;

	public SellStock(Stock abcStock){
		this.abcStock = abcStock;
	}

	public void execute() {
		abcStock.sell();
	}
}
