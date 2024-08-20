package desafioAbstraindoBootcamp;

import java.time.LocalDate;

import desafioAbstraindoBootcamp.dominio.Bootcamp;
import desafioAbstraindoBootcamp.dominio.Curso;
import desafioAbstraindoBootcamp.dominio.Dev;
import desafioAbstraindoBootcamp.dominio.Mentoria;

public class Main {

	public static void main(String[] args) {
		
		Curso curso1 = new Curso("Curso js", "Descrição curso js", 4);
		
		Mentoria mentoria1 = new Mentoria("Mentoria de java", "Descrição mentoria de java", LocalDate.now());

		
		Bootcamp bootcamp = new Bootcamp("Bootcamp Java Developer", "Descrição Bootcamp Java Developer");
		bootcamp.getConteudos().add(curso1);
		bootcamp.getConteudos().add(mentoria1);
		
		Dev devCamila = new Dev("devCamila", "camila@gmail.com");
		devCamila.inscreverBootcamp(bootcamp);
		System.out.println("Conteúdos inscritos: " + devCamila.getConteudosInscritos());
		devCamila.progredir();
		System.out.println("Conteúdos inscritos: " + devCamila.getConteudosInscritos());
		System.out.println("Conteúdos concluídos: " + devCamila.getConteudosConcluidos());
		System.out.println("XP: " + devCamila.calcularTotalXp());
		
		Dev devJoao = new Dev("João", "joao@gmail.com");
		devJoao.inscreverBootcamp(bootcamp);
		


	}

}
