package desafioBanco;

import java.util.List;

public class Banco {

	private List<Conta> contas;
	
	public Banco(List<Conta> contas) {
        this.contas = contas;
    }
	
	// GET E SET
	public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }
    
    // FUNÇÕES
	public void adicionarConta(Conta conta) {
        contas.add(conta);
    }
	
	public Conta procurarContaPorNome(String nomeCliente) {
        for (Conta conta : contas) {
            if (conta.getCliente().getNome().equalsIgnoreCase(nomeCliente)) {
                return conta;
            }
        }
        return null; // Retorna null se não encontrar a conta
    }
	
}
