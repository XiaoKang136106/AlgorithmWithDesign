package 设计模式.design_c_mediator;



public class Test {
	
	public static void main(String[] args) {
		
		Mediator med = new ConcreteMediator();
		//老板来了
		med.notice("boss");
		//客户来了
		med.notice("client");
	}

}
