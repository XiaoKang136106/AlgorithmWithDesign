package 设计模式.design_c_iterator_;


public class IteratorImpl implements Iterator {
	
	private List list;
	
	private int index;
	
	public IteratorImpl(List list){
		index= 0;
		this.list= list;
	}
	
	@Override
	public Object next() {
		
		if(index < list.getSize()){
			Object object = list.get(index);
			index++;
			return object;
		}
		
		return null;
	}

	@Override
	public void first() {
		
		index=0;
	}

	@Override
	public void last() {
	
		index=list.getSize()-1;
	}

	@Override
	public boolean hasNext() {
		
		return index<list.getSize();
	}

}
