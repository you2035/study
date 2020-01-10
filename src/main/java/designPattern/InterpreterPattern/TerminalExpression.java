package designPattern.InterpreterPattern;

/**
 * @Auther: liuxin
 * @Date: 2020/1/10 16:55
 * @Description:
 */
public class TerminalExpression implements Expression {
	private String data;

	public TerminalExpression(String data){
		this.data = data;
	}

	@Override
	public boolean interpret(String context) {
		if(context.contains(data)){
			return true;
		}
		return false;
	}
}
