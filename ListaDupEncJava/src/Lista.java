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

    private void trocarInfo(No no1, No no2) {
        if (no1 != no2) {
            int auxInfo = no1.getInfo(); // [cite: 86]
            no1.setInfo(no2.getInfo()); // [cite: 87]
            no2.setInfo(auxInfo); // [cite: 87]
        }
    }

    public void quickSortIterativoLista() {
        if (inicio == null || inicio == fim) {
            return;
        }

        Pilha pilha = new Pilha();

        pilha.push(fim);
        pilha.push(inicio);

        while (!pilha.isEmpty()) {
            No noInicio = pilha.pop();
            No noFim = pilha.pop();

            if (noInicio == null || noFim == null || noInicio == noFim || noInicio == noFim.getProx()) {
                continue;
            }

            No i = noInicio;
            No j = noFim;
            boolean flag = true;

            while (i != j) {
                if (flag) {
                    while (i != j && i.getInfo() <= j.getInfo()) {
                        i = i.getProx();
                    }
                } else {
                    while (i != j && j.getInfo() >= i.getInfo()) {
                        j = j.getAnt();
                    }
                }
                trocarInfo(i, j);
                flag = !flag;
            }

            if (noInicio != j && j.getAnt() != null && noInicio != j.getAnt()) {
                pilha.push(j.getAnt());
                pilha.push(noInicio);
            }

            if (noFim != i && i.getProx() != null && i.getProx() != noFim) {
                pilha.push(noFim);
                pilha.push(i.getProx());
            }
        }
    }
    public void quickSortIterativoComPivoLista() {
        Pilha pilha = new Pilha();

        pilha.push(fim);
        pilha.push(inicio);

        while (!pilha.isEmpty()) {
            No noInicio = pilha.pop();
            No noFim = pilha.pop();


            No i = noInicio;
            No j = noFim;

            No pivo = getMeio(noInicio, noFim);

            while (i != null && j != null && i != j && i.getAnt() != j) {
                while (i != null && i.getInfo() < pivo.getInfo()) {
                    i = i.getProx();
                }
                while (j != null && j.getInfo() > pivo.getInfo()) {
                    j = j.getAnt();
                }

                if (i != null && j != null && i.getAnt() != j && i != j) {
                    trocarInfo(i, j);
                    i = i.getProx();
                    j = j.getAnt();
                }
            }

            // vai empilhar sublista da esquerda
            if (noInicio != null && j != null && noInicio != j && noInicio != j.getProx()) {
                pilha.push(j);
                pilha.push(noInicio);
            }

            // vai empilhar sublista da direita
            if (i != null && noFim != null && i != noFim && i.getAnt() != noFim) {
                pilha.push(noFim);
                pilha.push(i);
            }
        }
    }

    // encontra o nó do meio entre ini e fim
    private No getMeio(No ini, No fim) {
        if (ini == null || fim == null) return null;
        No lento = ini;
        No rapido = ini;

        while (rapido != fim && rapido.getProx() != fim) {
            rapido = rapido.getProx().getProx();
            lento = lento.getProx();
        }
        return lento;
    }

    public No getNo(int pos) {
        No aux = inicio;

        for (int i = 0; aux != null && i < pos; i++) {
            aux = aux.getProx();
        }

        return aux;
    }

    private int posicaoNo(No fim) {
        No aux = inicio;
        int i = 0;
        while (aux != null && aux != fim) {
            i++;
            aux = aux.getProx();
        }
        return i;
    }

    public void shellSort() {
        int i, j, gap = 1, aux;
        int tl = posicaoNo(fim) + 1; // tamanho lógico da lista

        // calcula maior intervalo da sequência de Knuth
        while (gap < tl)
            gap = gap * 3 + 1;
        gap = gap / 3;

        while (gap > 0) {
            for (i = gap; i < tl; i++) {
                aux = getNo(i).getInfo();
                j = i;

                // inserção com gap
                while (j - gap >= 0 && aux < getNo(j - gap).getInfo()) {
                    getNo(j).setInfo(getNo(j - gap).getInfo());
                    j = j - gap;
                }
                getNo(j).setInfo(aux);
            }
            gap = gap / 3; // reduz gap
        }
    }






}