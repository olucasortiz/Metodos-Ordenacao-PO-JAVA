public class No {

    private No ant;
    private int info;
    private No prox;

    public No(int info) {
        this.info = info;
        this.ant = null;
        this.prox = null;
    }

    public No getAnt() {
        return ant;
    }

    public No getProx() {
        return prox;
    }

    public int getInfo() {
        return info;
    }

    public void setAnt(No ant) {
        this.ant = ant;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }

    public void setInfo(int info) {
        this.info = info;
    }
}