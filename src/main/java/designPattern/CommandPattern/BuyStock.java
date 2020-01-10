package designPattern.CommandPattern;

/**
 * @Auther: liuxin
 * @Date: 2020/1/10 16:47
 * @Description:
 */
public class BuyStock implements Order{
	private Stock abcStock;

	public BuyStock(Stock abcStock){
		this.abcStock = abcStock;
	}

	public void execute() {
		abcStock.buy();
	}
}
