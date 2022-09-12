package funcionario;

public class Gerente extends Funcionario
{
	protected String cargo = "GERENTE";
	
	
	public Gerente(String nome, String cpf, String senha) 
	{
		super(nome, cpf, senha);
	}


	public Gerente(String nome, String cpf, String senha, String cargo) 
	{
		super(nome, cpf, senha, cargo);
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
	
	

	
}
