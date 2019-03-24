package 设计模式.desgin_b_decorator_;

public class DecoratorB extends Decorator {

	@Override
	public void eat() {
		super.eat();
		
		System.out.println("我是DecoratorB中的eat方法");
	}

	
	
}
