import java.io.*;
import java.net.*;

public class Client4 {
	public static void main(String[] args) throws IOException {
		Socket conexao = new Socket("127.0.0.1", 2001);
		DataInputStream entrada = new DataInputStream(conexao.getInputStream());
		DataOutputStream saida = new DataOutputStream(conexao.getOutputStream());

		String linha;
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.print("Digite a mensagem: ");
			linha = teclado.readLine();
			saida.writeUTF(linha);
			System.out.println("Mensagem enviada");
			System.out.println("Esperando resposta");
			linha = entrada.readUTF();
			System.out.println("Resposta recebida: " + linha);
			if (linha.trim().equals("SAIR")) {
				System.out.println("Desconectando");
				break;
			}
		}
	}
}
