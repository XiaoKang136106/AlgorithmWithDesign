package 设计模式.desgin_b_flyweight_;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
	
	
	public static Map<String,Flyweight> flyweights = new HashMap();
	
	
	public FlyweightFactory(String key){
		flyweights.put(key, new FlyweightImpl());
		
	}
	public static Flyweight getFlyweight(String key){
		if(flyweights.get(key)==null){
			flyweights.put(key, new FlyweightImpl());
		}
		return flyweights.get(key);
	}
	public static int getSize(){
		
		return flyweights.size();
	}
}
