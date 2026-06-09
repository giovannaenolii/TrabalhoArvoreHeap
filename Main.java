public class Main {
    public static void main(String[] args) {
        Heap minhaHeap = new Heap();

        System.out.println("--- TESTANDO A NOSSA HEAP ---");

        // Tópico A e B: Mostrando como insere e organiza
        System.out.println("\n1. Colocando números na árvore:");
        int[] numeros = {10, 5, 20, 8, 15};

        for (int n : numeros) {
            System.out.println("Inserindo: " + n);
            minhaHeap.inserir(n);
            minhaHeap.mostrar();
        }

        // Tópico C: Principais operações

        // Testando a busca
        System.out.println("\n2. Testando a Busca:");
        int procurar = 8;
        if (minhaHeap.buscar(procurar)) {
            System.out.println("O número " + procurar + " tá na lista!");
        } else {
            System.out.println("O número " + procurar + " não foi encontrado.");
        }

        // Testando a remoção do maior
        System.out.println("\n3. Tirando o maior (o topo):");
        No removido = minhaHeap.removerMaior();
        System.out.println("Tirei o: " + removido.valor);
        minhaHeap.mostrar();

        System.out.println("\n4. Tirando o próximo maior:");
        removido = minhaHeap.removerMaior();
        System.out.println("Tirei o: " + removido.valor);
        minhaHeap.mostrar();

        System.out.println("\n--- FIM DO TESTE ---");
    }
}
