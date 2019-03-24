package 设计模式.desgin_b_facade_;
//Facade
public class Facade {
	public ServiceA serviceA;
	
	public  ServiceB serviceB;
	
	public Facade(){
		
		serviceA=new ServiceImplA();
		serviceB = new ServiceImplB();
	}
	
	public void method(){
		serviceA.methodA();
		serviceB.methodB();
		
	}
	
	
	
	
	

}
