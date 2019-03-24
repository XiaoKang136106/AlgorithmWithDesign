package 设计模式.design_b_composite_;
//项目助理
public class ProjectAssistant extends Employer {

	public ProjectAssistant(String name) {
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
