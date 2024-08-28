package desafiosDeCodigo;

import java.util.Scanner;

public class QuedaConexao {

    public static String verificarQuedaConexao(String[] velocidades) {
      
        boolean quedaConexao = false;
      
        for (String elemento : velocidades) { 
            if (Integer.parseInt(elemento) == 0) {
              quedaConexao = true;
            }
        }
        
        String resultado = "";
        if (quedaConexao) {
          resultado = "Queda de Conexao";
        } else {
          resultado = "Sem Quedas";
        }
        
        return resultado;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitando ao usuário a lista de velocidades de conexão registradas a cada hora
        String input = scanner.nextLine();

        // Convertendo a entrada em uma lista de strings
        String[] velocidades = input.split(",");

        // Verificando se houve queda de conexão
        String resultado = verificarQuedaConexao(velocidades);

        // Exibindo o resultado da verificação
        System.out.println(resultado);

        scanner.close();
    }
}