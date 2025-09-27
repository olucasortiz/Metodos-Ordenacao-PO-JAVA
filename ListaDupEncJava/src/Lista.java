public class Lista {
    private No inicio;
    private No fim;

    public Lista() {

    }

    public void inicializa() {
        this.inicio = null;
        this.fim = null;
    }

    public void inserirNoInicio(int info) {
        No novo = new No(info);
        if (inicio == null) {
            inicio = novo;
            fim = novo;
        } else {
            inicio.setProx(inicio);
            inicio.setAnt(novo);
            inicio = novo;
        }
    }

    public void inserirNoFinal(int info) {
        No novo = new No(info);
        if (fim == null) {
            fim = novo;
            inicio = novo;
        } else {
            novo.setAnt(fim);
            fim.setProx(novo);
            fim = novo;

        }
    }

    public void exibir() {
        No novo = inicio;
        while (novo != null) {
            System.out.println(novo.getInfo());
            novo = novo.getProx();
        }
    }

    public No buscaExaustiva(int info) {
        No aux = inicio;
        if (aux != null && aux.getInfo() != info)
            aux = aux.getProx();
        return aux;
    }

    public void bubbleSortLista(){
        int aux;
        boolean troca = true;
        while(troca){
            troca = false;
            No atual = inicio;
            while(atual.getProx() != null){
                if(atual.getInfo() > atual.getProx().getInfo()){
                    aux = atual.getInfo();
                    atual.setInfo(atual.getProx().getInfo());
                    atual.getProx().setInfo(aux);
                    troca = true;
                }
                atual = atual.getProx();
            }
        }
    }

    public void insertionSort(int[] vet){
        int aux,i=0;
        int menor;
        int TL=vet.length;
        boolean troca = true;
        while(troca && i<TL){
            menor = 0;
            troca = false;
            for(int j=0; j<TL;j++){
                if(vet[j] < menor)
                    menor = vet[j];
            }
            i++;
        }
    }
}