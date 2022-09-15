package funcionario;

import cliente.Usuario;
import enums.PessoaEnum;

public abstract class Funcionario extends Usuario {
	
	private String cargo;
	
	public Funcionario() {
		super();
		
	}

	

<<<<<<< HEAD
	public Funcionario(String nome, String cpf, String senha, PessoaEnum userTipo) {
		super(nome, cpf, senha, userTipo);
		this.cargo = PessoaEnum.FUNCIONARIO;
	}




	public PessoaEnum getCargo() {
		return cargo;
=======
	public Funcionario(String nome, String cpf, String senha, String userTipo, String funcao) {
		super(nome, cpf, senha, userTipo, funcao);
		this.cargo = "FUNCIONARIO";
>>>>>>> afe94e3fe09ab3631e7da2c86a62d150a497e5c2
	}

	
	
	@Override
	public void menu() {
		
	}
}
