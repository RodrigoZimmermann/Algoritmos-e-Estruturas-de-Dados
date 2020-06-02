package arvores;

public class NoArvore<T> {

    private T info;
    private NoArvore<T> filho;
    private NoArvore<T> irmao;
    private NoArvore<T> pai;

    public NoArvore<T> getPai() {
        return pai;
    }
    private static int altura = 1;
    private static int nivel = 1;

    public NoArvore(T info) {
        this.info = info;
    }

    public void setPai(NoArvore<T> pai) {
        this.pai = pai;
    }

    public T getInfo() {
        return this.info;
    }

    public void inserirFilho(NoArvore<T> no) {
        no.irmao = this.filho;
        this.filho = no;
    }

    public NoArvore<T> pertence(T info) {
        if (this.info.equals(info)) {
            return this;
        }

        NoArvore<T> retorno = null;
        if (this.filho != null) {
            retorno = filho.pertence(info);
            if (retorno != null) {
                return retorno;
            }
        }

        if (this.irmao != null) {
            retorno = irmao.pertence(info);
        }

        return retorno;
    }

    public String imprimePre() {
        // trata a raiz
        String str = "<" + this.info;

        if (this.filho != null) {
            str += filho.imprimePre();
        }
        str += ">";
        if (this.irmao != null) {
            str += irmao.imprimePre();
        }

        return str;
    }

    public NoArvore<T> getFilho() {
        return filho;
    }

    public NoArvore<T> getIrmao() {
        return irmao;
    }

    public NoArvore<T> verificaNivel(T info) {
        if (this.info.equals(info)) {
            return this;
        }

        NoArvore<T> retorno = null;
        if (this.filho != null) {
            nivel++;
            retorno = filho.verificaNivel(info);
            if (retorno != null) {
                return retorno;
            }
        }

        if (this.irmao != null) {
            retorno = irmao.verificaNivel(info);
        } else {
            nivel--;
        }

        return retorno;
    }

    public NoArvore<T> verificaAltura() {
        NoArvore<T> retorno = null;
        if (this.filho != null) {
            altura++;
            this.setPai(this.filho);
            retorno = filho.verificaAltura();
            if (retorno != null) {
                return retorno;
            }
        }

        if (this.irmao != null) {
            retorno = irmao.verificaAltura();
        } else {
            altura--;
        }

        return retorno;
    }

    public int getAltura() {
        return altura;
    }

    public int getNivel() {
        return nivel;
    }

}
