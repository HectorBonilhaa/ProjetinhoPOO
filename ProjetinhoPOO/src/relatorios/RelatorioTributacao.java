package relatorios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import contas.Conta;
import contas.Tributos;
import cliente.Usuario;

public class RelatorioTributacao {
	
	//	RELATÓRIO TRIBUTAÇÃO //
	
	public static void pathTributacao(Usuario u, Conta conta) throws IOException {
		final String PATH_BASICO = "./temp/";
		final String EXTENSAO = ".txt";
		final String OPERACAO = "tributacaoCc";
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String path = PATH_BASICO + formatar.format(date) + "_" + OPERACAO + "_" + u.getNome() + EXTENSAO;
		escritorTributacao(path, conta, u);
	}

	public static void escritorTributacao(String path, Conta conta, Usuario u) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		String linha = "";
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		linha = "************************************************************";
		buffWrite.append(linha + "\n");
		linha = "                                    _______                          ";
		buffWrite.append(linha + "\n");
		linha = "****************Banco F.E.J.H.M****************\r\n";
		buffWrite.append(linha + "\n");
		linha = "";
		buffWrite.append(linha + "\n");
		linha = "************************************************************";
		buffWrite.append(linha + "\n");
		linha = "-----------------Tributação da Conta Corrente----------------";
		buffWrite.append("\n" + linha + "\n\n");
		linha = "Bem vindo, " + u.getNome() + "!";
		buffWrite.append(linha + "\n");
		linha = " Você teve um gasto tributário de: R$ " + conta.getTotalTributos();
		buffWrite.append(linha + "\n\n");
		linha = "-----------------------Final do relatório de Tributação-----------------------";
		buffWrite.append(linha + "\n");
		linha = "Data: " + formatar.format(date);
		buffWrite.append(linha + "\n");

		buffWrite.close();
	}
	//	FIM DO RELATÓRIO DE TRIBUTAÇÃO //
}