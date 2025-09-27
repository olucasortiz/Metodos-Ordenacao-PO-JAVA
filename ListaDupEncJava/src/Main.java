public class Main {
    public static void main(String[] args) {
        Lista minhaLista = new Lista();

        minhaLista.inserirNoFinal(5);
        minhaLista.inserirNoFinal(1);
        minhaLista.inserirNoFinal(4);
        minhaLista.inserirNoFinal(2);

        System.out.println("Lista antes da ordenação:");
        minhaLista.exibir(); // Mostra: [ 5 1 4 2 ]

        // Chama o método de ordenação
        minhaLista.bubbleSortLista();

        System.out.println("\nLista depois do Bubble Sort:");
        minhaLista.exibir(); // Mostra: [ 1 2 4 5 ]
    }
}