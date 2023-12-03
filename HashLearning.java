import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class HashLearning extends DsaBaseClass {
  /**
   * *********************
   * Hashing is a black box
   * takes a key as input
   * hash value as output
   * key is called "Message"
   * hash value is called "Message digest"
   * one-way function
   * a good hashing function has minimalistic collision
   * Java has built in functions to implement hash functions
   * LinkedList can reduce collisions
   * HashMap = (Key, hashcode)
   * HashTable is similar to HasMap but HashTable is synchronized (thread-safe)
   * HashMap allows one null key while HashTable not
   * HashMap is generally preferred over HashTable (if thread synch is not needed)
   */

  @Override
  public void excercise() {
    HashMap<String, Integer> student = new HashMap<String, Integer>();
    student.put("Marta", 3);
    student.put("Lucia", 2);
    student.put("Alice", 7);
    Set<String> dataSet = student.keySet();
    for (String key : dataSet) {
      System.out.println(student.get(key));
      System.out.println("Hash: " + key.hashCode() % 10);
    }
    Set<Entry<String, Integer>> entrySet = student.entrySet();
    for (Entry<String, Integer> entry : entrySet) {
      System.out.println(entry);
    }
  }

}
