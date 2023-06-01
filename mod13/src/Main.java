import fisica.br.com.duarte.Fisica;
import juridica.br.com.duarte.Juridica;
import pessoa.br.com.duarte.Pessoa;

/**
 * @author: ldnovaes
 * @created: 31/05/2023 18:37
 */

public class Main {
    public static void main(String[] args) {
        Fisica fisica = new Fisica("Leandro", "Rua C, nº 98 Bairro Não Existe", "64 9 9252-0000", "000.000.000=00", "Analista de Sistemas");
        Juridica juridica = new Juridica("Empresa X", "Rua C, nº 99 Bairro Não Existe", "64 9 9567-0000", "88.888.888/0001-00");

        System.out.println(Pessoa.getPessoas());
    }
}