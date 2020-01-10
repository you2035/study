package designPattern.ChainOfResponsibilityPattern;

/**
 * @Auther: liuxin
 * @Date: 2020/1/10 16:37
 * @Description:
 */
public class FileLogger extends AbstractLogger {
	public FileLogger(int level){
		this.level = level;
	}

	@Override
	protected void write(String message) {
		System.out.println("File::Logger: " + message);
	}
}
