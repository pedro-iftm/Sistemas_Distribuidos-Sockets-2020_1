import java.io.*;
import java.net.*;

public class Server3 {
	public static void main(String[] args) throws IOException {
		ServerSocket s = new ServerSocket(2001);
		while (true) {
			System.out.print("Esperando conectar...");
			Socket conexao = s.accept();
			System.out.println(" Conectou!");
			DataInputStream entrada = new DataInputStream(conexao.getInputStream());
			DataOutputStream saida = new DataOutputStream(conexao.getOutputStream());

			String linha = entrada.readUTF();
			while (linha != null && !(linha.trim().equals(""))) {
				saida.writeUTF("Resposta do servidor: " + linha);
				linha = entrada.readUTF();
			}
			saida.writeUTF(linha);
			conexao.close();

		}
	}
}
