package 对象适配器模式;

public class WildCock implements Cock {

	@Override
	public void gobble() {

		System.out.println("鸡的咕咕叫!!!!!!");
	}

	@Override
	public void fly() {
		System.out.println("鸡在飞!!!");
	}

}
