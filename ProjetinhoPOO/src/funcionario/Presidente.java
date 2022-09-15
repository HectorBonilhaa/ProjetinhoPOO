package funcionario;

import java.util.Scanner;

import cliente.Cliente;
import contas.Conta;
import enums.PessoaEnum;

public class Presidente extends Diretor {

	private String cargo;

	public Presidente() {
		super();
		
	}

	

	public Presidente(String nome, String cpf, String senha, String userTipo, String funcao, int ag) {
		super(nome, cpf, senha, userTipo, funcao, ag);
		 this.cargo = "PRESIDENTE";
	}



	@Override
	public String toString() {
		return "Presidente [getNome()=" + getNome() + ", getCargo()=" + getCargo() + ", getCpf()=" + getCpf()
				+ ", getSenha()=" + getSenha() + "]";
	}

	@Override
	public void menu() {

		Scanner leitor = new Scanner(System.in);
		int opcao = 0;
		int x = 0;

		do {
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
			System.out.println("9- Consultar valor total do capital ");
			System.out.println("10- Sair");

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

			case 8:
				break;

			case 9:
				break;

			case 10:
				break;

			default:
				break;

			}
		} while (x == 0);

	}
}
