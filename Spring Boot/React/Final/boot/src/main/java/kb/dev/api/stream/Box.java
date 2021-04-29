package kb.dev.api.stream;

import java.util.HashMap;

public class Box<T> {
    private HashMap<String, T> map;

    // 생성자 : 인스턴스 변수 초기화
    public Box() { // default method(기본 생성자) 아님
        map = new HashMap<String, T>();
    }

    public void clear() {
        map.clear();
    }

    public boolean containsKey(String key) {
        return map.containsKey(key);
    }

    public T get(String key) {
        return map.get(key);
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public T put(String key, T value) {
        return map.put(key, value);
    }

    public T remove(String key) {
        return map.remove(key);
    }

    public T replace(String key, T value) {
        return map.replace(key, value);
    }
}
