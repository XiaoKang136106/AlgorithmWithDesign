package 设计模式.desgin_a_builder;

public class Test {
	
	
	public static void main(String[] args) {
		PersonDirector pesonDirector = new PersonDirector();
		
		
		Man man = (Man) pesonDirector.constructPerson(new ManBuilder());
	
		System.out.println(man);
		
		
	}

}
