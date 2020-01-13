package designPattern.ObserverPattern;

/**
 * @Auther: liuxin
 * @Date: 2020/1/13 17:02
 * @Description:
 */
public class OctalObserver extends Observer{
	public OctalObserver(Subject subject){
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public void update() {
		System.out.println( "Octal String: "
						+ Integer.toOctalString( subject.getState() ) );
	}
}
