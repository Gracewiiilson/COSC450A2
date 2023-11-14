import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        final String serverAddress = "localhost";
        final int portNumber = 12123;

        try (Socket socket = new Socket(serverAddress, portNumber)) {
            System.out.println("Connected to server: " + socket.getInetAddress());

            // Send data to the server
            String message = "Hello from the client!";
            OutputStream output = socket.getOutputStream();
            output.write(message.getBytes());

            // Receive a response from the server
            InputStream input = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int bytesRead = input.read(buffer);

            if (bytesRead > 0) {
                String serverResponse = new String(buffer, 0, bytesRead);
                System.out.println("Server response: " + serverResponse);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
