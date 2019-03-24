package 设计模式.desgin_b_bridge_;

public class MyBridge extends Bridge {
	public void method(){
		getSource().method();
	}
}

