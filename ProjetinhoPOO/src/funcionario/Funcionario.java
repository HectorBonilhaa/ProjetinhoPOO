package funcionario;

import cliente.Usuario;
import enums.PessoaEnum;

public abstract class Funcionario extends Usuario {
	
	private String cargo;
	
	public Funcionario() {
		super();
		
	}

	public String getCargo() {
		return this.cargo;
	}

	public Funcionario(String nome, String cpf, String senha) {
		super(nome, cpf, senha);
		this.cargo = "FUNCIONARIO";
	}
	
	

	
	
	@Override
	public void menu() {
		
	}
}
