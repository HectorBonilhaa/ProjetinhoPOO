package funcionario;

import cliente.Cliente;

public class Presidente extends Cliente
{

    private String cargo = "PRESIDENTE";

        public  Presidente(String nome, String cpf, String senha, String funcao) {
            super(nome, cpf, senha);

            cargo = funcao;

    }

        public Presidente(String nome, String cpf, String senha) {

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
            return "Presidente [getNome()=" + getNome() + ", getCargo()=" + getCargo() + ", getCpf()=" + getCpf()
                    + ", getSenha()=" + getSenha() + "]";
        }



}
