package contas;

public class ContaPoupanca extends Conta {

	private String TIPOU;
	private String TIPOP = "CONTA POUPANCA";

	public ContaPoupanca(String nome, String cpf, String senha, int numeroConta, Double saldo, int agencia) {

		super(nome, cpf, senha, numeroConta, saldo, agencia, tarifas);

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

	public String getTIPOP() {
		return TIPOP;
	}

}