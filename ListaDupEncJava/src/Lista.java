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

    public void selectionSort(int[] vet){
        int TL = vet.length;
        int menor,aux;

        for(int i=0; i<TL-1;i++){
            menor = i;
            for(int j=i+1;j<TL;j++){
                if(vet[j]<vet[menor]){
                    menor = j;
                }
            }
            aux = vet[i];
            vet[i] = vet[menor];
            vet[menor] = aux;
        }
    }

    public void selectionSortLista(No atual){
        int menor;
        No aux;
        while(atual.getProx() != null){
            menor = atual.getProx().getInfo();

        }
    }


}