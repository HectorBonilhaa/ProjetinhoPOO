package cliente;

public class Cliente extends Usuario {
<<<<<<< HEAD

	private String cargo;

=======
<<<<<<< HEAD

	private PessoaEnum tipo;

=======
	
	private String tipo;
>>>>>>> afe94e3fe09ab3631e7da2c86a62d150a497e5c2
>>>>>>> 0a6345f08f93dd1a956a2835b5a8a19ed26b8c8a
	public Cliente() {
		super();
	}

<<<<<<< HEAD
	public String getCargo() {
		return this.cargo;
	}
=======
<<<<<<< HEAD
	public Cliente(String nome, String cpf, String senha, PessoaEnum tipo) {
		super(nome, cpf, senha, tipo);
		this.tipo = PessoaEnum.CLIENTE;
	}
=======
	

	
	public Cliente(String nome, String cpf, String senha, String userTipo, String funcao) {
		super(nome, cpf, senha, userTipo, funcao);
		this.tipo = "CLIENTE";
			}



>>>>>>> 0a6345f08f93dd1a956a2835b5a8a19ed26b8c8a

	public Cliente(String nome, String cpf, String senha) {
		super(nome, cpf, senha);
		this.cargo = "CLIENTE";

<<<<<<< HEAD
	}
=======
>>>>>>> afe94e3fe09ab3631e7da2c86a62d150a497e5c2
>>>>>>> 0a6345f08f93dd1a956a2835b5a8a19ed26b8c8a

	@Override
	public String toString() {
		return "Cliente [tipo=" + cargo + ", getNome()=" + getNome() + ", getCpf()=" + getCpf() + ", getSenha()="
				+ getSenha() + "]";
	}

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======



>>>>>>> afe94e3fe09ab3631e7da2c86a62d150a497e5c2
>>>>>>> 0a6345f08f93dd1a956a2835b5a8a19ed26b8c8a
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
