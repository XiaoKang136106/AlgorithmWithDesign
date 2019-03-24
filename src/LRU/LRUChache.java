package LRU;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;


public class LRUChache<K,V> extends LinkedHashMap<K, V> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private final int CHACHE_SIZE;
	
	public LRUChache(int chacheSize) {
		 // true 表示让 linkedHashMap按照访问顺序来进行排序，最近访问的放在头部，最老访问的放在尾部。
		super((int) Math.ceil(chacheSize/0.75)+1, 0.75f, true);
		CHACHE_SIZE=chacheSize;
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		// 当map中的数据量大于指定的缓存个数的时候，就自动删除最老的数据。进行重写
		return size()>CHACHE_SIZE;
	}
	
	
	
	

}
