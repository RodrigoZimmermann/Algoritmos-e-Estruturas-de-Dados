package arvores;

import javax.print.attribute.standard.MediaSize;

public class Arvore<T> {

    private NoArvore<T> raiz = null;
    private int altura;

    //Construtor
    public Arvore() {
    }

    //Metodos
    public void setRaiz(NoArvore<T> no) {
        this.raiz = no;
    }

    public NoArvore<T> getRaiz() {
        return this.raiz;
    }

    public boolean vazia() {
        return raiz == null;
    }

    public NoArvore<T> pertence(T info) {
        if (this.vazia()) {
            return null;
        } else {
            return raiz.pertence(info);
        }
    }

    @Override
    public String toString() {
        if (this.vazia()) {
            return "";
        } else {
            return raiz.imprimePre();
        }
    }

    public int getAltura() {
        if (this.vazia()) {
            return -1;
        }
        if (this.raiz.getFilho() == null) {
            return 0;
        }
        NoArvore novo = new NoArvore(this);
        novo = getRaiz();
        NoArvore<T> retorno = null;
        retorno = novo.getFilho().verificaAltura();
        retorno = retorno.getPai();
        return novo.getAltura();
    }

    public int getNivel(T info) {
        if (this.vazia()) {
            return -1;
        }
        if (this.raiz.getInfo().equals(info)) {
            return 0;
        }

        NoArvore novo = new NoArvore(this);
        novo = getRaiz();
        NoArvore<T> retorno = null;
        if (novo.getFilho() != null) {
            retorno = novo.getFilho().verificaNivel(info);
            if (retorno != null) {
                return retorno.getNivel();
            }
        }
        return -1;
    }

}
