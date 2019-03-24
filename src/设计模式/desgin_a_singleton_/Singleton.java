package 设计模式.desgin_a_singleton_;
/*
 * 单例模式
 * 特点:	
 * 	    1、单例类只能有一个实例。
　*　		2、单例类必须自己自己创建自己的唯一实例。
　*　		3、单例类必须给所有其他对象提供这一实例
　*饿汉模式: 在单例类被加载时候，就实例化一个对象交给自己的引用
 */
public class Singleton {
	
	private static Singleton s = new Singleton(); 
	
	
	private Singleton(){};
	
	public static Singleton getIntance(){
		
		
		return s;
	}
	
	
		
	
	
	

}
