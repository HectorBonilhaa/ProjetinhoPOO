package relatorios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

import cliente.Usuario;
import contas.Conta;

public class RelatorioFuncionarios {

	// RELATORIO DIRETOR //

	public void informacaoClientes(Conta conta, Usuario u, List<Usuario> usuario, List<Conta> contasBanco)

			throws IOException {
		Collections.sort(usuario);
		for (int i = 0; i < usuario.size(); i++) {
			System.out.println("*****************\nNome do cliente: " + usuario.get(i).getNome() + "\nCPF do cliente: "
					+ usuario.get(i).getCpf() + "\nNúmero da agência: " + contasBanco.get(i).getAgencia()
					 + "\nNúmero da conta: " + contasBanco.get(i).getNumContas() + "\n*****************");
			System.out.println();

		}
		pathInformacaoCliente(conta, u, usuario, contasBanco);

	}

	public static void pathInformacaoCliente(Conta conta, Usuario u, List<Usuario> usuario, List<Conta> contasBanco)
			throws IOException {
		final String PATH_BASICO = "..//RelatorioInfoClientes//";
		final String EXTENSAO = ".txt";
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("yyyy_MM_HH_mm_ss");
		String path = PATH_BASICO + formatar.format(date) + "_relatorio_diretor_" + u.getNome() + EXTENSAO;
		escritorInformacaoCliente(path, conta, u, usuario, contasBanco);

	}

	public static void escritorInformacaoCliente(String path, Conta conta, Usuario u, List<Usuario> usuario,
			List<Conta> contasBanco)

			throws IOException {

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		String linha = "";
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		linha = "*************************************";
		buffWrite.append(linha + "\n");
		linha = "***********Banco F.E.J.H.M***********\r\n";
		buffWrite.append(linha + "\n");
		linha = "-Relatório: Informações dos clientes-";
		buffWrite.append("\n" + linha + "\n");
		linha = "Oi, " + u.getNome();
		buffWrite.append(linha + "\n");

		Collections.sort(usuario);
		Conta contaValidacao = null;
		for (int i = 0; i < usuario.size(); i++) {
			for (Conta contaUsuarioCheck : contasBanco) {
				if (contaUsuarioCheck.getCpf().equalsIgnoreCase(usuario.get(i).getCpf()))
					contaValidacao = contaUsuarioCheck;
			}
			linha = "************************ \nNome do cliente: " + usuario.get(i).getNome() + "\nCPF do cliente: "
					+ usuario.get(i).getCpf() + "\nNúmero da agência: " + contasBanco.get(i).getAgencia()
					+ "\nNúmero da conta: " + contaValidacao.getNumContas() + "\n************************";
			buffWrite.append("\n" + linha + "\n");
		}
		linha = "\n---------Fim do relatório---------";
		buffWrite.append(linha + "\n");
		linha = "Data: " + formatar.format(date);
		buffWrite.append(linha + "\n");

		buffWrite.close();
	}
	// FIM DO RELATÓRIO DIRETOR//

	// RELATORIO GERENTE! //

	public int totalDeContasSupervisionadas(Conta conta, Usuario usuario) throws IOException {
		int total = 0;
		if (conta.getAgencia() == 1) {
			total = Conta.getTotalAgencia1();
		} else if (conta.getAgencia() == 2) {
			total = Conta.getTotalAgencia2();
		}

		pathGerente(conta, usuario, total);
		return total;
	}

	public static void pathGerente(Conta conta, Usuario usuario, int total) throws IOException {
		final String PATH_BASICO = "..//RelatorioContaSupervisionadas//";
		final String EXTENSAO = ".txt";
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String path = PATH_BASICO + formatar.format(date) + "_relatorio_gerente_" + usuario.getNome() + EXTENSAO;
		escritorGerente(path, conta, usuario, total);
	}

	public static void escritorGerente(String path, Conta conta, Usuario u, int total) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		String linha = "";
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		linha = "*************************************";
		buffWrite.append(linha + "\n");
		linha = "***********Banco F.E.J.H.M***********\r\n";
		buffWrite.append(linha + "\n");
		linha = "**************************************";
		buffWrite.append(linha + "\n");
		linha = "------Relatório: Total de contas------";
		buffWrite.append("\n" + linha + "\n\n");
		linha = "Bem vindo, " + u.getNome() + "!";
		buffWrite.append(linha + "\n");
		linha = "Gerente: " + conta.getCpf() + "\nTotal de contas supervisionadas: " + total;
		buffWrite.append(linha + "\n\n");
		linha = "-----------Fim do relatório------------";
		buffWrite.append(linha + "\n");
		linha = "Data: " + formatar.format(date);
		buffWrite.append(linha + "\n");

		buffWrite.close();
	}
	// FIM DO RELATÓRIO //

	// RELATORIO PRESIDENTE //

	public Double totalDeCapital(Conta conta, Usuario usuario, List<Conta> contasBanco) throws IOException {
		double capitalTotal = 0;
		for (int i = 0; i < contasBanco.size(); i++) {
			capitalTotal += contasBanco.get(i).getSaldo() + contasBanco.get(i).getTotalTributos();
		}
		pathCapital(conta, usuario, capitalTotal);
		return capitalTotal;
	}

	public static void pathCapital(Conta conta, Usuario usuario, double capital) throws IOException {
		final String PATH_BASICO = "..//";
		final String EXTENSAO = ".txt";
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String path = PATH_BASICO + formatar.format(date) + "_relatorio_presidente_" + usuario.getNome() + EXTENSAO;
		escritorCapital(path, conta, usuario, capital);
	}

	public static void escritorCapital(String path, Conta conta, Usuario u, double capital) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		String linha = "";
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		linha = "*************************************";
		buffWrite.append(linha + "\n");
		linha = "***********Banco F.E.J.H.M***********\r\n";
		buffWrite.append(linha + "\n");
		linha = "*************************************";
		buffWrite.append(linha + "\n");
		linha = "-Relatório: Total de capital no banco-";
		buffWrite.append("\n" + linha + "\n\n");
		linha = "Bem Vindo, " + u.getNome() + "!";
		buffWrite.append(linha + "\n");
		linha = "O capital total no Banco F.E.J.H.M é de: R$  " + capital;
		buffWrite.append(linha + "\n\n");
		linha = "-----------Fim do relatório-----------";
		buffWrite.append(linha + "\n");
		linha = "Data: " + formatar.format(date);
		buffWrite.append(linha + "\n");

		buffWrite.close();
	}
	// FIM DO RELATÓRIO PRESIDENTE //
}
