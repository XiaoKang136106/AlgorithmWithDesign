package 设计模式.desgin_a_singleton_;
/*
 * 单例模式
 * 特点:	
 * 	    1、单例类只能有一个实例。
　*　		2、单例类必须自己自己创建自己的唯一实例。
　*　		3、单例类必须给所有其他对象提供这一实例
　*懒汉模式: 在单例类被加载时候，调用取得实例方法的时候才会实例化对象。
 */
public class Singleton2 {
	
	private static Singleton2 s = null; 
	
	
	private Singleton2(){};
	
	public static synchronized Singleton2 getIntance(){
		if(s ==null){
			s= new Singleton2();
		}
		
		return s;
	}
	
	
		
	
	
	

}
