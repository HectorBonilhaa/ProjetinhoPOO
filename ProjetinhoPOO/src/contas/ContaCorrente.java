package contas;

import exceptions.DepositoException;

public class ContaCorrente extends Conta {
	
	private int numContas;

	// Construtores //

	public ContaCorrente() {
		super();

	}

	public ContaCorrente(String cpf, double saldo, int agencia, String tipoConta) {
		super(cpf, saldo, agencia, tipoConta);
		numContas = getContadorContas();

	}
	public int getNumContas() {
		return this.numContas;
		
		
	}
	// ToString //

	@Override
	public String toString() {
		return "ContaCorrente [getCpf()=" + getCpf() + ", getSaldo()=" + getSaldo() + ", getAgencia()=" + getAgencia()
				+ ", getTipo()=" + getTipo() + ", getNumContas()=" + getNumContas() + ", getTotalTributos()="
				+ getTotalTributos() + "]";
	}
	// Operações Conta Corrente! //

	
	public void sacar(double valor) {
		double novoSaldo;
		if (this.getSaldo() > valor + saque) {
			novoSaldo = this.getSaldo() - valor - saque;
			this.setSaldo(novoSaldo);
			double total = getTotalTributos() + saque;
			setTotalTributos(total);
			System.out.println("Saque realizado com sucesso!");
			
		} else {
			System.out.println("Saldo insuficiente para saque.");
		}
	}

	
	public void depositar(double valor) {
		if (valor > 0) {
			double novoSaldo = this.getSaldo() + valor - deposito;
			this.setSaldo(novoSaldo);
			double total = getTotalTributos() + deposito;
			setTotalTributos(total);
			System.out.println("Depósito realizado com sucesso!");
		} else {
			System.out.println("Depósito inválido!");
			throw new DepositoException("Impossível realizar um depósito com um valor negativo");
		}
	}

	public void transferir(double valor, Conta conta) {
		if (this.getSaldo() > valor + transferencia) {
			double novoSaldo = getSaldo() - valor - transferencia;
			this.setSaldo(novoSaldo);
			conta.setSaldo(conta.getSaldo() + valor);
			double total = getTotalTributos() + transferencia;
			setTotalTributos(total);
			System.out.println("Transferência realizada com sucesso!");
		} else {
			System.out.println("Saldo insuficiente para transferência.");
		}
	}

}
