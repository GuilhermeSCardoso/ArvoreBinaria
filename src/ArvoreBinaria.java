
/**
 * Classe para verificar se uma Árvore Binária é de busca ou não.
 * @author Guilherme Souto Cardoso
 * @since Classe criada em: 26/06/2018
 */

class No {
    int valor;
    No esquerda, direita;
    public No(int item) {
        valor = item;
        esquerda = null;
        direita = null;
    }
}

public class ArvoreBinaria {
    No raiz;
    int menor = Integer.MIN_VALUE; //menor valor da árvore binária
    int maior = Integer.MAX_VALUE; //maior valor da árvore binária
    
    boolean verificarArvoreBinaria (No no, int menor, int maior) {
        //se o nó não possuir valor, retorna true
        if (no == null) {
            return true;
        }
        
        //se o valor do nó estiver fora do intervalo menor/maior da árvore binária
        if (no.valor < menor || no.valor > maior) {
            return false;
        }
        
        //recursão para verificar os nós filhos da árvore
        return (verificarArvoreBinaria(no.esquerda, menor, no.valor - 1) && verificarArvoreBinaria(no.direita, no.valor + 1, maior));   
    }
    
    public static void main(String [] args) {
        ArvoreBinaria ab = new ArvoreBinaria();
        ab.raiz = new No(5);
        ab.raiz.esquerda = new No(3);
        ab.raiz.direita = new No(7);
        ab.raiz.esquerda.esquerda = new No(1);
        ab.raiz.esquerda.direita = new No(4);
        ab.raiz.direita.direita = new No(10);
        
        //exemplo com sucesso
        if(ab.verificarArvoreBinaria(ab.raiz, 1, 10)) {
            System.out.println("É uma Árvore Binária de Busca!");
        } else {
            System.out.println("Não é uma Árvore Binária de Busca!");
        }
        
        ArvoreBinaria ab2 = new ArvoreBinaria();
        ab2.raiz = new No(5);
        ab2.raiz.esquerda = new No(3);
        ab2.raiz.direita = new No(7);
        ab2.raiz.esquerda.esquerda = new No(1);
        ab2.raiz.esquerda.direita = new No(6);//6 > 5(raiz) e está à direita
        ab2.raiz.direita.direita = new No(10);
        
        //exemplo sem sucesso
        if(ab.verificarArvoreBinaria(ab2.raiz, 1, 10)) {
            System.out.println("É uma Árvore Binária de Busca!");
        } else {
            System.out.println("Não é uma Árvore Binária de Busca!");
        }
    }
}
