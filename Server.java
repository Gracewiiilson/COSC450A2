import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.lang.Math;

public class Server {

    private final static int portNum = 12123;
    private final static String server_pubKey = ".\\server_public_key.asc"; //not sure about these
    private final static String client_pubKey = ".\\keys\\key_from_client.txt";

    private static DataInputStream in;
    private static DataOutputStream out;

    private static void receiveFile(String fileName) throws Exception {
        int numBytes = 0;
        byte[] buffer = new byte[4 * 1024];
        long size = in.readLong();
        FileOutputStream fileOutput = new FileOutputStream(fileName);

        while((size > 0) && (numBytes = in.read(buffer,0, (int)Math.min(buffer.length, size))) != -1){
            fileOutput.write(buffer, 0, numBytes);
            size = (size - numBytes);
        }
        System.out.println("Public key has been received from client.");
    }

    public static void main(String[] args){
        try(ServerSocket serverSocket = new ServerSocket(portNum)){
            System.out.println("Waiting for the client ...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Connected");

            in = new DataInputStream(clientSocket.getInputStream());

            out = new DataOutputStream(clientSocket.getOutputStream());

            receiveFile(client_pubKey);

            clientSocket.close();
            in.close();
            out.close();
        }
        catch(Exception e) { e.printStackTrace(); }

    }

}
