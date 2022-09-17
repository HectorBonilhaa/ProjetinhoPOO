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
import funcionario.Gerente;
import funcionario.Presidente;
import relatorios.RelatorioFuncionarios;
import relatorios.RelatorioOperacoes;
import relatorios.RelatorioTributacao;
import relatorios.RendimentoPoupanca;
import relatorios.Saldo;

public class SistemaInterno {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		List<Conta> contasBanco = new ArrayList<>();
		List<Usuario> usuario = new ArrayList<>();
		
		Usuario user1  = new Presidente("Michael", "123.456.789-95", "171", 1);
		Usuario user2  = new Gerente("Suco de uva", "000.000.000-01", "2345678", 1);
		Usuario user3  = new Gerente("Hector", "111.222.333-45", "12345", 2);
		Usuario user4  = new Diretor("Francisco", "999.888.777-65", "98765", 1);
		Usuario user5  = new Cliente("Fulano", "456.234.656-87", "123");
		Usuario user6  = new Diretor("Evanir", "001.002.003.04", "69", 2);
		Usuario user7  = new Cliente("Jose", "999.999.999-99", "brunosessin123");
		Usuario user8  = new Cliente("Marcelo", "medaumanotamaxima", "vocemuitolegal");
		Usuario user9  = new Presidente("GIGACHAD", "PODEROSAO", "999", 2);
		Usuario user10 = new Cliente("Fulano", "1", "1");
		Usuario user11 = new Cliente("Fulano2", "2", "2");
		Usuario user12 = new Cliente("Fulano3", "3", "3");

		Conta ContaUser1  = new ContaCorrente("123.456.789-95", 10000, 1, "CORRENTE");
		Conta ContaUser2  = new ContaCorrente("000.000.000-01", 10000, 1, "CORRENTE");
		Conta ContaUser3  = new ContaCorrente("111.222.333-45", 10000, 2, "CORRENTE");
		Conta ContaUser4  = new ContaCorrente("999.888.777-65", 10000, 1, "CORRENTE");
		Conta ContaUser5  = new ContaCorrente("456.234.656-87", 10000, 1, "CORRENTE");
		Conta ContaUser6  = new ContaCorrente("001.002.003.04", 10000, 2, "CORRENTE");
		Conta ContaUser7  = new ContaCorrente("999.999.999-99", 10000, 2, "CORRENTE");
		Conta ContaUser8  = new ContaCorrente("medaumanotamaxima", 99999.0, 2, "CORRENTE");
		Conta ContaUser9  = new ContaCorrente("PODEROSAO", 99999.9, 2, "CORRENTE");
		Conta ContaUser10 = new ContaCorrente("1",1500.0, 2,"CORRENTE");
		Conta ContaUser11 = new ContaCorrente("2",1300.0, 1,"CORRENTE");
		Conta ContaUser12 = new ContaCorrente("3",2000.0, 2,"CORRENTE");

		usuario.add(user1);
		usuario.add(user2);
		usuario.add(user3);
		usuario.add(user4);
		usuario.add(user5);
		usuario.add(user6);
		usuario.add(user7);
		usuario.add(user8);
		usuario.add(user9);
		usuario.add(user10);
		usuario.add(user11);
		usuario.add(user12);

		contasBanco.add(ContaUser1);
		contasBanco.add(ContaUser2);
		contasBanco.add(ContaUser3);
		contasBanco.add(ContaUser4);
		contasBanco.add(ContaUser5);
		contasBanco.add(ContaUser6);
		contasBanco.add(ContaUser7);
		contasBanco.add(ContaUser8);
		contasBanco.add(ContaUser9);
		contasBanco.add(ContaUser10);
		contasBanco.add(ContaUser11);
		contasBanco.add(ContaUser12);

		menuLogin(contasBanco, usuario);

	}

	// Funções de autenticação

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

	private static Usuario encontrarUsuario(String cpf, List<Usuario> usuario) {
		for (Usuario contaUsuario : usuario) {
			if (contaUsuario.getCpf().equalsIgnoreCase(cpf))
				return contaUsuario;
		}

		return null;
	}

	// FIM das funções de autenticação

	// Menu principal

	public static void menuLogin(List<Conta> contasBanco, List<Usuario> usuario) throws IOException {

		// Instâncias de relatórios//

		RelatorioTributacao relatorioTributacao = new RelatorioTributacao();
		Saldo relatorioSaldo = new Saldo();
		RendimentoPoupanca relatorioPoupanca = new RendimentoPoupanca();
		RelatorioFuncionarios relatorioContas = new RelatorioFuncionarios();
		RelatorioFuncionarios relatorioUsuarios = new RelatorioFuncionarios();
		RelatorioFuncionarios relatorioCapital = new RelatorioFuncionarios();
		RelatorioOperacoes relatorio = new RelatorioOperacoes();
		Conta contaPoupanca = new ContaPoupanca();

		// FIM//

		// Variáveis importantes e Scanner//

		Scanner leitor = new Scanner(System.in);
		String cpf;
		String senha;
		Conta contaDestinatario = null;
		Usuario usuarioDestinatario = null;
		int x = 0;
		int dias;

		// FIM//

		// Início do menu LOGIN//

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

		// Validar a senha e cpf do cliente
		// ***********************************************

		if (cliente == null || contaBanco == null) {
			System.out.println("Senha ou cpf inválidos");
			menuLogin(contasBanco, usuario);
		}

		// ***********************************************

		// Filtro dos diferentes menus disponíveis.

		// Menu do cliente

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

			// FIM do menu do cliente

			// Menu do gerente

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

			// FIM do menu do gerente

			// Menu do diretor

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

			// FIM do menu do diretor

			// Menu do presidente

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

			// FIM do menu do presidente

			// FIM do filtro dos diferentes menus disponíveis.
			// FIM do programa.

			leitor.close();
		}
	}
}
