package funcionario;

import java.util.Scanner;

import contas.Conta;

public class Gerente extends Funcionario
{
	protected String cargo = "GERENTE";
	private String agencia;
	
	public Gerente(String nome, String cpf, String senha) 
	{
	super(nome, cpf, senha);
	}

	public Gerente(String nome, String cpf, String senha, String funcao, String idAgencia) 
	{
		super(nome, cpf, senha);
		this.cargo = funcao;
		this.agencia = idAgencia;
	}


	public String getCargo() 
	{
		return cargo;
	}


	public void setCargo(String cargo) 
	{
		this.cargo = cargo;
	}


	@Override
	public String toString() 
	{
		return "Funcionario nome : " +getNome() +
			   "\n          Cargo: " +  cargo + 
			   "\n          CPF  : " + getCpf() + 
			   "\n          senha: " + getSenha() + "\n\n";
	}
	
	public static void menuGerente(Conta contaUsuario) {
		
		
		Scanner leitor = new Scanner(System.in);
		int opcao = 0;
		int x = 0;
		
		do {
			
			System.out.println("**********Bem Vindo " + contaUsuario.getNome() + "**********");
			System.out.println("-----------------------------------------");
			System.out.println("-----------------------------------------");
			System.out.println("------------------MENU------------------");
			System.out.println(" Movimentações na Conta  ");
			System.out.println("1- Sacar");
			System.out.println("2- Depósitar");
			System.out.println("3- Transferir");
			System.out.println("\n");
						
			System.out.println(" Relatórios ");
			System.out.println("4- Saldo ");
			System.out.println("5- Relatório de tributação da conta corrente");
			System.out.println("6- Relatório de Rendimento da poupança ");
			System.out.println("7- Relatório do número contas ");
			System.out.println("\n");
			System.out.println("     8- Sair   ");
			
			System.out.println("\n");
			opcao = leitor.nextInt();
			
			switch(opcao)
			{
			case 1: 
			       break;
			    		  
			case 2: 
				   break;
						  
			case 3: 
				   break;
				                
			case 4: 
         	   break;
         					
			case 5: 
				   break;	
								
			case 6: 
			       break;
			  
			case 7: 
	                break;
	                
			case 8: 
					break;					
					                  
			    default:
			    	     break;
			}
		} while (x==0);
	}	
	
	
}
