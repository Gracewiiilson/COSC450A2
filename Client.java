import java.net.Socket;
import java.io.*;

public class Client {
    private final static int port = 12123;
    private static FileInputStream fileIn;
    private static FileOutputStream fileOut;
    private static DataInputStream in;
    private static DataOutputStream out;

    //probably need to change both these
        private final static String pubKey = ".\\client_public_key.asc";
        private final static String msg= ".\\message.txt";

    private static void sendFile(String fPath) throws Exception{
        int bytes = 0;

        try{
            File file = new File(fPath);
            fileIn = new FileInputStream(fPath);
            out.writeLong(file.length());

            byte[] buff = new byte[4 * 1024];
            while((bytes = fileIn.read(buff)) != -1){
                out.write(buff, 0, bytes);
                out.flush();
            }
            fileIn.close();
        }
        catch (Exception e) { e.printStackTrace(); }
    }
        public static void main(String[] args){
            try (Socket socket = new Socket("localhost", port)){
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
                System.out.println("Sending pub key to client");
                sendFile(pubKey);
            }
            catch (Exception e){e.printStackTrace();}
        }

}


