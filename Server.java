import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import java.lang.Math;

public class Server {

    private static DataInputStream input;
    private static DataOutputStream output;

    private static FileInputStream fileInput;

    private static FileOutputStream fileOutput;

    private final static int PORT = 12123;


    private final static String public_key_directive = ".\\server_public_key.asc"; //not sure about these
    private final static String client_public_key_directive = ".\\keys\\key_from_client.txt";

    public static void main(String[] args){
        try(ServerSocket serverSocket = new ServerSocket(PORT)){
            System.out.println("Waiting for the client ...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Connected");

            input = new DataInputStream(clientSocket.getInputStream());
            output = new DataOutputStream(clientSocket.getOutputStream());

            receiveFile(client_public_key_directive);

            clientSocket.close();
            input.close();
            output.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    private static void receiveFile(String filename) throws Exception {
        int bytes = 0;
        FileOutputStream fileOutput = new FileOutputStream(filename);

        long size = input.readLong();

        byte[] buffer = new byte[4 * 1024];

        while((size > 0) && (bytes = input.read(buffer,0, (int)Math.min(buffer.length, size))) != -1){
            fileOutput.write(buffer, 0, bytes);
            size -= bytes;
        }

        System.out.println("Client public key received.");
    }
}
