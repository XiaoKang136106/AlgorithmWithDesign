package 设计模式.design_b_composite_;
//程序员
public class Programmer extends Employer{

	public Programmer(String name){
		setName(name);
		employers=null;
		
	}
	
	@Override
	public void add(Employer employer) {
		
	}

	@Override
	public void delete(Employer employer) {
	}

}
