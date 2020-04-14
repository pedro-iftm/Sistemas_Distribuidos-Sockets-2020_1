import java.io.*;
import java.net.*;

public class Server4 {
	public static void main(String[] args) throws IOException {
		ServerSocket s = new ServerSocket(2001);
		while (true) {
			System.out.println("Esperando conexão...");
			Socket conexao = s.accept();
			System.out.println("Esperando mensagem");
			DataInputStream entrada = new DataInputStream(conexao.getInputStream());
			DataOutputStream saida = new DataOutputStream(conexao.getOutputStream());
			String linha = entrada.readUTF();
			BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
			while (linha != null && !(linha.trim().equals("SAIR"))) {
				System.out.println("Mensagem recebida: " + linha);
				System.out.print("Digite a resposta: ");
				linha = teclado.readLine();
				saida.writeUTF(linha);
				System.out.println("Resposta enviada");
				linha = entrada.readUTF();
			}
			saida.writeUTF(linha);
			conexao.close();

		}
	}
}
