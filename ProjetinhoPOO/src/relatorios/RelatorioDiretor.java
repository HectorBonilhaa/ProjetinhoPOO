package relatorios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

import cliente.Usuario;
import contas.Conta;

public class RelatorioDiretor {
	
	public static void informacaoClientes(Conta conta, Usuario u, List<Usuario> 
				usuario, List<Conta> contasBanco)
			
		throws IOException {
		Collections.sort(usuario);
		for (int i=0; i < usuario.size(); i++) {
			System.out.println("*****************\nNome do cliente: " 
					+ usuario.get(i).getNome() + "\nCPF do cliente: "
					+ usuario.get(i).getCpf() + "\nNumero da agência: " 
					+ contasBanco.get(i).getAgencia() + "\n*****************");
			System.out.println();
		}
		
		PathInformacaoUsuario(conta, u, usuario, contasBanco);
				
		}
	
	private static void PathInformacaoUsuario(Conta conta, Usuario u, List<Usuario> listaUsuario,
			List<Conta> listaConta) {
		// TODO Auto-generated method stub
		
	}

	public static void pathInformacaoCliente(Conta conta, Usuario u, List<Usuario>
			usuario, List<Conta> contasBanco)
					throws IOException {
		final String PATH_BASICO = "./temp/";
		final String EXTENSAO = ".txt";
		Date date = new Date(0);
		SimpleDateFormat formatar = new SimpleDateFormat("yyyy_MM_HH_mm_ss");
		String path = PATH_BASICO + formatar.format(date) + "_relatorio_diretor_"
				+ u.getNome() + EXTENSAO;
		escritorInformacaoCliente(path, conta, null, null, contasBanco);;
							
	}
	
	public static void escritorInformacaoCliente(String path, Conta conta, Usuario u,
			List<Usuario> usuario, List<Conta> contasBanco)
	
					throws IOException {
		
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		String linha = "";
		Date date = new Date(0);
		SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		linha = "***************************************************";
		buffWrite.append(linha + "\n");
		linha = "*****Banco F.E.J.H.M*****";
		buffWrite.append(linha + "\n");
		buffWrite.append(linha + "\n");
		linha = "--------Relatório: Informações dos clientes--------";
		buffWrite.append("\n"+ linha + "\n");
		linha = "Oi, " + u.getNome();
		buffWrite.append(linha + "\n");
			
		
		Collections.sort(usuario);
		for (int i = 0; i < usuario.size(); i++) {
			linha = "************************ \nNome do cliente: " 
					+ usuario.get(i).getNome() + "\nCPF do cliente: "
					+ usuario.get(i).getCpf() + "\nNúmero da agência: " 
					+ contasBanco.get(i).getAgencia() + "\nNúmero da conta: "
					+ contasBanco.get(i).getNumContas()					 
					+ "\n************************";
			buffWrite.append("\n" + linha + "\n");
		}
			linha = "\n--------Fim do relatório--------";
			buffWrite.append(linha + "\n");
			linha = "Data: " + formatar.format(date);
			buffWrite.append(linha + "\n");
			linha = " Estamos a ordem! ";
			buffWrite.append(linha + "\n");


		buffWrite.close();
	}
				
}



