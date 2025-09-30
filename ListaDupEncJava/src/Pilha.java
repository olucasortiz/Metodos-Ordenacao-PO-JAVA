// Esta classe Pilha é projetada para armazenar objetos do tipo No.
public class Pilha {

    /**
     * Classe interna e privada. Só a Pilha precisa saber como seus "nós internos" funcionam.
     * Cada NoPilha armazena um 'dado' (que será um No da nossa Lista) e aponta para o próximo.
     */
    private static class NoPilha {
        private No dado; // O dado que estamos guardando é um No da sua classe Lista
        private NoPilha prox;

        public NoPilha(No dado) {
            this.dado = dado;
            this.prox = null;
        }
    }

    // A Pilha só precisa saber quem está no topo.
    private NoPilha topo;

    // Construtor: uma nova pilha começa vazia.
    public Pilha() {
        this.topo = null;
    }


    public void push(No no) {
        NoPilha novoNoPilha = new NoPilha(no);
        novoNoPilha.prox = this.topo; // O novo nó aponta para o antigo topo
        this.topo = novoNoPilha;      // O novo nó se torna o novo topo
    }

    public No pop() {
        if (isEmpty()) {
            return null; // Ou lançar uma exceção, mas null é mais simples aqui.
        }
        No noDoTopo = this.topo.dado; // Guarda o dado que vamos retornar
        this.topo = this.topo.prox;   // O topo agora é o próximo da fila
        return noDoTopo;
    }

    /**
     * Verifica se a pilha está vazia.
     * @return true se a pilha estiver vazia.
     */
    public boolean isEmpty() {
        return this.topo == null;
    }
}