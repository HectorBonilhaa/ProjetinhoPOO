package cliente;

import enums.PessoaEnum;

public abstract class Usuario implements Comparable<Usuario> {
	private String nome;
	private String cpf;
	private String senha;
	private String tipo ; 
	private String cargo;

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(String nome, String cpf, String senha, String userTipo, String funcao) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.tipo = userTipo;
		this.cargo = funcao;
		
	}
	
	public String getCargo() {
		return this.cargo;
	}
	
	public String getTipo() {
		return this.tipo;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + ", getNome()=" + getNome()
				+ ", getCpf()=" + getCpf() + ", getSenha()=" + getSenha() + "]";
	}

	public void menu() {

	}

	@Override
	public int compareTo(Usuario usuario) {
		return this.getCpf().compareToIgnoreCase(usuario.getCpf());
	}
}
