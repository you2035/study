package designPattern.ChainOfResponsibilityPattern;

/**
 * @Auther: liuxin
 * @Date: 2020/1/10 16:36
 * @Description:
 */
public class ErrorLogger extends AbstractLogger {
	public ErrorLogger(int level){
		this.level = level;
	}

	@Override
	protected void write(String message) {
		System.out.println("Error Console::Logger: " + message);
	}
}
