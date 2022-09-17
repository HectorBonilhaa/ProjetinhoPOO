package relatorios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import contas.Conta;
import contas.Tributos;
import cliente.Usuario;

public class RelatorioOperacoes implements Tributos {

	// RELATÓRIO DEPOSITO //

	public void pathDeposito(Conta conta, double valor, Usuario usuario) throws IOException {
		final String PATH_BASICO = "..//RelatorioDeposito//";
		final String EXTENSAO = ".txt";
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String path = PATH_BASICO + formatar.format(date) + "_deposito_" + usuario.getNome() + EXTENSAO;
		escritorDeposito(path, conta, usuario, valor);
	}

	public void escritorDeposito(String path, Conta conta, Usuario u, double valor) throws IOException {
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
		linha = "--------Relatório de depósito--------";
		buffWrite.append("\n" + linha + "\n\n");
		linha = "Bem vindo, " + u.getNome() + "!";
		buffWrite.append(linha + "\n");
		linha = "Agência: " + conta.getAgencia() + "\nValor depositado: R$ " + valor 
				+ "\nSaldo: R$ " + conta.getSaldo() + "\nValor da tarifa por depósito: " 
				+ deposito;
		buffWrite.append(linha + "\n\n");
		linha = "----------Fim do relatório----------";
		buffWrite.append(linha + "\n");
		linha = "Data: " + formatar.format(date);
		buffWrite.append(linha + "\n");

		buffWrite.close();
	}
	// FIM DO RELATÓRIO DE DEPÓSITO //

	// RELATÓRIO SAQUE //

	public void pathSaque(Conta conta, Usuario usuario, double valor) throws IOException {
		final String PATH_BASICO = "..//RelatorioSaque//";
		final String EXTENSAO = ".txt";
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String path = PATH_BASICO + formatar.format(date) + "_saque_" + usuario.getNome() + EXTENSAO;
		escritorSaque(path, conta, usuario, valor);
	}

	public void escritorSaque(String path, Conta conta, Usuario u, double valor) throws IOException {
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
		linha = "----------Relatório de saque----------";
		buffWrite.append("\n" + linha + "\n\n");
		linha = "Bem vindo " + u.getNome() + "!";
		buffWrite.append(linha + "\n");
		linha = "Agência: " + conta.getAgencia() + "\nValor sacado: R$ " + valor 
				+ "\nSaldo: R$ " + conta.getSaldo() + "\nValor da tarifa por saque: R$ " 
				+ saque;
		buffWrite.append(linha + "\n\n");
		linha = "-----------Fim do relatório------------";
		buffWrite.append(linha + "\n");
		linha = "Data: " + formatar.format(date);
		buffWrite.append(linha + "\n");

		buffWrite.close();
	}
	// FIM DO RELATÓRIO SAQUE //

	// RELATÓRIO TRANSFERÊNCIA //

	public void pathTransferencia(Conta conta, double valor, Usuario usuario, Usuario destinatario)
			throws IOException {
		final String PATH_BASICO = "..//RelatorioTransferencia//";
		final String EXTENSAO = ".txt";
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String path = PATH_BASICO + formatar.format(date) + "_transferencia_" + usuario.getNome() + EXTENSAO;
		escritorTransferencia(path, conta, usuario, valor, destinatario);
	}

	public void escritorTransferencia(String path, Conta conta, Usuario u, double valor, Usuario destinatario)
			throws IOException {
				
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
		linha = "-----Relatório de Transferência------";
		buffWrite.append("\n" + linha + "\n\n");
		linha = "Bem vindo, " + u.getNome() + "!";
		buffWrite.append(linha + "\n");
		linha = "Agência: " + conta.getAgencia() + "\nValor transferido: R$ " + valor 
				+ "\nValor da tarifa por transferência: R$ " + transferencia + "\nNome do destinatário: "
				+ destinatario.getNome() + "\nCPF do destinatário: " + destinatario.getCpf() + "\n\nSaldo atual: R$ "
				+ conta.getSaldo() ;
		buffWrite.append(linha + "\n\n");
		linha = "----------Fim do relatório----------";
		buffWrite.append(linha + "\n");
		linha = "Data: " + formatar.format(date);
		buffWrite.append(linha + "\n");
		

		buffWrite.close();
	}
	//	FIM DO RELATÓRIO TRANSFERÊNCIA //
	
}
