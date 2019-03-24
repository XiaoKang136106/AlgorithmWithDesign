package 设计模式.design_c_iterator_;

public class ListImpl implements List {
	
	
	private Object[] list;
	
	private int index;
	
	private int size;
	//初始化参数
	public ListImpl(){
		index = 0;
        size = 0;
        list = new Object[100];
	}
	
	public Iterator iterator(){
		return new IteratorImpl(this);
	}
	
	
	@Override
	public int getSize() {
		return this.size;
	}

	@Override
	public void add(Object obj) {
		list[index++]=obj;
		size++;
	}

	@Override
	public Object get(int index) {
		return list[index];
	}

}
