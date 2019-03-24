package 设计模式.design_c_visitor_;

public class StringElement implements Visitable {

	private String value;
	
	public StringElement(String value){
		this.value=value;
	}
	
	
	public String getValue(){
		
		return value;
	}
	@Override
	public void accept(Visitor visitor) {
			
		
		visitor.visitString(this);
	}

}
