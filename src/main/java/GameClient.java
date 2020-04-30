
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static java.lang.System.in;
import static java.lang.System.out;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author adria
 */
public class GameClient {
    public static void main (String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String serverAddress = "127.0.0.1"; // The server's IP address
        int PORT = 8100; // The server's port
        try (
                Socket socket = new Socket(serverAddress, PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
            )
        {
            while(true){


                System.out.println("Enter request: ");
                String request = sc.nextLine();
                out.println(request);
                
                // Wait the response from the server ("Hello World!")
                String response = in.readLine ();
                System.out.println(response);
                if(response.equals("Server stopped"))
                    break;
            }

        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }

}
