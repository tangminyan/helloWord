package baobei.cute.spring.refertest;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tangminyan on 2020/3/25.
 */
public class ReferMain {

    static class HeapObject {
        byte[] bs = new byte[1024 * 1024];
    }

    public static void main(String[] args) {
        SoftReference<HeapObject> softReference = new SoftReference<>(new HeapObject());
        List<HeapObject> list = new ArrayList<>();
        int i = 0;
        while (true) {
            if (softReference.get() != null) {
                list.add(new HeapObject());
                System.out.println("list.add." + ++i);
            } else {
                System.out.println("---------软引用已被回收---------");
                break;
            }
            System.gc();
        }
    }
}

















