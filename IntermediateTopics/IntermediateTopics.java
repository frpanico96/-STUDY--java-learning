package IntermediateTopics;

import java.io.IOException;
import java.io.*;

public class IntermediateTopics {
  public static void main(String[] args) throws IOException {
    BasicExcerices serialization = new SerializationLearning();
    BasicExcerices socketLearning = new SocketLearning();

    System.out.println("#### Serialization learning ####");
    serialization.exercise();
    System.out.println("#### Socket learning ####");
    socketLearning.exercise();
  }
}
