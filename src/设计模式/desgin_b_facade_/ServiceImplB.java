package 设计模式.desgin_b_facade_;

import java.util.concurrent.SynchronousQueue;

public class ServiceImplB implements ServiceB {

	@Override
	public void methodB() {
		
		System.out.println("我是ServiceB中的methodB");
	}

}
