package 设计模式.design_c_template_;

public abstract class Template {

	//模板子类真正需要实现的方法
	public abstract void print();
	
	//提供规范,等着模板子类去实现方法就行
	public void update(){
		
		for(int i=0;i<2;i++){
			this.print();
		}
	}
}
