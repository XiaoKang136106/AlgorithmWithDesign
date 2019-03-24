package 设计模式.desgin_b_adapter_;

public class Adapter implements Target {
	//适配器1
	private Adaptee adaptee;
	//适配器2
	private Adaptee2 adaptee2;
	//创建被适配和适配器
	public Adapter(Adaptee adaptee){
		this.adaptee=adaptee;
	}
	//创建被适配2和适配器
	public Adapter(Adaptee2 adaptee2){
		this.adaptee2=adaptee2;
	}
	//创建被适配1和被适配2和适配器
	public Adapter(Adaptee adaptee,Adaptee2 adaptee2){
		this.adaptee=adaptee;
		this.adaptee2=adaptee2;
	}
	
	@Override
	public void adapteeMethod() {
		adaptee.adapteeMethod();
	}

	@Override
	public void adapterMethod() {
		System.out.println("我是适配器中的方法!!!!!!!!!!!");
	}

	@Override
	public void adapteeMethod2() {
		adaptee2.adapteeMethod2();
	}

}
