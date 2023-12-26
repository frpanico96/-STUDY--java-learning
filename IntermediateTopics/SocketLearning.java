package IntermediateTopics;

import java.net.*;
import java.io.*;

/**
 * Socket Programmin methods
 * public InputStream getInputStream() --> returns the InputStream attached with
 * this socket
 * 
 * public OutputStream getOutputStream() --> returns the OutputStream attached
 * with this socket
 * 
 * public synchornized void close() --> closes this socket
 * 
 * public Socket accept() --> Returns the socket and establis a connection
 * between client and server
 * 
 */

public class SocketLearning extends BasicExcerices {
  @Override
  public void exercise() throws IOException {
    Server server = new Server(5000);

    Client client = new Client("127.0.0.1", 5000);
  }

  public class Server {
    private Socket socket = null;
    private ServerSocket serverSocket = null;
    private DataInputStream input = null;

    public Server(int port) {
      try {
        serverSocket = new ServerSocket(port);

        System.out.println("Server Started");

        System.out.println("Waiting for client");

        socket = serverSocket.accept();
        System.out.println("Client accepted");

        input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

        String line = "";

        while (!line.equals("Over")) {
          try {
            line = input.readUTF();
            System.out.println(line);
          } catch (Exception e) {
            System.out.println(e);
          }
        }

        System.out.println("Closing connection");

        socket.close();
        input.close();

      } catch (IOException e) {
        System.out.println(e);
      }

    }
  }

  public class Client {
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream output = null;

    public Client(String address, int port) {
      try {
        socket = new Socket(address, port);
        System.out.println("Connected");

        input = new DataInputStream(System.in);

        output = new DataOutputStream(socket.getOutputStream());
      } catch (UnknownHostException e) {
        System.out.println(e);
      } catch (IOException e) {
        System.out.println(e);
      }

      String line = "";
      while (!line.equals("Over")) {
        try {
          line = input.readLine();
          output.writeUTF(line);
        } catch (IOException e) {
          System.out.println(e);
        }
      }

      try {
        input.close();
        output.close();
        socket.close();
      } catch (IOException e) {
        System.out.println(e);
      }
    }

  }
}
