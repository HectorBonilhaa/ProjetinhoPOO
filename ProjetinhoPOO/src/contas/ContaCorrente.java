package contas;

public class ContaCorrente extends Conta {

	private String TIPOU;
	private String TIPOC = "CONTA CORRENTE";

	

	public ContaCorrente(String nome, String cpf, String senha, int numeroConta, Double saldo, int agencia) {
		super(nome, cpf, senha, numeroConta, saldo, agencia);
	}

	

	public String getTIPOU() {
		return TIPOU;
	}

	public String getTIPOC() {
		return TIPOC;
	}



	@Override
	public String toString() {
		return "ContaCorrente [getNumeroConta()=" + getNumeroConta() + ", getSaldo()=" + getSaldo() + ", getAgencia()="
				+ getAgencia() + ", getNome()=" + getNome() + ", getCpf()=" + getCpf() + ", getSenha()=" + getSenha()
				+ "]";
	}

}
