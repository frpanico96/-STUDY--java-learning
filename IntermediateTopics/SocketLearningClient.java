package IntermediateTopics;

import IntermediateTopics.SocketLearning.Client;

public class SocketLearningClient {
  public static void main(String[] args) {
    SocketLearning socketLearning = new SocketLearning();
    Client client = socketLearning.new Client("127.0.0.1", 5002);
  }
}
