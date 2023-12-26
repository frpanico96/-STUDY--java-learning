package IntermediateTopics;

import IntermediateTopics.SocketLearning.Server;

public class SocketLearningServer {
  public static void main(String[] args) {
    SocketLearning socketLearning = new SocketLearning();
    Server server = socketLearning.new Server(5002);
  }
}
