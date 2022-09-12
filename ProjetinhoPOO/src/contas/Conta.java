package contas;

import cliente.Cliente;

abstract class Conta extends Cliente {

	private static int contadorDeContas = 1;

	private int numeroConta;
	private Double saldo = 0.0;
	private int agencia;
	private Double tarifas;
	private String TIPOU;

	public Conta(String nome, String cpf, String senha, int numeroConta, Double saldo, int agencia, Double tarifas,
			String TIPOU) {

		super(nome, cpf, senha);

		this.numeroConta = contadorDeContas;
		contadorDeContas += 1;

		this.saldo = saldo;

		this.agencia = agencia;

		this.tarifas = tarifas;

	}

	public static int getContadorDeContas() {
		return contadorDeContas;
	}

	public static void setContadorDeContas(int contadorDeContas) {
		Conta.contadorDeContas = contadorDeContas;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public Double getTarifas() {
		return tarifas;
	}

	public void setTarifas(Double tarifas) {
		this.tarifas = tarifas;
	}

	public String getTIPOU() {
		return TIPOU;
	}

	@Override
	public String toString() {
		return "Conta [numeroConta=" + numeroConta + ", \nsaldo=" + saldo + ", \nagencia=" + agencia + ", \ntarifas="
				+ tarifas + ", \nTIPOU=" + TIPOU + ", \ngetNome()=" + getNome() + ", \ngetCpf()=" + getCpf()
				+ ", \ngetSenha()=" + getSenha() + "]";
	}

	public void depositar(Double valor) {
		if (valor > 0) {
			setSaldo(getSaldo() + valor - 0.10);
			System.out.println("Depósito realizado com sucesso!");
		} else {
			System.out.println("Depósito não realizado!");

		}

	}

	public void sacar(Double valor) {
		if (valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor - 0.10);
			System.out.println("Saque realizado com sucesso!");
		} else {
			System.out.println("Não foi possível realizar o saque!");
		}
	}

	public void transferir(Conta contaParaDeposito, Double valor) {
		if (valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor - 0.20);

			contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
			System.out.println("Transferência realizada com sucesso!");
		} else {
			System.out.println("Não foi possível realizar a transferência!");
		}

	}
}
