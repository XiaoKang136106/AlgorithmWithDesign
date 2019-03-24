package 设计模式.desgin_b_decorator_;

public class DecoratorA extends Decorator {

	@Override
	public void eat() {
		super.eat();
		this.reEat();
		System.out.println("我是DecoractorA中的eat方法");
	
	}
	
	public void reEat(){
		
		System.out.println("我要在吃一顿饭");
	}

	
	
}
