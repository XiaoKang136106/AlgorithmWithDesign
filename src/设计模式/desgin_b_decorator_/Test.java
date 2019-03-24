package 设计模式.desgin_b_decorator_;

public class Test {

	public static void main(String[] args) {
		//创建女人对象
		Woman woman = new Woman();
		//创建装饰者对象
		DecoratorA decoratorA = new DecoratorA();
		
		decoratorA.setPerson(woman);
		//对woman方法进行了增强
		//decoratorA.eat();
		
		DecoratorB decoratorB = new DecoratorB();
		//对decoratorA的方法进行再增强
		decoratorB.setPerson(decoratorA);
		decoratorB.eat();
	}
	
}
