package 设计模式.design_c_memento;

public class Memento {
	
	private String value;
 
	public Memento(String value) {
		this.value = value;
	}
 
	public String getValue() {
		return value;
	}
 
	public void setValue(String value) {
		this.value = value;
	}
}

