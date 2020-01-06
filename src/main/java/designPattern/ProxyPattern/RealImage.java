package designPattern.ProxyPattern;

/**
 * @Auther: liuxin
 * @Date: 2020/1/6 16:45
 * @Description:
 */
public class RealImage implements Image {
	private String fileName;

	public RealImage(String fileName){
		this.fileName = fileName;
		loadFromDisk(fileName);
	}

	@Override
	public void display() {
		System.out.println("Displaying " + fileName);
	}

	private void loadFromDisk(String fileName){
		System.out.println("Loading " + fileName);
	}
}
