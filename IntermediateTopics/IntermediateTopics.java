package IntermediateTopics;

import java.io.IOException;
import java.io.*;

public class IntermediateTopics {
  public static void main(String[] args) throws IOException {
    BasicExcerices serialization = new SerializationLearning();
    // BasicExcerices socketLearning = new SocketLearning();
    BasicExcerices generics = new GenericsLearning();
    BasicExcerices streams = new StreamLearning();

    System.out.println("#### Serialization learning ####");
    serialization.exercise();
    // System.out.println("#### Socket learning ####");
    // socketLearning.exercise();
    System.out.println("#### Generics learning ####");
    generics.exercise();
    System.out.println("#### Stream learning ####");
    streams.exercise();
  }
}
