
package 对象适配器模式;

public class Test {
	public static void main(String[] args) {
		
		Cock wildCock = new WildCock();
		Duck duck = new CockAdapater(wildCock);
		duck.quack();
		duck.fly();
	}

}
