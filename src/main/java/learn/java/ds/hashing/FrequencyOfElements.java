package learn.java.ds.hashing;

import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class FrequencyOfElements {
    public static void main(String[] args) throws InterruptedException {
        int[] arr = {0, 1, 1, 2, 3};
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int x : arr) {
            hashMap.put(x, hashMap.getOrDefault(x, 0) + 1);
        }
        System.out.println("hashMap = " + hashMap);
//        TimeUnit.SECONDS.wait(2000);
//        long convert = TimeUnit.SECONDS.convert(1000L, TimeUnit.MILLISECONDS);
//        System.out.println("convert = " + convert);
//        Executors.newFixedThreadPool(2);
    }
}