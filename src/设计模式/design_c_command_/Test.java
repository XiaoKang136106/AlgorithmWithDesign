package 设计模式.design_c_command_;

public class Test {
	
	public static void main(String[] args) {
		//创建接受类
		Receiver rec = new Receiver();
		//创建命令类
		Command com = new CommandImpl(rec);
		//创建唤醒类
		Invoker in = new Invoker(com);
		in.execute();
	}

}
