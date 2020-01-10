package designPattern.InterpreterPattern;

/**
 * @Auther: liuxin
 * @Date: 2020/1/10 16:56
 * @Description:
 */
public class AndExpression implements Expression {
	private Expression expr1 = null;
	private Expression expr2 = null;

	public AndExpression(Expression expr1, Expression expr2) {
		this.expr1 = expr1;
		this.expr2 = expr2;
	}

	@Override
	public boolean interpret(String context) {
		return expr1.interpret(context) && expr2.interpret(context);
	}
}
