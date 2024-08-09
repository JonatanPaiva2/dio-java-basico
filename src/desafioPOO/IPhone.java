package desafioPOO;

import java.util.Scanner;

public class IPhone {
	public static boolean tocando = false;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String x = null;
		while (!"4".equals(x)) {
			System.out.println("Escolha uma opção: ");
			System.out.println("1 - Reprodutor de música, 2 - Telefone, 3 - Navegador de Internet, 4 - Sair");
			x = sc.nextLine();
			switch (x) {
			case "1":
				System.out.println("Escolha uma opção do reprodutor de música: ");
				String m = sc.nextLine();
					switch (m) {
					case "1":
						ReprodutorMusical.tocar();
						break;
					case "2":
						if (tocando) {
							ReprodutorMusical.pausar();				
						}
						else {
							System.out.println("Não há nenhuma música tocando");
						}
						break;
					case "3":
						System.out.println("Escolha uma música: ");
						String tituloMusica = sc.nextLine();
						ReprodutorMusical.selecionarMusica(tituloMusica);
					   break;
					}
				break;
			case "2":
				System.out.println("Escolha uma opção do telefone: ");
				String l = sc.nextLine();
					switch (l) {
					case "1":
						System.out.println("Número para ligar: ");
						String numeroLigacao = sc.nextLine();
						AparelhoTelefonico.ligar(numeroLigacao);
						break;
					case "2":
						AparelhoTelefonico.atender();
						break;
					case "3":
						AparelhoTelefonico.iniciarCorreioVoz();
					   break;
					}
				break;
			case "3":
				System.out.println("Escolha uma opção do navegador de internet: ");
				String i = sc.nextLine();
					switch (i) {
					case "1":
						System.out.println("URL: ");
						String urlPagina = sc.nextLine();
						NavegadorInternet.exibirPagina(urlPagina);
						break;
					case "2":
						NavegadorInternet.adicionarNovaAba();
						break;
					case "3":
						NavegadorInternet.atualizarPagina();
					   break;
					}
				break;
			}
		}
		
		sc.close();
	}
	
}
