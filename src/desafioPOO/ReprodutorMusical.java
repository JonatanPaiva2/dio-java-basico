package desafioPOO;

public class ReprodutorMusical {

	public static void tocar() {
		IPhone.tocando = true;
		System.out.println("Tocando música");
	}
	
	public static void pausar() {
		IPhone.tocando = false;
		System.out.println("Pausando música");
	}
	
	public static void selecionarMusica(String musica) {
		System.out.println("Selecionando música " + musica);
	}
}
