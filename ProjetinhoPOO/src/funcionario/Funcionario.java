package funcionario;

import cliente.Usuario;
import enums.PessoaEnum;

public abstract class Funcionario extends Usuario {
	
	private String cargo;
	
	public Funcionario() {
		super();
		
	}

	

	public Funcionario(String nome, String cpf, String senha, String userTipo, String funcao) {
		super(nome, cpf, senha, userTipo, funcao);
		this.cargo = "FUNCIONARIO";
	}

	
	
	@Override
	public void menu() {
		
	}
}
