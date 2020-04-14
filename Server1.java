import java.io.*;
import java.net.*;

public class Server1 {
	public static void main(String[] args) throws IOException {
		ServerSocket s = new ServerSocket(2000);
		System.out.println("Esperando conexao...............");

		Socket conexao = s.accept();
		System.out.println("Conexao aceita, esperando dados...");

		DataInputStream entrada = new DataInputStream(conexao.getInputStream());
		DataOutputStream saida = new DataOutputStream(conexao.getOutputStream());

		for (int i = 0; i < 100000; i++) {
			int linha = entrada.readInt();
			System.out.println("entrei");
			saida.writeUTF("recebi seu dado: " + linha);
		}
	}
}
