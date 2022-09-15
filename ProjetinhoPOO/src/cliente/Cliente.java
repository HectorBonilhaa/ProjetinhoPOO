package cliente;

public abstract class Cliente 
{
	private String nome;
	private String cpf;
	private String senha;
	
	
	
	public Cliente(String nome, String cpf, String senha) 
	{
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
	}
	public String getNome() 
	{
		return nome;
	}
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	public String getCpf() 
	{
		return cpf;
	}
	public void setCpf(String cpf) 
	{
		this.cpf = cpf;
	}
	public String getSenha() 
	{
		return senha;
	}
	public void setSenha(String senha) 
	{
		this.senha = senha;
	}
	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + ", getNome()=" + getNome()
				+ ", getCpf()=" + getCpf() + ", getSenha()=" + getSenha() + "]";
	}
	
	
}
