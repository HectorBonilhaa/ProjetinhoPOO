package contas;

import cliente.Cliente;

public abstract class Conta extends Cliente {

	private static int contadorDeContas = 1;

	private int numeroConta;
	private Double saldo = 0.0;
	private int agencia;
	private Double tarifasSaque = 0.10;
	private Double tarifasDeposito = 0.10;
	private Double tarifaTransferir = 0.20;
	private String TIPOU;

	public Conta(String nome, String cpf, String senha, int numeroConta, Double saldo, int agencia) {

		super(nome, cpf, senha);

		this.numeroConta = contadorDeContas;
		contadorDeContas += 1;

		this.saldo = saldo;

		this.agencia = agencia;

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

	public Double getTarifasSaque() {
		return tarifasSaque;
	}

	public void setTarifasSaque(Double tarifasSaque) {
		this.tarifasSaque = tarifasSaque;
	}

	public Double getTarifasDeposito() {
		return tarifasDeposito;
	}

	public void setTarifasDeposito(Double tarifasDeposito) {
		this.tarifasDeposito = tarifasDeposito;
	}

	public Double getTarifaTransferir() {
		return tarifaTransferir;
	}

	public void setTarifaTransferir(Double tarifaTransferir) {
		this.tarifaTransferir = tarifaTransferir;
	}

	public String getTIPOU() {
		return TIPOU;
	}

	@Override
	public String toString() {
		return "Conta [numeroConta=" + numeroConta + ", \nsaldo=" + saldo + ", \nagencia=" + agencia + "\ngetNome()="
				+ getNome() + ", \ngetCpf()=" + getCpf() + ", \ngetSenha()=" + getSenha() + "]";
	}

	public void depositar(Double valor) {
		if (valor > 0) {
			setSaldo(getSaldo() + valor - tarifasDeposito);
			System.out.println("Depósito realizado com sucesso!");
		} else {
			System.out.println("Depósito não realizado!");

		}

	}

	public void sacar(Double valor) {
		if (valor > 0 && this.getSaldo() >= valor + tarifasSaque) {
			setSaldo(getSaldo() - valor - tarifasSaque);
			System.out.println("Saque realizado com sucesso!");
		} else {
			System.out.println("Não foi possível realizar o saque!");
		}
	}

	public void transferir(Conta contaParaDeposito, Double valor) {
		if (valor > 0 && this.getSaldo() >= valor + tarifaTransferir) {
			setSaldo(getSaldo() - valor - tarifaTransferir);

			contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
			System.out.println("Transferência realizada com sucesso!");
		} else {
			System.out.println("Não foi possível realizar a transferência!");
		}

	}
}
