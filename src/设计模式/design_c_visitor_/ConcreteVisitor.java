package 设计模式.design_c_visitor_;

import java.util.Collection;
import java.util.Iterator;

public class ConcreteVisitor implements Visitor {

	@Override
	public void visitString(StringElement stringE) {

		System.out.println(stringE.getValue());
		
	}

	@Override
	public void visitFloat(FloatElement floatE) {
		System.out.println(floatE.getValue());
	}

	@Override
	public void visitCollection(Collection collection) {

		Iterator iterator = collection.iterator();
		
		while(iterator.hasNext()){
			
			Object obj = iterator.next();
			if(obj instanceof Visitable){
					//判断自己是属于什么数据类型
					((Visitable) obj).accept(this);
			}
		}
		
	}

}
