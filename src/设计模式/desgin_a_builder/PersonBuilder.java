package 设计模式.desgin_a_builder;
//Builder (构造部件)
public interface PersonBuilder {
	
	void bulidHead();
	
	void bulidBody();
	
	void bulidFoot();

	
	Person buildPerson();
}
