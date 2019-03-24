package 设计模式.desgin_a_prototype_;
/*
 * 原型模式:通过复制现有的对象实例来创建新的对象实例
 * 	 优点：
        1，使用原型模型创建一个对象比直接new一个对象更有效率，因为它直接操作内存中的二进制流，特别是复制大对象时，性能的差别非常明显。
        2，隐藏了制造新实例的复杂性，使得创建对象就像我们在编辑文档时的复制粘贴一样简单。(不会调用构造器的方法)
 *  场景:	
 *   1，复制对象的结构和数据。
 *   2，希望对目标对象的修改不影响既有的原型对象。
 *   3，创建一个对象的成本比较大。
 * 
 * 
 */

public class Prototype implements Cloneable{
	
	private String name;
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	//浅拷贝
	public Object clone(){
		Prototype prototype = null;
		
		try {
			prototype = (Prototype) super.clone();
			return prototype;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
			
		}
	}

}
