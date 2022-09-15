package contas;

public class ContaCorrente extends Conta {

	// Construtores //

	public ContaCorrente() {
		super();

	}

	public ContaCorrente(String cpf, double saldo, int agencia, String tipoConta, int numContas) {
		super(cpf, saldo, agencia, tipoConta, numContas);

	}

	// ToString //

	@Override
	public String toString() {
		return "ContaCorrente [getCpf()=" + getCpf() + ", getSaldo()=" + getSaldo() + ", getAgencia()=" + getAgencia()
				+ ", getTipo()=" + getTipo() + ", getNumContas()=" + getNumContas() + ", getTotalTributos()="
				+ getTotalTributos() + "]";
	}
	// Operações Conta Corrente! //

	
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
