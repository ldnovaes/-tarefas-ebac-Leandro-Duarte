package juridica.br.com.duarte;

import pessoa.br.com.duarte.Pessoa;

/**
 * @author: ldnovaes
 * @created: 31/05/2023 19:17
 */

public class Juridica extends Pessoa {
    private String cnpj;
    private String cnaePrincipal = "Não Informado";

    public Juridica(String nome, String endereco, String telefone, String cnpj) {
        super(nome, endereco, telefone);
        this.cnpj = cnpj;
    }

    public Juridica(String nome, String endereco, String telefone, String cnpj, String cnaePrincipal) {
        super(nome, endereco, telefone);
        this.cnpj = cnpj;
        this.cnaePrincipal = cnaePrincipal;
    }

    public String getCnaePrincipal() {
        return this.cnaePrincipal;
    }
    public String getCnpj() {
        return this.cnpj;
    }
}
