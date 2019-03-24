package 设计模式.desgin_a_prototype_;

public class Test {
	
	public static void main(String[] args) {
		//构造方法创建的
		Prototype prototype1 = new ConcretePrototype("原型模式");
		//通过clone创建的
		Prototype prototype2 = (Prototype) prototype1.clone();
				
		System.out.println(prototype1.getName());
		System.out.println(prototype2.getName());
		System.out.println(prototype1==prototype2);
		
	}

}
