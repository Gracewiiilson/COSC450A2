/*
import java.net.Socket;

import java.io.*;




public class Client {

    private static DataInputStream input;
    private static DataOutputStream output;

    private static FileInputStream fileInput;
    private static FileOutputStream fileOutput;

    private final static int PORT = 12123;

    //probably need to change both these
        private final static String public_key_directive = ".\\client_public_key.asc";

        private final static String message_directive = ".\\message.txt";

        public static void main(String[] args){
            try (Socket socket = new Socket("localhost", PORT)){
                output = new DataOutputStream(socket.getOutputStream());
                input = new DataInputStream(socket.getInputStream());

                System.out.println("Sending pub key");

                sendFile(public_key_directive);
            }
            catch (Exception e){
                    e.printStackTrace();
            }
        }

        private static void sendFile(String filepath) throws Exception{
            int bytes = 0;

            try{
                    File file = new File(filepath);
                    fileInput = new FileInputStream(filepath);

                    output.writeLong(file.length());

                    byte[] buffer = new byte[4 * 1024];

                    while((bytes = fileInput.read(buffer)) != -1){
                            output.write(buffer, 0, bytes);
                            output.flush();
                    }

                    fileInput.close();
            }

            catch (Exception e){
                    e.printStackTrace();
            }
        }

        private static void receivedFile(String filepath) throws Exception{

        }

}

*/
