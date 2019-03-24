package 设计模式.desgin_b_adapter_;

public class Test {
	
	public static void main(String[] args) {
		
		Target target = new Adapter(new Adaptee(),new Adaptee2());
		
		//调用被适配器中的方法
		target.adapteeMethod();
		//调用适配器中的方法
		target.adapterMethod();
		//调用适配器2中的方法
		target.adapteeMethod2();
		
	}

}
