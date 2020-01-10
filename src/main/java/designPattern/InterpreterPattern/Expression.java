package designPattern.InterpreterPattern;

/**
 * @Auther: liuxin
 * @Date: 2020/1/10 16:55
 * @Description:
 */
public interface Expression {
	public boolean interpret(String context);
}
