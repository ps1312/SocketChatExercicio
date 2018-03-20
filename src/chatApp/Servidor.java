package chatApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor {
	
	public static void main(String[] args) throws IOException {
		
		List<Socket> clientes = new ArrayList<>();
		
		//Cliente
		Socket cliente = null;
		
		//Servidor
		ServerSocket server = null;
		
		//Objeto para enviar dados para o cliente
		PrintWriter out = null;
		
		//Objeto para ler dados vindos do servidor
		//BufferedReader in = null;
		
		//Fazer a conexao e iniciar os objetos de read e write para o servidor
		//Espera pela conexao do cliente
		server = new ServerSocket(9090);
		System.out.println("Aguardando nova conexao, servidor iniciado na porta 9090");
		
//		Cliente aceita conexao do servidor (serversocket.accept() return socket), accept espera ate que a conexao seja feita
//		cliente = server.accept();
//		System.out.println("Conexao com cliente iniciada");
		
		while (true) {
			cliente = server.accept();
			System.out.println("Conexao com cliente iniciada");
			out = new PrintWriter(cliente.getOutputStream(), true);
			out.println("Voce foi conectado com o servidor");
			clientes.add(cliente);
			
			//Cria as threads de ler e escrever, conexão ja foi iniciada
			new SocketChat(cliente, "Servidor: ");
		}
			
//			//Ler do cliente
//			in = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
//			
//			//Escrever no cliente
//			out = new PrintWriter(cliente.getOutputStream(), true);
//			
//			
//			out.println("Server side: Ola, voce se conectou ao servidor");
//			
//		} catch (UnknownHostException e) {
//			e.printStackTrace();
//			System.exit(1);
//		} catch (IOException e) {
//			e.printStackTrace();
//			System.exit(1);
//		}
//		
//		//Print "ola voce se conectou ao cliente"
//		System.out.println(in.readLine());
//		
//		new SocketChat(cliente);
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}