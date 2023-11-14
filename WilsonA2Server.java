import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        final int portNumber = 12123;

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            System.out.println("Server is listening on port " + portNumber);

            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    System.out.println("Client connected: " + socket.getInetAddress());

                    // Read data from the client
                    InputStream input = socket.getInputStream();
                    byte[] buffer = new byte[1024];
                    int bytesRead = input.read(buffer);

                    if (bytesRead > 0) {
                        String receivedData = new String(buffer, 0, bytesRead);
                        System.out.println("Received from client: " + receivedData);

                        // Process the received data or perform other actions 
                    }

                    // Send a response back to the client
                    String response = "Hello from the server!";
                    OutputStream output = socket.getOutputStream();
                    output.write(response.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
