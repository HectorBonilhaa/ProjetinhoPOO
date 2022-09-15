package relatorios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import contas.Conta;
import cliente.Usuario;

public class Saldo {

	public static void pathsaldo(Usuario u, Conta conta) throws IOException {
		final String PATH_BASICO = "./temp/";
		final String EXTENSAO = ".txt";
		final String OPERACAO = "saldo";
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String path = PATH_BASICO + formatar.format(date) + "_" + OPERACAO +"_" + u.getNome() 
		+ EXTENSAO;
		escritorSaldo(path, conta, u);	
	}
	
	public static void escritorSaldo(String path, Conta conta, Usuario u) throws IOException {
		Date date = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		String linha = "";
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
		linha = "---------------------------------Saldo-------------------------------";
		buffWrite.append("\n" + linha + "\n\n");
		linha = "bem vindo, " + u.getNome() + "!";
		buffWrite.append(linha + "\n");
		linha = "Saldo atual: R$ " + conta.getSaldo();
		buffWrite.append(linha + "\n\n");
		linha = "---------------------------Fim do saldo---------------------------"; 
		buffWrite.append(linha + "\n");
		linha = "Data: " + formatar.format(date);
		buffWrite.append(linha + "\n");
		

		buffWrite.close();
	}
	
}

