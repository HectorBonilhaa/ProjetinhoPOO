package contas;

public class ContaPoupanca extends Conta {

	private String TIPOU;
	private String TIPOC = "CONTA POUPANCA";

	

	public ContaPoupanca(String nome, String cpf, String senha, int numeroConta, Double saldo, int agencia) {
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
		return "ContaPoupanca [TIPOU=" + TIPOU + ", TIPOC=" + TIPOC + ", getNumeroConta()=" + getNumeroConta()
				+ ", getSaldo()=" + getSaldo() + ", getAgencia()=" + getAgencia() + ", getNome()=" + getNome()
				+ ", getCpf()=" + getCpf() + ", getSenha()=" + getSenha() + "]";
	}

}