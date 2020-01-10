package designPattern.JavaProxy;

import java.lang.reflect.Proxy;

/**
 * @Auther: liuxin
 * @Date: 2020/1/8 14:38
 * @Description:
 */
public class Client {
	public static void main(String[] args) {
		//真实对象
		Subject realSubject =  new RealSubject();

		MyInvocationHandler myInvocationHandler = new MyInvocationHandler(realSubject);
		//代理对象
		Subject proxyClass = (Subject) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Subject.class}, myInvocationHandler);

		proxyClass.sellBooks();

		proxyClass.speak();
	}
}
