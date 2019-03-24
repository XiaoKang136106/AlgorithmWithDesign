package 设计模式.desgin_a_builder;
//concreteBuilder 零件
public class ManBuilder implements PersonBuilder
{

	Person person;
	public ManBuilder() {
		person = new Man();
	}
	
	
	@Override
	public void bulidHead() {
		System.out.println("建造男人的头");
	}

	@Override
	public void bulidBody() {
		System.out.println("建造男人的身体");
	}

	@Override
	public void bulidFoot() {
		System.out.println("建造男人的脚");
	}

	@Override
	public Person buildPerson() {
		return new Man();
	}

}
