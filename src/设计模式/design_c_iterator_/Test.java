package 设计模式.design_c_iterator_;

public class Test {
	
	
	public static void main(String[] args) {
		
		List list =new ListImpl();
		
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		Iterator iterator = list.iterator();
		System.out.println(list.getSize());
		Object next = iterator.next();
		System.out.println(next);
		
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
	}

}
