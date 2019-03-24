package 设计模式.desgin_b_proxy_;

public class ProxyObject implements Object{

	Object obj;
	public ProxyObject(){
		System.out.println("我是代理类,同时创建被代理类的实例");
		obj= new ObjectImpl();
		
	}
	
	@Override
	public void action() {
		System.out.println("执行代理前处理");
		//执行被代理类的方法
		obj.action();
		System.out.println("执行代理后处理");
		
		
	}

}
