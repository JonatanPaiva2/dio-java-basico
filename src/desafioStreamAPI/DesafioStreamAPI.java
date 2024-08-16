package desafioStreamAPI;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DesafioStreamAPI {

	public static void main(String[] args) {
		
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
		
		//DESAFIO 1 - Mostre a lista na ordem numérica:
		List<Integer> listaOrdemCrescente = numeros.stream()
				.sorted(Comparator.naturalOrder())
				.toList();
		
		System.out.println(listaOrdemCrescente);

		//DESAFIO 2 - Imprima a soma dos números pares da lista:
		int somaNumerosPares = numeros.stream()
				.filter(n -> n % 2 == 0)
				.mapToInt(Integer::intValue)
				.sum();
		
		System.out.println(somaNumerosPares);
		
		//DESAFIO 3 - Verifique se todos os números da lista são positivos:
		boolean numerosSaoPostivos = numeros.stream()
				.allMatch(n -> n >= 0);
		
		System.out.println(numerosSaoPostivos);
		
		//DESAFIO 4 - Remova todos os valores ímpares:
		List<Integer> listaPares = numeros.stream()
				.filter(n -> n % 2 != 0)
				.toList();
		
		System.out.println(listaPares);
		
		//DESAFIO 5 - Calcule a média dos números maiores que 5:
		OptionalDouble mediaMaioresQue5 = numeros.stream()
				.filter(n -> n > 5)
				.mapToInt(Integer::intValue)
				.average();
		
		System.out.println(mediaMaioresQue5);
		
		//DESAFIO 6 - Verificar se a lista contém algum número maior que 10
		boolean numeroMaiorQue10 = numeros.stream()
				.anyMatch(n -> n > 10);
		
		System.out.println(numeroMaiorQue10);
		
		//DESAFIO 7 - Encontrar o segundo número maior da lista:
		numeros.stream()
				.distinct()
				.sorted((a, b) -> b - a)
				.skip(1)
				.findFirst()
				.ifPresent(System.out::println);
		
		//DESAFIO 8 - Somar os dígitos de todos os números da lista:
		int somaDosDigitos = numeros.stream()
                .map(String::valueOf)  // Converte cada número para String
                .flatMapToInt(s -> s.chars())  // Converte cada caractere para seu valor numérico
                .map(Character::getNumericValue)  // Converte em número
                .sum();
		
		System.out.println(somaDosDigitos);

		//DESAFIO 9 - Verificar se todos os números da lista são distintos:
		boolean numerosSaoDistintos = numeros.stream()
				.distinct()
				.count() == numeros.size();
		
		System.out.println(numerosSaoDistintos);

		//DESAFIO 10 - Agrupe os valores ímpares múltiplos de 3 ou de 5:
		List<Integer> imparesMultiplos5E3 = numeros.stream()
				.filter(n -> n % 2 != 0)
				.filter(n -> n % 3 == 0 || n % 5 == 0)
				.toList();
		
		System.out.println(imparesMultiplos5E3);
		
		//DESAFIO 11 - Encontre a soma dos quadrados de todos os números da lista:
		int somaDosQuadrados = numeros.stream()
				.map(n -> n * n)
				.mapToInt(Integer::intValue)
				.sum();
		
		System.out.println(somaDosQuadrados);
		
		//DESAFIO 12 - Encontre o produto de todos os números da lista:
		int produtoDosNumeros = numeros.stream()
				.reduce(1, (a, b) -> a * b);
		
		System.out.println(produtoDosNumeros);
		
		//DESAFIO 13 - Filtrar os números que estão dentro de um intervalo:
		List<Integer> listaIntervalo = numeros.stream()
				.filter(n -> n > 5 && n < 10)
				.toList();
		
		System.out.println(listaIntervalo);

		//DESAFIO 14 - Encontre o maior número primo da lista:
		OptionalInt maiorPrimo = numeros.stream()
				.filter(n -> n > 1 && 
                        IntStream.rangeClosed(2, (int) Math.sqrt(n))
                        .allMatch(divisor -> n % divisor != 0))
                .mapToInt(Integer::intValue)
                .max(); 
		
		System.out.println(maiorPrimo);
		
		//DESAFIO 15 - Verifique se a lista contém pelo menos um número negativo:
		boolean algumNegativo = numeros.stream()
				.anyMatch(n -> n < 0);
		
		System.out.println(algumNegativo);
		
		//DESAFIO 16 - Agrupe os números em pares e ímpares:
		Map<String, List<Integer>> agrupados = numeros.stream()
                .collect(Collectors.groupingBy(n -> n % 2 == 0 ? "pares" : "impares"));

		List<Integer> pares = agrupados.get("pares");
		List<Integer> impares = agrupados.get("impares");

		System.out.println("Números pares: " + pares);
		System.out.println("Números ímpares: " + impares);
		


		//DESAFIO 17 - Filtrar os números primos da lista:
		List<Integer> listaPrimos = numeros.stream()
				.filter(n -> n > 1 && 
                        IntStream.rangeClosed(2, (int) Math.sqrt(n))
                        .allMatch(divisor -> n % divisor != 0))
                .toList();
		
		//DESAFIO 18 - Verifique se todos os números da lista são iguais:
		boolean todosIguais = numeros.stream()
                .allMatch(n -> n.equals(numeros.get(0)));
		
		System.out.println(todosIguais);
		
		//DESAFIO 19 - Encontre a soma dos números divisíveis por 3 e 5:
		int somaDivisiveisPor3E5 = numeros.stream()
				.filter(n -> n % 3 == 0 || n % 5 == 0)
				.mapToInt(Integer::intValue)
				.sum();
		
		System.out.println(somaDivisiveisPor3E5);
	}	

}
