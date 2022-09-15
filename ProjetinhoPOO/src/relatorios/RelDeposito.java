package relatorios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import contas.Conta;
import cliente.Usuario;

public class RelDeposito {

	public static void pathDeposito(Conta conta, double valor, Usuario pessoa) throws IOException {
		final String PATH_BASICO = "./temp/";
		final String EXTENSAO = ".txt";
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String path = PATH_BASICO + formatar.format(date) + "_deposito_" + pessoa.getNome() + EXTENSAO;
		escritorDeposito(path, conta, pessoa, valor);
	}

	public static void escritorDeposito(String path, Conta conta, Usuario usuario, double valor) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		String linha = "";
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		linha = "************************************************************";
		buffWrite.append(linha + "\n");
		linha = "                                    _______                          ";
		buffWrite.append(linha + "\n");
		linha = "                                                   ";
		buffWrite.append(linha + "\n");
		linha = "";
		buffWrite.append(linha + "\n");
		linha = "************************************************************";
		buffWrite.append(linha + "\n");
		linha = "-----------------------Relatório de deposito----------------------";
		buffWrite.append("\n" + linha + "\n\n");
		linha = "Olá, " + usuario.getNome() + "!";
		buffWrite.append(linha + "\n");
		linha = "Agencia: " + conta.getAgencia() + "\nValor depositado: R$ " + valor + "\nSaldo: R$ " + conta.getSaldo();
		buffWrite.append(linha + "\n\n");
		linha = "-------------------------Fim do relatório--------------------------";
		buffWrite.append(linha + "\n");
		linha = "Data: " + formatar.format(date);
		buffWrite.append(linha + "\n");
		linha = "_________________Volte Sempre!________________";
		buffWrite.append(linha + "\n");

		buffWrite.close();
	}
}
