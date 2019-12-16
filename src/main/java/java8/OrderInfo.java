package java8;

/**
 * @Auther: liuxin
 * @Date: 2019/12/13 11:08
 * @Description:
 */
public class OrderInfo {
	private String orderNo;
	private String goodsName;

	public OrderInfo(String orderNo,String goodsName){
		this.goodsName = goodsName;
		this.orderNo = orderNo;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
}
