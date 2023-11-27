package br.com.ldnovaes;

import br.com.ldnovaes.estrutura.dados.implementacoes.PilhaDocumentos;
import br.com.ldnovaes.estrutura.dados.api.Fila;
import br.com.ldnovaes.estrutura.dados.api.ListaEncadeada;
import br.com.ldnovaes.estrutura.dados.api.TabelaHash;
import br.com.ldnovaes.estrutura.dados.models.Documento;
import java.util.Arrays;

/**
 *
 * @author ldnovaes
 */
public class Main {
    
    public static void main(String[] args) {
        constroiTabelaHash();

    }
    
    public static void constroiListaEncadeada() {
        ListaEncadeada<Integer> listaEncadeada = new ListaEncadeada<>();
        listaEncadeada.push(1);
        listaEncadeada.push(2);
        listaEncadeada.push(3);
        listaEncadeada.push(4);
        System.out.println("Lista sem modificações: " + listaEncadeada);
        listaEncadeada.insert(4, 10);
        System.out.println("Lista substituindo 4º elemento: " + listaEncadeada);
        listaEncadeada.pop();
        listaEncadeada.pop();
        System.out.println("Removendo os dois ultimos elementos: " + listaEncadeada);
        listaEncadeada.push(5);
        System.out.println("Lista após o Pop e adição do elemento 5: " + listaEncadeada);
        listaEncadeada.remove(2);
        System.out.println("Removendo o elemento 3 na posição 2: " + listaEncadeada);
        System.out.println("Buscando elemento 5: " + listaEncadeada.elementAt(2).getElemento());
        System.out.println("Tamanho da lista é: " + listaEncadeada.size());
        listaEncadeada.printList();
    }
    
    public static void constroiFila() {
        Fila<Documento> documentos = new Fila(15);
        
        Documento documento1 = new Documento("financeiro", "relatorio_financeiro.xlsx");
        Documento documento2 = new Documento("comercial", "relatorio_comercial.xlsx");
        Documento documento3 = new Documento("rh", "relatorio_rh.xlsx");
        Documento documento4 = new Documento("compras", "relatorio_compras.xlsx");
        Documento documento5 = new Documento("logistica", "relatorio_logistica.xlsx");
        
        documentos.enqueue(documento1);
        documentos.enqueue(documento2);
        documentos.enqueue(documento3);
        documentos.enqueue(documento4);
        documentos.enqueue(documento5);
        
        System.out.println("tirando primeiro: " + documentos.dequeue().getNome());
        System.out.println("tirando segundo: " + documentos.dequeue().getNome());

        System.out.println("vendo o ultimo " + documentos.rear().getNome());
        System.out.println("vendo o primeiro " + documentos.front().getNome());
        
        documentos.dequeue();
        documentos.dequeue();
        documentos.dequeue();
        System.out.println(documentos.size());
        System.out.println(documentos.isEmpty());


    }
    
    public static void constroiPilha() {
        PilhaDocumentos documentos = new PilhaDocumentos(15);
        
        Documento documento1 = new Documento("financeiro", "relatorio_financeiro.xlsx");
        Documento documento2 = new Documento("comercial", "relatorio_comercial.xlsx");
        Documento documento3 = new Documento("rh", "relatorio_rh.xlsx");
        Documento documento4 = new Documento("compras", "relatorio_compras.xlsx");
        Documento documento5 = new Documento("logistica", "relatorio_logistica.xlsx");
        
        documentos.push(documento1);
        documentos.push(documento2);
        documentos.push(documento3);
        documentos.push(documento4);
        documentos.push(documento5);
        
        System.out.println(documentos.top().getId());
        System.out.println("======================");
        
        System.out.println(documentos.pop().getId());
        System.out.println(documentos.pop().getId());
        System.out.println(documentos.pop().getId());
        System.out.println(documentos.pop().getId());
        System.out.println(documentos.pop().getId());
        //System.out.println(documentos.pop().getNome()); // erro em tempo de execução
        
        System.out.println(documentos.size());
        System.out.println(documentos.isEmpty());
    }
    
    public static void constroiTabelaHash() {
        TabelaHash<String, String> tabelaHash = new TabelaHash<>();
        tabelaHash.put("primeiro", "leandro");
        tabelaHash.put("segundo", "daphy");
        tabelaHash.put("terceiro", "joao");
        tabelaHash.put("quarto", "vini");
        tabelaHash.put("quatro", "vostoc"); // verificar colisão
        
        System.out.println("IMPRIMINDO TABELA>: " + tabelaHash);
        
        System.out.println("Ver chaves que foram colididas em posições: " + Arrays.asList(tabelaHash.getKeysColision("quarto")));
        
        // verifica se na colisão a tabela consegue buscar
        System.out.println("precisa ser vostoc: " + tabelaHash.get("quatro")); 
        System.out.println("precisa ser vini: " + tabelaHash.get("quarto"));
        
        tabelaHash.clear();
    }
}
