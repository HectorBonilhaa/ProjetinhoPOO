package contas;

public abstract class Conta implements Tributos {

	// Variáveis //

	private String cpf;
	private double saldo;
	private int agencia;
	private String tipo;
	protected  int numContas;
	static int totalAgencia1 = 0;
	static int totalAgencia2 = 0;
	private static double totalTributos = 0.0;
	public static int contadorContas = 1;
	
	
	
	
	
	// Construtores //

	public Conta() {
		super();
	}

	public Conta(String cpf, double saldo, int agencia, String tipo) {
		super();
		this.cpf = cpf;
		this.saldo = saldo;
		this.agencia = agencia;
		this.tipo = tipo;
				
		this.numContas=contadorContas;
		contadorContas++;
		
		
		
		if(agencia == 1) {
			totalAgencia1 ++;
		}else {
				totalAgencia2 ++;
			}
		
	}

	// Getters and Setters //

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
		if (agencia == 1) {
			totalAgencia1++;
		} else if (agencia == 2) {
			totalAgencia2++;
		}
	}

	public static int getTotalAgencia1() {
		return totalAgencia1;
	}

	public static int getTotalAgencia2() {
		return totalAgencia2;
	}

	public String getTipo() {
		return tipo;
	}

	public int getNumContas() {
		return numContas;
	}

	public double getTotalTributos() {
		return totalTributos;
	}

	public void setTotalTributos(double totalTributos) {
		this.totalTributos = totalTributos;
	}
	
	public int getContadorContas() {
		 return contadorContas;
	}

	// Operações!

	public void sacar(double valor) {
	
	}

	public void depositar(double valor) {
		
	}

	public void transferir(double valor, Conta conta) {
		
	}
	
	

}
