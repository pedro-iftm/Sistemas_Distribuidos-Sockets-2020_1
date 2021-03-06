import java.io.*;
import java.net.*;

public class Client3 {
	public static void main(String[] args) throws IOException {
		Socket conexao = new Socket("127.0.0.1", 2001);
		DataInputStream entrada = new DataInputStream(conexao.getInputStream());
		DataOutputStream saida = new DataOutputStream(conexao.getOutputStream());

		String linha;
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		while (true) {

			System.out.print("> ");
			linha = teclado.readLine();
			System.out.println(linha);
			saida.writeUTF(linha);
			linha = entrada.readUTF();
			if (linha.equalsIgnoreCase("")) {
				System.out.println("Conexao encerrada!");
				break;
			}
			System.out.println(linha);

		}
	}
}
