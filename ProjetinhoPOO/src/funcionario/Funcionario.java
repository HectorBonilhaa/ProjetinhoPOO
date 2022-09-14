package funcionario;

import cliente.Usuario;

public abstract class Funcionario extends Usuario {
	
	private String cargo;
	
	public Funcionario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Funcionario(String nome, String cpf, String senha) {
		super(nome, cpf, senha);
		
	}
	

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	
}
