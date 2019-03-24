package 对象适配器模式;
//鸡的适配器,需要将鸡变成鸭,所以,需要实现鸭的接口,使用的是鸡的方法,起到适配,以假乱真
public class CockAdapater implements Duck {

	private Cock cock;
	
	public CockAdapater(Cock cock) {
		this.cock = cock;
	
	}
	
	@Override
	public void quack() {
		cock.gobble();
	}

	@Override
	public void fly() {
		cock.fly();
	}



	

}
