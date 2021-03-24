package Lecture._20210303.Generic;

// Generic : <T> (T : type), 모든 것을 다 포용하겠다.
public class OrderedPair<K, V> {
	private K key;
	private V value;
	
	public OrderedPair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}
	
}
