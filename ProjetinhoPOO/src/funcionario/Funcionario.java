package funcionario;

import cliente.Cliente;

public abstract class Funcionario extends Cliente 
{
	protected String cargo;
		
	public Funcionario(String nome, String cpf, String senha) 
	{
		super(nome, cpf, senha);
	}

	public Funcionario(String nome, String cpf, String senha, String cargo) 
	{
		super(nome, cpf, senha);
		this.cargo = cargo;
	}

	public String getCargo() 
	{
		return cargo;
	}

	public void setCargo(String cargo) 
	{
		this.cargo = cargo;
	}
	
	
		
}
