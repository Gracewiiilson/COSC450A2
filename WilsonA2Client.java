import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        final String serverAddress = "localhost";
        final int portNumber = 12123;

        try (Socket socket = new Socket(serverAddress, portNumber)) {
            System.out.println("Connected to server: " + socket.getInetAddress());

            // Print "Sending public key"
            System.out.println("Sending public key");

            // Read the content of the .asc public key file
            String publicKeyFilePath = "C:\Users\gmw10\Desktop\my_public_key.asc";
            String publicKeyContent = readPublicKey(publicKeyFilePath);

            // Send the public key content to the server
            OutputStream output = socket.getOutputStream();
            output.write(publicKeyContent.getBytes());

            // Receive a response from the server (if any)
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

    // Helper method to read the content of the .asc public key file
    private static String readPublicKey(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }
}
