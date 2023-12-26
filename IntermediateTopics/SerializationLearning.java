package IntermediateTopics;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationLearning extends BasicExcerices implements java.io.Serializable {

  @Override
  public void exercise() throws IOException {

    String fileName = "file.ser";
    Demo object = new Demo(1, "geeksforgeeks");
    try {
      FileOutputStream file = new FileOutputStream(fileName);
      ObjectOutputStream out = new ObjectOutputStream(file);

      out.writeObject(object);
      out.close();
      file.close();

      System.out.println("Object has been serialized");

    } catch (IOException e) {
      System.out.println("IOException is caught " + e);
    }

    Demo object1 = null;
    try {
      FileInputStream file = new FileInputStream(fileName);
      ObjectInputStream in = new ObjectInputStream(file);

      object1 = (Demo) in.readObject();
      in.close();

      file.close();

      System.out.println("Object has been deserialized ");
      System.out.println("a = " + object1.a);
      System.out.println("b = " + object1.b);

    } catch (Exception e) {
      System.out.println("IOException is caught" + e.getMessage());
    }

  }

  class Demo implements java.io.Serializable {
    int a;
    String b;

    Demo(int a, String b) {
      this.a = a;
      this.b = b;
    }
  }
}
