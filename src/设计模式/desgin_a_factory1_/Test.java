package 设计模式.desgin_a_factory1_;

public class Test {
		
	public static void main(String[] args) {
		//创建工厂对象	(字需要修改工厂实例就行了)
		IWorkerFactory factory = new TeacherWorkerFactory();
		//获取对象实例
		Worker worker = factory.getWorker();
		//调用方法
		worker.doWork();								
				
	}

}
