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
import relatorios.RelatorioFuncionarios;
import relatorios.RelatorioOperacoes;
import relatorios.RelatorioTributacao;
import relatorios.RendimentoPoupanca;
import relatorios.Saldo;

public class menu {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		List<Conta> contasBanco = new ArrayList<>();
		List<Usuario> usuario = new ArrayList<>();
		Usuario fulano = new Presidente("Presidente", "1", "1", 1);
		Usuario fulano1 = new Gerente("gerente", "2", "2", 1);
		Usuario fulano11 = new Gerente("gerente2", "22", "22", 2);
		Usuario fulano2 = new Diretor("diretor", "3", "3", 1);
		Usuario fulano3 = new Cliente("Cliente", "4", "4");
		Usuario fulano4 = new Diretor("Michael", "5", "5",1);
		Usuario fulano5 = new Cliente("Jose", "6", "6");
		Usuario fulano6 = new Cliente("Hector", "7", "7");

		Conta cFulano  = new ContaCorrente("1", 5000.0, 1, "CORRENTE");
		Conta cFulano1 = new ContaCorrente("2", 5000.0, 1, "CORRENTE");
		Conta cFulano2 = new ContaCorrente("3", 5000.0, 1, "CORRENTE");
		Conta cFulano3 = new ContaCorrente("4", 5000.0, 1, "CORRENTE");
		Conta cFulano4 = new ContaCorrente("5", 5000.0, 1, "CORRENTE");
		Conta cFulano11 = new ContaCorrente("22", 5000.0, 2, "CORRENTE");
		Conta cFulano5 = new ContaCorrente("6", 5000.0, 2, "CORRENTE");
		Conta cFulano6 = new ContaCorrente("7", 5000.0, 2, "CORRENTE");
		


		usuario.add(fulano);
		usuario.add(fulano1);
		usuario.add(fulano2);
		usuario.add(fulano3);
		usuario.add(fulano4);
		usuario.add(fulano11);
		usuario.add(fulano5);
		usuario.add(fulano6);
	
		
		contasBanco.add(cFulano);
		contasBanco.add(cFulano1);
		contasBanco.add(cFulano2);
		contasBanco.add(cFulano3);
		contasBanco.add(cFulano4);
		contasBanco.add(cFulano11);
		contasBanco.add(cFulano5);
		contasBanco.add(cFulano6);

		
		
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
		RelatorioTributacao relatorioTributacao = new RelatorioTributacao();
		Saldo relatorioSaldo = new Saldo();
		RendimentoPoupanca relatorioPoupanca = new RendimentoPoupanca();
		RelatorioFuncionarios relatorioContas = new RelatorioFuncionarios();
		RelatorioFuncionarios relatorioUsuarios = new RelatorioFuncionarios();
		RelatorioFuncionarios relatorioCapital = new RelatorioFuncionarios();
		RelatorioOperacoes relatorio = new RelatorioOperacoes();
		Conta contaPoupanca = new ContaPoupanca();
		Scanner leitor = new Scanner(System.in);
		String cpf;
		String senha;
		Conta contaDestinatario = null;
		Usuario usuarioDestinatario = null;
		int x = 0;
		int dias;

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
				System.out.println("Digite a sua opção: ");

				opcao = leitor.nextInt();

				switch (opcao) {
				case 1:
					System.out.println("Digite o valor a ser sacado.");
					valor = leitor.nextDouble();
					contaBanco.sacar(valor);
					relatorio.pathSaque(contaBanco, cliente, valor);
					x = 1;
					break;

				case 2:
					System.out.println("Digite o valor a ser depositado.");
					valor = leitor.nextDouble();
					contaBanco.depositar(valor);
					relatorio.pathDeposito(contaBanco, valor, cliente);
					x = 1;
					break;

				case 3:
					System.out.println("Digite o valor a para ser transferido.");
					valor = leitor.nextDouble();
					System.out.println("Digite o CPF do destinatário.");
					cpf = leitor.next();

					contaDestinatario = encontrarConta(cpf, contasBanco);
					usuarioDestinatario = encontrarUsuario(cpf, usuario);

					if (contaDestinatario != null) {
						contaBanco.transferir(valor, contaDestinatario);
						relatorio.pathTransferencia(contaBanco, valor, cliente, usuarioDestinatario);
					} else
						System.out.println("Conta não encontrada");
					
					x = 1;
					break;

				case 4:
					relatorioSaldo.pathsaldo(cliente, contaBanco);
					System.out.println("Seu saldo é de: R$ " + contaBanco.getSaldo());
					x = 1;
					break;

				case 5:
					relatorioTributacao.pathTributacao(cliente, contaBanco);
					x = 1;
					break;

				case 6:
					System.out.println("Digite o valor a simular: ");
					valor = leitor.nextDouble();
					System.out.println("Digite o número de dias para o rendimento: ");
					dias = leitor.nextInt();
					relatorioPoupanca.pathRendimento(contaPoupanca, cliente, valor, dias);
					x = 1;
					break;

				case 7:
					System.out.println("Obrigado por utilizar nosso aplicativo! ");
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
				System.out.println("Digite a sua opção: ");
				opcao = leitor.nextInt();

				switch (opcao) {
				case 1:
					System.out.println("Digite o valor a ser sacado.");
					valor = leitor.nextDouble();
					contaBanco.sacar(valor);
					relatorio.pathSaque(contaBanco, cliente, valor);
					x = 1;
					break;

				case 2:
					System.out.println("Digite o valor a ser depositado.");
					valor = leitor.nextDouble();
					contaBanco.depositar(valor);
					relatorio.pathDeposito(contaBanco, valor, cliente);
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
						relatorio.pathTransferencia(contaBanco, valor, cliente, usuarioDestinatario);
					} else
						System.out.println("Conta não encontrada");
					x = 1;
					break;

				case 4:
					relatorioSaldo.pathsaldo(cliente, contaBanco);
					System.out.println("Seu saldo é de: R$ " + contaBanco.getSaldo());
					x = 1;
					break;

				case 5:
					relatorioTributacao.pathTributacao(cliente, contaBanco);
					x = 1;
					break;

				case 6:
					System.out.println("Digite o valor a simular: ");
					valor = leitor.nextDouble();
					System.out.println("Digite o número de dias para o rendimento: ");
					dias = leitor.nextInt();
					relatorioPoupanca.pathRendimento(contaPoupanca, cliente, valor, dias);
					x = 1;
					break;

				case 7:					
					relatorioContas.totalDeContasSupervisionadas(contaBanco, cliente);
					x = 1;
					break;

				case 8:
					System.out.println("Obrigado por utilizar nosso aplicativo! ");
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
				System.out.println("Digite a sua opção: ");
				opcao = leitor.nextInt();

				switch (opcao) {
				case 1:
					System.out.println("Digite o valor a ser sacado.");
					valor = leitor.nextDouble();
					contaBanco.sacar(valor);
					relatorio.pathSaque(contaBanco, cliente, valor);
					x = 1;
					break;

				case 2:
					System.out.println("Digite o valor a ser depositado.");
					valor = leitor.nextDouble();
					contaBanco.depositar(valor);
					relatorio.pathDeposito(contaBanco, valor, cliente);
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
						relatorio.pathTransferencia(contaBanco, valor, cliente, usuarioDestinatario);
					} else
						System.out.println("Conta não encontrada");
					x = 1;
					break;

				case 4:
					relatorioSaldo.pathsaldo(cliente, contaBanco);
					System.out.println("Seu saldo é de: R$ " + contaBanco.getSaldo());
					x = 1;
					break;

				case 5:
					relatorioTributacao.pathTributacao(cliente, contaBanco);
					x = 1;
					break;

				case 6:
					System.out.println("Digite o valor a simular: ");
					valor = leitor.nextDouble();
					System.out.println("Digite o número de dias para o rendimento: ");
					dias = leitor.nextInt();
					relatorioPoupanca.pathRendimento(contaPoupanca, cliente, valor, dias);
					x = 1;
					break;

				case 7:
					relatorioContas.totalDeContasSupervisionadas(contaBanco, cliente);
					x = 1;
					break;

				case 8:
					relatorioUsuarios.informacaoClientes(contaBanco, cliente, usuario, contasBanco);
					x = 1;
					break;

				case 9:
					System.out.println("Obrigado por utilizar nosso aplicativo! ");
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
				System.out.println("Digite a sua opção: ");
				opcao = leitor.nextInt();

				switch (opcao) {
				case 1:
					System.out.println("Digite o valor a ser sacado.");
					valor = leitor.nextDouble();
					contaBanco.sacar(valor);
					relatorio.pathSaque(contaBanco, cliente, valor);
					x = 1;
					break;

				case 2:
					System.out.println("Digite o valor a ser depositado.");
					valor = leitor.nextDouble();
					contaBanco.depositar(valor);
					relatorio.pathDeposito(contaBanco, valor, cliente);
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
						relatorio.pathTransferencia(contaBanco, valor, cliente, usuarioDestinatario);
					} else
						System.out.println("Conta não encontrada");
					x = 1;
					break;

				case 4:
					relatorioSaldo.pathsaldo(cliente, contaBanco);
					System.out.println("Seu saldo é de: R$ " + contaBanco.getSaldo());
					x = 1;
					break;

				case 5:
					relatorioTributacao.pathTributacao(cliente, contaBanco);
					x = 1;
					break;

				case 6:
					System.out.println("Digite o valor a simular: ");
					valor = leitor.nextDouble();
					System.out.println("Digite o número de dias para o rendimento: ");
					dias = leitor.nextInt();
					relatorioPoupanca.pathRendimento(contaPoupanca, cliente, valor, dias);
					x = 1;
					break;

				case 7:
					relatorioContas.totalDeContasSupervisionadas(contaBanco, cliente);
					x = 1;
					break;

				case 8:
					relatorioUsuarios.informacaoClientes(contaBanco, cliente, usuario, contasBanco);
					x = 1;
					break;

				case 9:
					relatorioCapital.totalDeCapital(contaBanco, cliente, contasBanco);
					x = 1;
					break;

				case 10:
					System.out.println("Obrigado por utilizar nosso aplicativo! ");
					x = 0;
					break;

				default:
					System.out.println("Número inválido. Digite outro por favor.");
					x = 1;
					break;
				}
			} while (x == 1);
		}System.out.println(contaBanco.toString());
	}

	private static Usuario encontrarUsuario(String cpf, List<Usuario> usuario) {
		for (Usuario contaUsuario : usuario) {
			if (contaUsuario.getCpf().equalsIgnoreCase(cpf))
				return contaUsuario;
		}
		
		return null;
	}
}
