package funcionario;

import cliente.Usuario;
import enums.PessoaEnum;

public abstract class Funcionario extends Usuario {
	
	private PessoaEnum cargo;
	
	public Funcionario() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

	public Funcionario(String nome, String cpf, String senha, String userTipo) {
		super(nome, cpf, senha, userTipo);
		this.cargo = PessoaEnum.FUNCIONARIO;
	}




	public PessoaEnum getCargo() {
		return cargo;
	}

	
	
	@Override
	public void menu() {
		
	}
}
