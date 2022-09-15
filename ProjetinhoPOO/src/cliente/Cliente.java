package cliente;

import java.util.Scanner;

import enums.PessoaEnum;

public class Cliente extends Usuario {
<<<<<<< HEAD

	private PessoaEnum tipo;

=======
	
	private String tipo;
>>>>>>> afe94e3fe09ab3631e7da2c86a62d150a497e5c2
	public Cliente() {
		super();
	}

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





>>>>>>> afe94e3fe09ab3631e7da2c86a62d150a497e5c2

	@Override
	public String toString() {
		return "Cliente [tipo=" + tipo + ", getNome()=" + getNome() + ", getCpf()=" + getCpf() + ", getSenha()="
				+ getSenha() + "]";
	}

<<<<<<< HEAD
=======



>>>>>>> afe94e3fe09ab3631e7da2c86a62d150a497e5c2
	@Override
	public void menu() {
		Scanner leitor = new Scanner(System.in);
		int opcao = 0;
		int x = 0;

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
		opcao = leitor.nextInt();

		switch (opcao) {
		case 1:
			break;

		case 2:
			break;

		case 3:
			break;

		case 4:
			break;

		case 5:
			break;

		case 6:
			break;

		case 7:
			break;

		default:
			break;
		}

	}

}
