package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import contas.Conta;
import contas.ContaPoupanca;
import funcionario.Funcionario;


public class menu 
{
	static Scanner input = new Scanner(System.in);

	
	public static void main(String[] args) {
		List<Conta> contasBanco = new ArrayList<>();
		int x = 0;
		Scanner leitor = new Scanner(System.in);
		String cpf;
		String senha;
		
		Conta conta = new ContaPoupanca("dasda","123","1234",0, 5000.0,1);
		contasBanco.add(conta);
		
		
		do {
			System.out.println("**********Bem Vindo a F.E.J.H.M**********");
			System.out.println("-----------------------------------------");
			System.out.println("-----------------------------------------");
			System.out.println("------------------Login------------------");
			System.out.println("\n");
			System.out.print("CPF: ");
			cpf = leitor.next();
			System.out.print("Senha: ");
			senha = leitor.next();
			
			Conta contaUsuario = autenticar(cpf,senha, contasBanco);
			
			if(contaUsuario == null)
			System.out.println("Senha ou cpf inválidos");
		
		}while(contaUsuario == null); 
//		
//		switch(contaUsuario.getTIPOU) {
//		
//		case GERENTE.name: menuGerente();
//	       					   break;
//			case DIRETOR.name:  menuDiretor();
//			    		       break;
//						  
//			case PRESIDENTE.name: menuPresidente();
//				                  break;
//				                  
//		    default: menuUsuario();
//		    	     break;
//		}
//		
		
	}
	
	public static Conta autenticar(String cpf, String senha, List<Conta> contasUsuario) {
		for (Conta conta : contasUsuario) {
			if(conta.getCpf().equalsIgnoreCase(cpf));
				if(conta.getSenha().equalsIgnoreCase(senha)) {
					System.out.println("Bem Vindo "+ conta.getNome());
					return conta;
				}else {
					return null;
				}
		}
		return null;
		
		
	}

}
