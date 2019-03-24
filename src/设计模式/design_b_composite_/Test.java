package 设计模式.design_b_composite_;

import java.util.List;

public class Test {

	public static void main(String[] args) {
		
		Employer pr = new Programmer("程序员");
		
		Employer pa = new ProjectAssistant("项目助理");
		
		Employer pm = new ProjectManager("项目经理");
		//只有项目经理有权利对下属添加或者删除,叶子结点的下属无法进行添加或者删除的操作
		pm.add(pr);
		pm.add(pa);
		List<Employer> employers = pm.getEmployers();	
	
		for (Employer employer : employers) {
			 employer.getInfo(employer);
		}
	}
	
}
