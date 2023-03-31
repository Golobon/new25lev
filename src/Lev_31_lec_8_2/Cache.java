package Lev_31_lec_8_2;

import java.lang.reflect.*;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();
    //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        //TODO add your code here
        if (cache.get(key) == null) {
            Constructor<V> constructor = clazz.getDeclaredConstructor(key.getClass());
            V object = constructor.newInstance(key);
            put(object);
        }
        return cache.get(key);
    }

    public boolean put(V obj) throws Exception {
        //TODO add your code here
        try {
            Method getKey = obj.getClass().getDeclaredMethod("getKey");
            getKey.setAccessible(true);
            cache.put((K) getKey.invoke(obj), obj);
        } catch (Exception e) { return false; }
        return true;
    }

    public int size() {
        return cache.size();
    }
}
