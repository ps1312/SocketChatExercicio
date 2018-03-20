package chatApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
	
	public static void main(String[] args) throws IOException {
		String clientUsername;
		System.out.println("Digite seu nome para o chat: ");
		Scanner usernameInput = new Scanner(System.in);
		clientUsername = usernameInput.nextLine();
		
		Socket echoSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		int port = 9090;
		
		try {
			echoSocket = new Socket("localhost", port);
			out = new PrintWriter(echoSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
			
			out.println("Usuario conectado");

		} catch (UnknownHostException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		//Print "ola voce se conectou ao servidor"
		System.out.println(in.readLine());
		
		new SocketChat(echoSocket, clientUsername);
		
	}
}