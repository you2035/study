package designPattern.MediatorPattern;

/**
 * @Auther: liuxin
 * @Date: 2020/1/10 17:11
 * @Description:
 */
public class User {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User(String name){
		this.name  = name;
	}

	public void sendMessage(String message){
		ChatRoom.showMessage(this,message);
	}
}
