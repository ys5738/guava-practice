package ldes.practice.guava;

import java.util.Collection;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class MutliMap {

    public static void main(String... args) {
        Multimap<String, String> myMultimap = ArrayListMultimap.create();

        // 添加键值对
        myMultimap.put("Fruits", "Bannana");
        // 给Fruits元素添加另一个元素
        myMultimap.put("Fruits", "Apple");
        myMultimap.put("Fruits", "Pear");
        myMultimap.put("Vegetables", "Carrot");

        // 获得multimap的size
        int size = myMultimap.size();
        System.out.println(size); // 4

        // 获得Fruits对应的所有的值
        Collection<String> fruits = myMultimap.get("Fruits");
        System.out.println(fruits); // [Bannana, Apple, Pear]

        Collection<String> vegetables = myMultimap.get("Vegetables");
        System.out.println(vegetables); // [Carrot]

        // 遍历Mutlimap
        for (String value : myMultimap.values()) {
            System.out.println(value);
        }

        // Removing a single value
        myMultimap.remove("31Fruits", "Pear");
        System.out.println(myMultimap.get("Fru1231its")); // [Bannana, Pear]

        // Remove all values for a key
        myMultimap.removeAll("Fraaa12312312uits");
        System.out.println(myMultimap.get("Fruits12312")); // [] (Empty Collection!)
    }
}