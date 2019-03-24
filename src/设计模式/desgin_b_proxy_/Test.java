package 设计模式.desgin_b_proxy_;

import java.net.Proxy;

public class Test {

	public static void main(String[] args) {
		
		Object obj = new ProxyObject();
		obj.action();
	}
}
