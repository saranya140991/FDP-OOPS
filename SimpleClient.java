package saranya;

import java.io.*;
import java.net.*;

public class SimpleClient {
    public static void main(String[] args) {
        try {
            // Step 1: Connect to server on localhost at port 5000
            Socket socket = new Socket("localhost", 5000);
            System.out.println("✅ Connected to server!");

            // Step 2: Set up input and output streams
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            // Step 3: Send a message to the server
            output.println("Hello from client!");

            // Step 4: Receive response from server
            String serverResponse = input.readLine();
            System.out.println("📩 Received from server: " + serverResponse);

            // Step 5: Close connection
            socket.close();
            System.out.println("✅ Client closed.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
