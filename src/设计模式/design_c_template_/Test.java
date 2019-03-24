package 设计模式.design_c_template_;

public class Test {
	public static void main(String[] args) {
		
		
		Template tmpA = new ConcreteTemplateA();
		tmpA.update();
		Template tmpB = new ConcreteTemplateB();
		tmpB.update();
	}

}
