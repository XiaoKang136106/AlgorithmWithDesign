package 设计模式.desgin_a_builder;
//Director(组装过程)
public class PersonDirector {
	
	public Person constructPerson(PersonBuilder pb){
		pb.bulidHead();
		pb.bulidBody();
		pb.bulidFoot();
		
		return pb.buildPerson();
		
	}

}
