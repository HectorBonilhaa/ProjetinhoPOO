package cliente;

public class Cliente extends Usuario {

	private String cargo;

	public Cliente() {
		super();
	}

	public String getCargo() {
		return this.cargo;
	}

	public Cliente(String nome, String cpf, String senha) {
		super(nome, cpf, senha);
		this.cargo = "CLIENTE";

	}

	@Override
	public String toString() {
		return "Cliente [tipo=" + cargo + ", getNome()=" + getNome() + ", getCpf()=" + getCpf() + ", getSenha()="
				+ getSenha() + "]";
	}

	@Override
	public void menu() {

		System.out.println("**********Bem Vindo " + getNome() + "**********");
		System.out.println("-----------------------------------------");
		System.out.println("-----------------------------------------");
		System.out.println("------------------MENU------------------");
		System.out.println(" Movimentações na Conta  ");
		System.out.println("1- Sacar");
		System.out.println("2- Depósitar");
		System.out.println("3- Transferir");
		System.out.println("\n");

		System.out.println(" Relatórios ");
		System.out.println("4- Consultar saldo ");
		System.out.println("5- Relatório de tributação da conta corrente");
		System.out.println("6- Relatório de Rendimento da poupança ");
		System.out.println("7- Sair");

		System.out.println("\n");

	}

}
