import java.io.*;
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

                    // Read data from the client (assuming it's the public key)
                    InputStream input = socket.getInputStream();
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] buffer = new byte[1024];
                    int bytesRead;

                    while ((bytesRead = input.read(buffer)) != -1) {
                        byteArrayOutputStream.write(buffer, 0, bytesRead);
                    }

                    String publicKey = byteArrayOutputStream.toString("UTF-8");

                    // Print the received public key
                    System.out.println("Received public key:\n" + publicKey);

                    // Save the public key to a file
                    String publicKeyFilePath = "C:\\Users\\gmw10\\Desktop\\received_public_key.asc";
                    try (Writer writer = new BufferedWriter(new FileWriter(publicKeyFilePath))) {
                        writer.write(publicKey);
                    }

                    // Send a response back to the client (optional)
                    String response = "Public key received successfully!";
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
