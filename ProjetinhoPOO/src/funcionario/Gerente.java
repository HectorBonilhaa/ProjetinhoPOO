package funcionario;




public class Gerente extends Funcionario {
	protected String cargo;
	private int agencia;

	public Gerente() {
		super();
<<<<<<< HEAD
		// TODO Auto-generated constructor stub
	}

	public Gerente(String nome, String cpf, String senha, PessoaEnum userTipo, int ag) {
		super(nome, cpf, senha, userTipo);
		this.cargo = PessoaEnum.GERENTE;
		this.agencia = ag;
=======
>>>>>>> afe94e3fe09ab3631e7da2c86a62d150a497e5c2
		
	}
public String getCargo() {
	return this.cargo;
}



	public Gerente(String nome, String cpf, String senha, int ag) {
		super(nome, cpf, senha);
		this.cargo = "GERENTE";
		this.agencia = ag;
	}




	@Override
	public String toString() {
		return "Funcionario nome : " + getNome() + "\n          Cargo: " + cargo + "\n          CPF  : " + getCpf()
				+ "\n          senha: " + getSenha() + "\n\n";
	}

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
			System.out.println("7- Relatório do número contas ");
			System.out.println("8- Sair");

			System.out.println("\n");
		}

}
