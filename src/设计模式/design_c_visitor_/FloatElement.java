package 设计模式.design_c_visitor_;

public class FloatElement implements Visitable {

	private float value;
	
	public FloatElement(float value){
		this.value = value;
	}
	
	
	public float getValue(){
		return value;
	}
	
	@Override
	public void accept(Visitor visitor) {
		
		visitor.visitFloat(this);
	}

}
