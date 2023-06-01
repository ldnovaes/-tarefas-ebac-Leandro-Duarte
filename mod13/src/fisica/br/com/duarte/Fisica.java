package fisica.br.com.duarte;

import pessoa.br.com.duarte.Pessoa;

/**
 * @author: ldnovaes
 * @created: 31/05/2023 19:14
 */

public class Fisica extends Pessoa {

    private String cpf;
    private String trabalho = "Não Informado";

    public Fisica(String nome, String endereco, String telefone, String cpf) {
        super(nome, endereco, telefone);
        this.cpf = cpf;
    }

    public Fisica(String nome, String endereco, String telefone, String cpf, String trabalho) {
        super(nome, endereco, telefone);
        this.cpf = cpf;
        this.trabalho = trabalho;
    }

    public String getTrabalho() {
        return this.trabalho;
    }

    public String getCpf() {
        return this.cpf;
    }
}
