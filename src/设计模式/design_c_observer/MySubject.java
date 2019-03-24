package 设计模式.design_c_observer;

public class MySubject extends AbstractSubject {
	 
	@Override
	public void operation() {
		System.out.println("update self!");
		notifyObservers();
	}
 
}

