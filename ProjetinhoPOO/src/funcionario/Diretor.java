package funcionario;

import java.util.Scanner;

import cliente.Cliente;
import contas.Conta;

public class Diretor extends Gerente

{
	private String cargo = "DIRETOR";

	public Diretor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Diretor(String nome, String cpf, String senha, int ag) {
		super(nome, cpf, senha, ag);
		// TODO Auto-generated constructor stub
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return "Diretor [getCargo()=" + getCargo() + ", getNome()=" + getNome() + ", getCpf()=" + getCpf()
				+ ", getSenha()=" + getSenha() + ", toString()=" + super.toString() + "]";
	}

	public static void menuDiretor(Conta contaUsuario) {

		Scanner leitor = new Scanner(System.in);
		int opcao = 0;
		int x = 0;

		do {
			System.out.println("**********Bem Vindo " + contaUsuario.getNome() + "**********");
			System.out.println("-----------------------------------------");
			System.out.println("-----------------------------------------");
			System.out.println("------------------MENU------------------");
			System.out.println(" Movimentações na Conta  ");
			System.out.println("1- Sacar");
			System.out.println("2- Depósitar");
			System.out.println("3- Transferir");
			System.out.println("\n");

			System.out.println(" Relatórios ");
			System.out.println("4- Saldo ");
			System.out.println("5- Relatório de tributação da conta corrente");
			System.out.println("6- Relatório de Rendimento da poupança ");
			System.out.println("7- Relatório do número contas ");

			System.out.println("8- informações(Contas) ");
			System.out.println("\n");
			System.out.println("                       9- Sair                                                  ");

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

			default:
				break;
			}
		} while (x == 0);
	}
}
