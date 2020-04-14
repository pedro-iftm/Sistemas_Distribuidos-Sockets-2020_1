import java.io.*;
import java.net.*;

public class Server2 {
	public static void main(String[] args) throws IOException {
		InetAddress endereco_remoto;
		int porta_remota;
		ServerSocket s = new ServerSocket(2000);
		System.out.println("Esperando conexao.......................");
		Socket conexao = s.accept();
		System.out.println("Conexao aceita, esperando envio de dados.");
		endereco_remoto = conexao.getInetAddress();
		porta_remota = conexao.getPort();
		System.out.println("Nome da maquina remota: " + endereco_remoto.getHostName());
		System.out.println("IP da maquina remota: " + endereco_remoto.getHostAddress());
		System.out.println("Porta maquina remota: " + porta_remota);

		DataInputStream entrada = new DataInputStream(conexao.getInputStream());
		DataOutputStream saida = new DataOutputStream(conexao.getOutputStream());

		for (int i = 0; i < 100000; i++) {
			int linha = entrada.readInt();
			System.out.println("entrei");
			saida.writeUTF("recebi seu dado: " + linha);
		}
	}
}
