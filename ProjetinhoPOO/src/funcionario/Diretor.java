package funcionario;

import cliente.Cliente;

public class Diretor extends Cliente
{
    private String cargo = "PRESIDENTE";

        public  Diretor(String nome, String cpf, String senha, String funcao) {
            super(nome, cpf, senha);

            cargo = funcao;
    }

        public Diretor(String nome, String cpf, String senha) {

            super(nome, cpf, senha);
        }

        public String getCargo() {
            return cargo;
        }

        public void setCargo(String cargo) {
            this.cargo = cargo;
        }

        @Override
        public String toString() {
            return "Diretor [getCargo()=" + getCargo() + ", getNome()=" + getNome() + ", getCpf()=" + getCpf()
                    + ", getSenha()=" + getSenha() + ", toString()=" + super.toString() + "]";
        }

}
