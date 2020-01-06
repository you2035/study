package designPattern.ProxyPattern;

/**
 * @Auther: liuxin
 * @Date: 2020/1/6 16:45
 * @Description:
 */
public class ProxyImage implements Image{
	private RealImage realImage;
	private String fileName;

	public ProxyImage(String fileName){
		this.fileName = fileName;
	}

	@Override
	public void display() {
		if(realImage == null){
			realImage = new RealImage(fileName);
		}
		realImage.display();
	}
}
