package Lev_31_lec_4_2;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SoftCache {
    private Map<Long, SoftReference<AnyObject>> cacheMap = new ConcurrentHashMap<>();

    public AnyObject get(Long key) {
        if (!cacheMap.containsKey(key)) {
            return null;
        } else {
            SoftReference<AnyObject> softReference = cacheMap.get(key);
            AnyObject a = softReference.get();
            softReference.clear();
            return a;
        }
    }

    public AnyObject put(Long key, AnyObject value) {
        if (!cacheMap.containsKey(key)) {
            return null;
        } else {
            SoftReference<AnyObject> softReference = cacheMap.put(key, new SoftReference<>(value));
            AnyObject a = softReference.get();
            softReference.clear();
            return a;
        }
        //напишите тут ваш код
    }

    public AnyObject remove(Long key) {
        if (!cacheMap.containsKey(key)) {
            return null;
        } else {
            SoftReference<AnyObject> softReference = cacheMap.remove(key);
            AnyObject a = softReference.get();
            softReference.clear();
            return a;
        }
    }
}
