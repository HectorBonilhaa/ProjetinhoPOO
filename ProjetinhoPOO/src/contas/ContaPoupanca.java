package contas;

public class ContaPoupanca extends Conta {

	// Variável //

	private double valorRendimento;

	// Construtores //

	public ContaPoupanca() {
		super();
	}

	public ContaPoupanca(String cpf, double saldo, int agencia, String tipoConta, int numContas) {
		super(cpf, saldo, agencia, tipoConta, numContas);

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

	// Operações Conta Poupanca! //

	@Override
	public String sacar(double valor) {
		double novoSaldo;
		if (this.getSaldo() > valor + saque) {
			novoSaldo = this.getSaldo() - valor - saque;
			this.setSaldo(novoSaldo);
			double total = getTotalTributos() + saque;
			setTotalTributos(total);
			return "Saque realizado com sucesso!";
		} else {
			return "Saldo insuficiente para saque.";
		}
	}

	@Override
	public String depositar(double valor) {
		if (valor > 0) {
			double novoSaldo = this.getSaldo() + valor - deposito;
			this.setSaldo(novoSaldo);
			double total = getTotalTributos() + deposito;
			setTotalTributos(total);
			return "Depósito realizado com sucesso!";
		} else {
			return "Depósito inválido!";
		}
	}

	public String transferir(double valor, Conta conta) {
		if (this.getSaldo() > valor + transferencia) {
			double novoSaldo = getSaldo() - valor - transferencia;
			this.setSaldo(novoSaldo);
			conta.setSaldo(conta.getSaldo() + valor);
			double total = getTotalTributos() + transferencia;
			setTotalTributos(total);
			return "Transferência realizada com sucesso!";
		} else {
			return "Saldo insuficiente para transferência.";
		}
	}
}