package chatApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketChat {

	PrintWriter out;
	BufferedReader in;
	
	//Inicializar os in e out da mesma maneira das classes
	public SocketChat (Socket socket, String clientName) throws IOException {
		
		//O que vai sair para ser exibido no outro ponto
		out = new PrintWriter(socket.getOutputStream(), true);
		
		//Criar uma thread para a classe esperar por um "enter e exibir no outro ponto"
		new EscreverThread(out, socket, clientName).start();
		
		//O que esta chegando no socket para ser exibido
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		//Criar uma thread com o que estiver chegando no socket para ser exibido
		new ExibirThread(in).start();
	}
}

class ExibirThread extends Thread {
	BufferedReader in;
	
	public ExibirThread (BufferedReader in) {
		this.in = in;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				System.out.println(in.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}	
}

class EscreverThread extends Thread {
	
	PrintWriter out;
	Socket cliente;
	String nomeCliente;
	
	public EscreverThread(PrintWriter out, Socket cliente, String nomeCliente) {
		this.out = out;
		this.cliente = cliente;
		this.nomeCliente = nomeCliente;
	}
	
	@Override
	public void run() {
		String userInput;
		BufferedReader tecladoIn = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				if ((userInput = tecladoIn.readLine()) != null) {
					out.println(nomeCliente + ": " + userInput);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}