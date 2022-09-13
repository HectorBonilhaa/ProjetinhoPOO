package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import contas.Conta;
import funcionario.Funcionario;


public class menu 
{
	static Scanner input = new Scanner(System.in);
		
	List<Conta> contas = new ArrayList<>();

	
	public static void main(String[] args)
	{
       
		int x = 0;
		Scanner leitor = new Scanner(System.in);
		String cpf;
		String senha;
		
		do 
		{
			System.out.println("**********Bem Vindo a F.E.J.H.M**********");
			System.out.println("-----------------------------------------");
			System.out.println("-----------------------------------------");
			System.out.println("------------------Login------------------");
			System.out.println("\n");
			System.out.print("CPF: ");
			cpf = leitor.next();
			System.out.print("Senha: ");
			senha = leitor.next();
			
			for(int i=0; i < contas.size() && x==0; i++)
			{		
					x = autenticar(i,cpf, senha);
			        if(x == 1)
			        	Conta contaUsuario = contas.get(i);

			}
			
			if(x == 0)
			System.out.println("Senha ou cpf inválidos");
		
		}while(x == 0); 
		
		switch(contaUsuario.getTIPOU)
		{
		
		case GERENTE.name: menuGerente();
	       					   break;
			case DIRETOR.name:  menuDiretor ();
			    		       break;
						  
			case PRESIDENTE.name: menuPresidente();
				                  break;
				                  
		    default: menuUsuario();
		    	     break;
		}
		
		
	}
	
	public int autenticar(int i, String cpf, String senha)
	{
			if(contas.get(i).getCpf.equalsIgnoreCase(cpf));
				if(contas.get(i).getSenha.equalsIgnoreCase(senha))
				{
				    System.out.println("Bem Vindo "+ contas.get(i).getNome());
				    return 1;
				}
					else
						return 0;
	}

}
