package funcionario;


public class Diretor extends Gerente

{
	private String cargo;
	
	public Diretor() {
		super();
		
	}


<<<<<<< HEAD
	public Diretor(String nome, String cpf, String senha,  int ag) {
		super(nome, cpf, senha,  ag);
		this.cargo ="DIRETOR";
=======
	public String getCargo() {
		return cargo;
>>>>>>> DevelopHector
	}


	public Diretor(String nome, String cpf, String senha,  int ag) {
		super(nome, cpf, senha,  ag);
		this.cargo ="DIRETOR";
	}


	@Override
	public String toString() {
		return "Diretor [getCargo()=" + getCargo() + ", getNome()=" + getNome() + ", getCpf()=" + getCpf()
				+ ", getSenha()=" + getSenha() + ", toString()=" + super.toString() + "]";
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

			System.out.println("8- Mostrar informações das contas ");			
			System.out.println("9- Sair");

			
	}
}
