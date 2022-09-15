package main;

import java.io.IOException;
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
import relatorios.RelatorioTributacao;

public class menu {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		List<Conta> contasBanco = new ArrayList<>();
		List<Usuario> usuario = new ArrayList<>();
		Usuario fulano = new Presidente("Presidente", "1", "1", 001);
		Usuario fulano1 = new Gerente("gerente", "2", "2", 001);
		Usuario fulano2 = new Diretor("diretor", "3", "3", 001);
		Usuario fulano3 = new Cliente("Cliente", "4", "4");
		Usuario fulano4 = new Cliente("Michael", "5", "5");

		Conta cFulano = new ContaCorrente("1", 5000.0, 001, "CORRENTE", 001);
		Conta cFulano1 = new ContaCorrente("2", 5000.0, 001, "CORRENTE", 001);
		Conta cFulano2 = new ContaCorrente("3", 5000.0, 001, "CORRENTE", 001);
		Conta cFulano3 = new ContaCorrente("4", 5000.0, 001, "CORRENTE", 001);
		Conta cFulano4 = new ContaCorrente("5", 5000.0, 001, "CORRENTE", 001);

		usuario.add(fulano);
		usuario.add(fulano1);
		usuario.add(fulano2);
		usuario.add(fulano3);
		usuario.add(fulano4);
		contasBanco.add(cFulano);
		contasBanco.add(cFulano1);
		contasBanco.add(cFulano2);
		contasBanco.add(cFulano3);
		contasBanco.add(cFulano4);

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

	public static Conta encontrarConta(String cpf, List<Conta> contasBanco) {
		for (Conta contaUsuario : contasBanco) {
			if (contaUsuario.getCpf().equalsIgnoreCase(cpf))
				return contaUsuario;
		}
		return null;
	}

	public static void menuLogin(List<Conta> contasBanco, List<Usuario> usuario) throws IOException {
		RelatorioTributacao relatorio1 = new RelatorioTributacao();
		Scanner leitor = new Scanner(System.in);
		String cpf;
		String senha;
		Conta contaDestinatario = null;
		int x = 0;

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

			do {
				cliente.menu();
				int opcao;
				double valor;

				opcao = leitor.nextInt();

				switch (opcao) {
				case 1:
					System.out.println("Digite o valor a ser sacado.");
					valor = leitor.nextDouble();
					contaBanco.sacar(valor);
					x = 1;
					break;

				case 2:
					System.out.println("Digite o valor a ser depositado.");
					valor = leitor.nextDouble();
					contaBanco.depositar(valor);
					x = 1;
					break;

				case 3:
					System.out.println("Digite o valor a para ser transferido.");
					valor = leitor.nextDouble();
					System.out.println("Digite o CPF do destinatário.");
					cpf = leitor.next();

					contaDestinatario = encontrarConta(cpf, contasBanco);

					if (contaDestinatario != null) {
						contaBanco.transferir(valor, contaDestinatario);
					} else
						System.out.println("Conta não encontrada");

					x = 1;
					break;

				case 4:
					x = 1;
					break;

				case 5:
					relatorio1.pathTributacao(cliente, contaBanco);
					x = 1;
					break;

				case 6:
					x = 1;
					break;

				case 7:
					x = 0;
					break;

				default:
					System.out.println("Número inválido. Digite outro por favor.");
					x = 1;
					break;
				}

			} while (x == 1);
		}
		if (cliente.getCargo().equalsIgnoreCase(PessoaEnum.GERENTE.name())) {
			do {
				cliente.menu();

				int opcao;
				double valor;
				opcao = leitor.nextInt();

				switch (opcao) {
				case 1:
					System.out.println("Digite o valor a ser sacado.");
					valor = leitor.nextDouble();
					contaBanco.sacar(valor);
					x = 1;
					break;

				case 2:
					System.out.println("Digite o valor a ser depositado.");
					valor = leitor.nextDouble();
					contaBanco.depositar(valor);
					x = 1;
					break;

				case 3:
					System.out.println("Digite o valor a para ser transferido.");
					valor = leitor.nextDouble();
					System.out.println("Digite o CPF do destinatário.");
					cpf = leitor.next();

					contaDestinatario = encontrarConta(cpf, contasBanco);

					if (contaDestinatario != null) {
						contaBanco.transferir(valor, contaDestinatario);
					} else
						System.out.println("Conta não encontrada");
					x = 1;
					break;

				case 4:
					x = 1;
					break;

				case 5:
					x = 1;
					break;

				case 6:
					x = 1;
					break;

				case 7:
					x = 1;
					break;

				case 8:
					x = 0;
					break;

				default:
					System.out.println("Número inválido. Digite outro por favor.");
					x = 1;
					break;
				}

			} while (x == 1);
		}

		if (cliente.getCargo().equalsIgnoreCase(PessoaEnum.DIRETOR.name())) {
			do {
				cliente.menu();

				int opcao;
				double valor;
				opcao = leitor.nextInt();

				switch (opcao) {
				case 1:
					System.out.println("Digite o valor a ser sacado.");
					valor = leitor.nextDouble();
					contaBanco.sacar(valor);
					x = 1;
					break;

				case 2:
					System.out.println("Digite o valor a ser depositado.");
					valor = leitor.nextDouble();
					contaBanco.depositar(valor);
					x = 1;
					break;

				case 3:
					System.out.println("Digite o valor a para ser transferido.");
					valor = leitor.nextDouble();
					System.out.println("Digite o CPF do destinatário.");
					cpf = leitor.next();

					contaDestinatario = encontrarConta(cpf, contasBanco);

					if (contaDestinatario != null) {
						contaBanco.transferir(valor, contaDestinatario);
					} else
						System.out.println("Conta não encontrada");
					x = 1;
					break;

				case 4:
					x = 1;
					break;

				case 5:
					x = 1;
					break;

				case 6:
					x = 1;
					break;

				case 7:
					x = 1;
					break;

				case 8:
					x = 1;
					break;

				case 9:
					x = 0;
					break;

				default:
					System.out.println("Número inválido. Digite outro por favor.");
					x = 1;
					break;
				}

			} while (x == 1);
		}
		if (cliente.getCargo().equalsIgnoreCase(PessoaEnum.PRESIDENTE.name())) {
			do {
				cliente.menu();

				int opcao;
				double valor;
				opcao = leitor.nextInt();

				switch (opcao) {
				case 1:
					System.out.println("Digite o valor a ser sacado.");
					valor = leitor.nextDouble();
					contaBanco.sacar(valor);
					x = 1;
					break;

				case 2:
					System.out.println("Digite o valor a ser depositado.");
					valor = leitor.nextDouble();
					contaBanco.depositar(valor);
					x = 1;
					break;

				case 3:
					System.out.println("Digite o valor a para ser transferido.");
					valor = leitor.nextDouble();
					System.out.println("Digite o CPF do destinatário.");
					cpf = leitor.next();

					contaDestinatario = encontrarConta(cpf, contasBanco);

					if (contaDestinatario != null) {
						contaBanco.transferir(valor, contaDestinatario);
					} else
						System.out.println("Conta não encontrada");
					x = 1;
					break;

				case 4:
					x = 1;
					break;

				case 5:
					x = 1;
					break;

				case 6:
					x = 1;
					break;

				case 7:
					x = 1;
					break;

				case 8:
					x = 1;
					break;

				case 9:
					x = 1;
					break;

				case 10:
					x = 0;
					break;

				default:
					System.out.println("Número inválido. Digite outro por favor.");
					x = 1;
					break;
				}
			} while (x == 1);
		}
	}
}
