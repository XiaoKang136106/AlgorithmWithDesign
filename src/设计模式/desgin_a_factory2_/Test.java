package 设计模式.desgin_a_factory2_;

public class Test {

	
	
	public static void main(String[] args) {
		IAnimalFactory factory = new WhiteAnimalFactory();
		ICat whiteCat = factory.createCat();
		whiteCat.eat();
	}
}
