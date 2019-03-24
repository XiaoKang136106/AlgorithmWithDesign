package 设计模式.design_c_iterator_;

public interface List {

	int getSize();
	
	void  add(Object obj);
	
	Object get(int index);
	
	

    Iterator iterator();
}
