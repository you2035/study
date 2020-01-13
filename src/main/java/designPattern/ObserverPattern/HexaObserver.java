package designPattern.ObserverPattern;

/**
 * @Auther: liuxin
 * @Date: 2020/1/13 17:03
 * @Description:
 */
public class HexaObserver extends Observer {
	public HexaObserver(Subject subject){
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public void update() {
		System.out.println( "Hex String: "
						+ Integer.toHexString( subject.getState() ).toUpperCase() );
	}
}
