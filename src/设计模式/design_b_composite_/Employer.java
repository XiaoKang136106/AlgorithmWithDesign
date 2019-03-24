package 设计模式.design_b_composite_;

import java.util.List;

public abstract class Employer {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public abstract void add(Employer employer);
	
	public abstract void delete(Employer employer);
	
	public void getInfo(Employer employer){
		
		System.out.println(employer.getName());
	}
	
	public List<Employer> employers;
	public List<Employer> getEmployers(){
		
		return employers;
	}
	
	
}
