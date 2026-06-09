import java.util.ArrayList;

public class Heap {
    // Lista que guarda os nossos nós
    private ArrayList<No> lista;

    public Heap() {
        this.lista = new ArrayList<>();
    }

    // Método para colocar um novo número na Heap
    public void inserir(int valor) {
        No novoNo = new No(valor);
        lista.add(novoNo); // Coloca no final
        subir(lista.size() - 1); // Faz ele subir para o lugar certo
    }

    // Método para tirar o maior número (que sempre tá no topo/raiz)
    public No removerMaior() {
        if (lista.isEmpty()) return null;

        No maior = lista.get(0); // O primeiro é sempre o maior
        No ultimo = lista.remove(lista.size() - 1); // Pega o último

        if (!lista.isEmpty()) {
            lista.set(0, ultimo); // Coloca o último lá no topo
            descer(0); // Faz ele descer para o lugar certo
        }
        return maior;
    }

    // Método simples para procurar se um número existe
    public boolean buscar(int valor) {
        for (No n : lista) {
            if (n.valor == valor) return true;
        }
        return false;
    }

    // Faz o nó subir se ele for maior que o pai dele
    private void subir(int indice) {
        int pai = (indice - 1) / 2;

        if (indice > 0 && lista.get(indice).valor > lista.get(pai).valor) {
            trocar(indice, pai);
            subir(pai); // Continua subindo se precisar
        }
    }

    // Faz o nó descer se ele for menor que os filhos
    private void descer(int indice) {
        int maior = indice;
        int esquerda = 2 * indice + 1;
        int direita = 2 * indice + 2;

        // Vê se o filho da esquerda é maior
        if (esquerda < lista.size() && lista.get(esquerda).valor > lista.get(maior).valor) {
            maior = esquerda;
        }

        // Vê se o filho da direita é maior
        if (direita < lista.size() && lista.get(direita).valor > lista.get(maior).valor) {
            maior = direita;
        }

        // Se um dos filhos for maior, troca e continua descendo
        if (maior != indice) {
            trocar(indice, maior);
            descer(maior);
        }
    }

    // Função auxiliar só para trocar dois nós de lugar
    private void trocar(int i, int j) {
        No temp = lista.get(i);
        lista.set(i, lista.get(j));
        lista.set(j, temp);
    }

    // Mostra como a Heap tá agora
    public void mostrar() {
        System.out.println("Estado atual da Heap: " + lista);
    }
}
