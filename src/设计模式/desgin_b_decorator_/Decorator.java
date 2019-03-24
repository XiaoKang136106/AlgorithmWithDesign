package 设计模式.desgin_b_decorator_;

public abstract class Decorator implements Person {
	
	protected Person person;//
	
	

	public void setPerson(Person person) {
		this.person = person;
	}


	@Override
	public void eat() {
		person.eat(); //调用的是实现类
	}

}
