package contas;

public class ContaPoupanca extends Conta {

	// Variável //

	private double valorRendimento;

	// Construtores //

	public ContaPoupanca() {
		super();
	}

	public ContaPoupanca(String cpf, double saldo, int agencia, String tipoConta) {
		super(cpf, saldo, agencia, tipoConta);

	}

	// Getters and Setters //
	public double getValorRendimento() {
		return valorRendimento;
	}

	public void setValorRendimento(double valorRendimento) {
		this.valorRendimento = valorRendimento;
	}

	// ToString //

	@Override
	public String toString() {
		return ", Cpf titular()=" + getCpf() + ", getSaldo()=" + getSaldo() + ", getAgencia()=" + getAgencia()
				+ ", getTipo()=" + getTipo() + ", getNumContas()=" + getNumContas() + "]";
	}

	// Método rendimento Conta Poupança! //

	public double calcularRendimentoPoupanca(double valor, int dias) {
		double valorFinal = valor * rendimentoPoupancaDia * dias;
		this.valorRendimento = valorFinal;
		return valorFinal;
		
	}
}