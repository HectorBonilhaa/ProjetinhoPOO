package contas;

public class ContaCorrente extends Conta {

	private String TIPOU;
	private String TIPOC = "CONTA CORRENTE";

	public ContaCorrente(String nome, String cpf, String senha, int numeroConta, Double saldo, int agencia,
			Double tarifas) {

		super(nome, cpf, senha, numeroConta, saldo, agencia, tarifas, TIPOU);

	}

	@Override
	public String toString() {
		return "ContaCorrente [getNumeroConta()=" + getNumeroConta() + ", \ngetSaldo()=" + getSaldo()
				+ ", \ngetAgencia()=" + getAgencia() + ", \ngetTarifas()=" + getTarifas() + ", \ntoString()="
				+ super.toString() + ", \ngetNome()=" + getNome() + ", \ngetCpf()=" + getCpf() + ", \ngetSenha()="
				+ getSenha() + "]";
	}

	public String getTIPOU() {
		return TIPOU;
	}

	public String getTIPOC() {
		return TIPOC;
	}

}
