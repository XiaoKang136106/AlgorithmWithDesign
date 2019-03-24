package 设计模式.design_b_composite_;

import java.util.ArrayList;
//项目经理
public class ProjectManager extends Employer {

	public ProjectManager(String name){
		
		setName(name);
		employers=new ArrayList<Employer>();
		
	}
	
	@Override
	public void add(Employer employer) {
		employers.add(employer);
	}

	@Override
	public void delete(Employer employer) {
		employers.remove(employer);
	}

}
