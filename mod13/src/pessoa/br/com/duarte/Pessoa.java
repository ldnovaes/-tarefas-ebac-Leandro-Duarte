package pessoa.br.com.duarte;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ldnovaes
 * @created: 31/05/2023 19:05
 */

public abstract class Pessoa {

    private static List<Pessoa> pessoas = new ArrayList<>();

    private String nome;
    private String endereco;
    private String telefone;

    public Pessoa(String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        pessoas.add(this);
    }

    public static List<Pessoa> getPessoas() {
        return pessoas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return this.nome;
    }


}
