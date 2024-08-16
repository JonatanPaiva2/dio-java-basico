package desafioBanco;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		
		Banco banco = new Banco(new ArrayList<>());
		
		String acessoInicial = null;
		
		List<Conta> contas = new ArrayList<>();
		
		while (!"3".equals(acessoInicial)) {
			System.out.println("O que deseja fazer? 1 - Criar conta | 2 - Acessar conta | 3 - Encerrar acesso");
			acessoInicial = sc.nextLine();
			switch (acessoInicial) {
			case "1":
				System.out.println("Digite o seu nome");
				String nome = sc.nextLine();
				Cliente cliente = new Cliente(nome);
				System.out.println("Tipo de conta: 1 - Conta corrente | 2 - Conta Poupança");
				Conta conta = null;
				String tipoConta = sc.nextLine();
				if (tipoConta.equals("1")) {
					conta = new ContaCorrente(cliente);
				} else if (tipoConta.equals("2")) {
					conta = new ContaPoupanca(cliente);	
				}
				System.out.println("Conta de " + cliente + " criada com sucesso");
				banco.adicionarConta(conta);
				break;
				
				
			case "2":
				System.out.println("Digite seu nome:");
				String nomeCliente = sc.nextLine();
	            Conta contaCliente = banco.procurarContaPorNome(nomeCliente);
	            String operacao = null;
	            
	            while (!"4".equals(operacao)) {
					System.out.println("Qual operação deseja realizar?");
					System.out.println("1 - Saque | 2 - Depósito | 3 - Transferência | 4 - Menu inicial");
					operacao = sc.nextLine();
					
					if (operacao.equals("1")) {
						System.out.println("Seu saldo: " + contaCliente.getSaldo());
						System.out.println("Qual o valor do saque?");
						double valor = sc.nextDouble();
						sc.nextLine();
						
						if (contaCliente.getSaldo() < valor) {
							System.out.println("Você não possui saldo suficiente.");
						} else {
							contaCliente.sacar(valor);
							contaCliente.imprimirExtrato();
						}
					}
					
					else if (operacao.equals("2")) {
						System.out.println("Qual o valor do depósito?");
						double valor = sc.nextDouble();
						sc.nextLine();
						contaCliente.depositar(valor);	
						contaCliente.imprimirExtrato();
					}
					
					else if (operacao.equals("3")) {
						System.out.println("Para qual conta vai transferir?");
						String contaTransferencia = sc.nextLine();
						Conta contaDestino = banco.procurarContaPorNome(contaTransferencia);			
						if (contaDestino == null) {
		                    System.out.println("Conta de destino não encontrada.");
		                } else {
		                    System.out.println("Qual o valor da transferência?");
		                    double valorTransferencia = sc.nextDouble();
		                    sc.nextLine();
		                    if (contaCliente.getSaldo() < valorTransferencia) {
								System.out.println("Você não possui saldo suficiente.");
							} else {
			                    contaCliente.transferir(valorTransferencia, contaDestino);
			                    System.out.println("Transferência realizada com sucesso!");
			                    contaCliente.imprimirExtrato();
							}
		                }
						
					} else if (operacao.equals("4")) {
						
					} else {
						System.out.println("Operação inexistente");
					}
	            }
				break;
				
			case "3":
				System.out.println("Acesso Encerrado");
				break;
				
			default:
				System.out.println("Opção inexistente");
				break;
			}
			
		}
		
		sc.close();

	}
	

}
