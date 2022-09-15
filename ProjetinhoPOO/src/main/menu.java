package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cliente.Cliente;
import cliente.Usuario;
import contas.Conta;
import contas.ContaCorrente;
import contas.ContaPoupanca;
import enums.PessoaEnum;
import funcionario.Diretor;
import funcionario.Funcionario;
import funcionario.Gerente;
import funcionario.Presidente;

public class menu {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		List<Conta> contasBanco = new ArrayList<>();
		List<Usuario> usuario = new ArrayList<>();
<<<<<<< HEAD
		Usuario fulano = new Presidente("Presidente", "1", "1", 1);
		Usuario fulano1 = new Gerente("gerente", "2", "2", 001);
		Usuario fulano2 = new Diretor("diretor", "3", "3", 001);
		Usuario fulano3 = new Cliente("Cliente", "4", "4");

=======
<<<<<<< HEAD
	    Usuario fulano = new Presidente("presida", "1", "1", PessoaEnum.PRESIDENTE, 001);
	    Usuario fulano1 = new Gerente("gerente", "2", "2", PessoaEnum.GERENTE, 001);
	    Usuario fulano2 = new Diretor("diretor", "3", "3", PessoaEnum.DIRETOR, 001);
=======
	    Usuario fulano = new Presidente("Presidente", "1", "1", "PRESIDENTE", "PRESEDENTE", 1);
//	    Usuario fulano1 = new Gerente("gerente", "2", "2", PessoaEnum.GERENTE, 001);
//	    Usuario fulano2 = new Diretor("diretor", "3", "3", PessoaEnum.DIRETOR, 001);
>>>>>>> afe94e3fe09ab3631e7da2c86a62d150a497e5c2
>>>>>>> 0a6345f08f93dd1a956a2835b5a8a19ed26b8c8a
		Conta cFulano = new ContaCorrente("1", 5000.0, 001, "CORRENTE", 1);
		Conta cFulano1 = new ContaCorrente("2", 5000.0, 001, "CORRENTE", 1);
		Conta cFulano2 = new ContaCorrente("3", 5000.0, 001, "CORRENTE", 1);
		Conta cFulano3 = new ContaCorrente("4", 5000.0, 001, "CORRENTE", 1);

		usuario.add(fulano);
<<<<<<< HEAD
		usuario.add(fulano1);
		usuario.add(fulano2);
		usuario.add(fulano3);
=======
<<<<<<< HEAD
		usuario.add(fulano1);
		usuario.add(fulano2);
=======
//		usuario.add(fulano1);
//		usuario.add(fulano2);
>>>>>>> afe94e3fe09ab3631e7da2c86a62d150a497e5c2
>>>>>>> 0a6345f08f93dd1a956a2835b5a8a19ed26b8c8a
		contasBanco.add(cFulano);
		contasBanco.add(cFulano1);
		contasBanco.add(cFulano2);
		contasBanco.add(cFulano3);

		menuLogin(contasBanco, usuario);
	}

	public static Usuario autenticarCliente(String cpf, String senha, List<Usuario> usuario) {
		for (Usuario clienteUsuario : usuario) {
			if (clienteUsuario.getCpf().equalsIgnoreCase(cpf) && clienteUsuario.getSenha().equalsIgnoreCase(senha))
				return clienteUsuario;
		}
		return null;

	}

	public static Conta autenticarConta(String cpf, List<Conta> contasBanco) {
		for (Conta contaUsuario : contasBanco) {
			if (contaUsuario.getCpf().equalsIgnoreCase(cpf))
				return contaUsuario;
		}
		return null;

	}

	public static void menuLogin(List<Conta> contasBanco, List<Usuario> usuario) {
		Scanner leitor = new Scanner(System.in);
		String cpf;
		String senha;

		System.out.println("**********Bem Vindo a F.E.J.H.M**********");
		System.out.println("-----------------------------------------");
		System.out.println("-----------------------------------------");
		System.out.println("------------------Login------------------");
		System.out.println("\n");
		System.out.print("CPF: ");
		cpf = leitor.next();
		System.out.print("Senha: ");
		senha = leitor.next();

		Usuario cliente = autenticarCliente(cpf, senha, usuario);
		Conta contaBanco = autenticarConta(cpf, contasBanco);

		if (cliente == null && contaBanco == null) {
			System.out.println("Senha ou cpf inválidos");
			menuLogin(contasBanco, usuario);
		}

		if (cliente.getCargo().equalsIgnoreCase(PessoaEnum.CLIENTE.name())) {
			cliente.menu();

			int opcao;
			double valor;
			
			opcao = leitor.nextInt();

			switch (opcao) {
			case 1: valor = leitor.nextDouble();
					contaBanco.sacar(valor);
				break;

			case 2: valor = leitor.nextDouble();
			contaBanco.depositar(valor);
				break;

			case 3: valor = leitor.nextDouble();
			cpf = leitor.nextLine();
			contaBanco.transferir(valor,contasBanco.get);
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

		}
		if (cliente.getCargo().equalsIgnoreCase(PessoaEnum.GERENTE.name())) {
			cliente.menu();

			int opcao;
			double valor;
			opcao = leitor.nextInt();

			switch (opcao) {
			case 1: valor = leitor.nextDouble();
			contaBanco.sacar(valor);
				break;

			case 2:valor = leitor.nextDouble();
			contaBanco.depositar(valor);
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

		}

		if (cliente.getCargo().equalsIgnoreCase(PessoaEnum.DIRETOR.name())) {
			cliente.menu();

			int opcao;
			double valor;
			opcao = leitor.nextInt();

			switch (opcao) {
			case 1: valor = leitor.nextDouble();
			contaBanco.sacar(valor);
				break;

			case 2: valor = leitor.nextDouble();
			contaBanco.depositar(valor);
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

		}

		if (cliente.getCargo().equalsIgnoreCase(PessoaEnum.PRESIDENTE.name())) {
			cliente.menu();

			int opcao;
			double valor;
			opcao = leitor.nextInt();

			switch (opcao) {
			case 1: valor = leitor.nextDouble();
			contaBanco.sacar(valor);
				break;

			case 2: valor = leitor.nextDouble();
			contaBanco.depositar(valor);
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
		}
	}
}
