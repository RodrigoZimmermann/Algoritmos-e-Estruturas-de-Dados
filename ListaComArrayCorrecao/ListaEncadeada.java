package ListaComArrayCorrecao;

public class ListaEncadeada<T> implements Lista<T> {

    private ItemLista<T> primeiro; // = null
    private ItemLista<T> ultimo; // = null
    private int qtdeElementos; // = 0

    @Override
    public void insere(T valor) {
        ItemLista<T> novo = new ItemLista<>();
        novo.setInfo(valor);
        if (this.estaVazia()) {
            primeiro = novo;
        } else {
            ultimo.setProx(novo);
        }
        ultimo = novo;
        qtdeElementos++;
    }

    @Override
    public void insere(T valor, int posicao) {
        if (posicao < 0 || posicao > qtdeElementos) {
            throw new ListaException("Posi��o inv�lida");
        }
        if (posicao == qtdeElementos || this.estaVazia()) { // �ltima posi��o
            this.insere(valor);
        } else {
            ItemLista<T> novo = new ItemLista<>();
            novo.setInfo(valor);
            if (posicao == 0) { // primeira posi��o
                novo.setProx(primeiro);
                primeiro = novo;
            } else { // posi��o intermedi�ria
                ItemLista<T> anterior = this.descobre(posicao - 1);
                novo.setProx(anterior.getProx());
                anterior.setProx(novo);
            }
            qtdeElementos++;
        }
    }

    @Override
    public int localiza(T valor) {
        ItemLista<T> atual = primeiro;
        int contador = 0;
        while (atual != null) {
            if (valor.equals(atual.getInfo())) {
                return contador;
            }
            atual = atual.getProx();
            contador++;
        }
        return -1;
    }

    @Override
    public T retira(int posicao) {
        if (posicao < 0 || posicao > qtdeElementos) {
            throw new ListaException("Posi��o inv�lida");
        }
        T retorno = null;
        if (posicao == 0) { // primeira posi��o
            retorno = primeiro.getInfo();
            primeiro = primeiro.getProx();
            if (primeiro == null) {
                ultimo = null;
            }
        } else {
            ItemLista<T> anterior = this.descobre(posicao - 1);
            if (posicao == qtdeElementos - 1) { // �ltima posi��o
                retorno = ultimo.getInfo();
                ultimo = anterior;
                ultimo.setProx(null);
            } else { // posi��o intermedi�ria
                ItemLista<T> atual = anterior.getProx();
                retorno = atual.getInfo();
                anterior.setProx(atual.getProx());
            }
        }
        qtdeElementos--;
        return retorno;
    }

    @Override
    public String imprime() {
        StringBuilder resultado = new StringBuilder();
        ItemLista atual = primeiro;
        while (atual != null) {
            resultado.append(atual.getInfo());
            atual = atual.getProx();
            if (atual != null) {
                resultado.append(", ");
            }
        }
        return resultado.toString();
    }

    @Override
    public T busca(int posicao) {
        if (posicao < 0 || posicao >= qtdeElementos) {
            throw new ListaException("Posi��o inv�lida");
        }
        return this.descobre(posicao).getInfo();
    }

    @Override
    public boolean estaVazia() {
        return (primeiro == null);
    }

    @Override
    public int getQuantidade() {
        return this.qtdeElementos;
    }

    @Override
    public Lista<T> concatena(Lista<T> outra) {
        ListaEncadeada<T> nova = new ListaEncadeada<>();
        // n�o � a maneira mais otimizada
        for (int i = 0; i < this.getQuantidade(); i++) {
            nova.insere(this.busca(i));
        }
        // � importante o formato abaixo para garantir a opera��o independente do tipo de Lista (ComArray ou Encadeada)
        for (int i = 0; i < outra.getQuantidade(); i++) {
            nova.insere(outra.busca(i));
        }
        return nova;
    }

    @Override
    public Lista<T> divide() {
        if (this.estaVazia()) {
            return null;
        }
        ListaEncadeada<T> nova = new ListaEncadeada<>();
        int meio = (this.getQuantidade() / 2);
        if (meio == 0) {
            return nova; // s� h� um elemento na lista original, portanto n�o d� para dividir
        }
        ItemLista<T> itemAntMeio = this.descobre(meio - 1);
        nova.setPrimeiro(itemAntMeio.getProx());
        itemAntMeio.setProx(null);
        nova.setUltimo(this.ultimo);
        nova.setQuantidade(this.getQuantidade() - meio);
        this.ultimo = itemAntMeio;
        this.qtdeElementos = meio;

        return nova;
    }

    @Override
    public Lista<T> copia() {
        ListaEncadeada<T> nova = new ListaEncadeada<>();
        ItemLista<T> atual = this.primeiro;
        while (atual != null) {
            nova.insere(atual.getInfo());
            atual = atual.getProx();
        }
        return nova;
    }

    private void setPrimeiro(ItemLista<T> i) {
        this.primeiro = i;
    }

    private void setUltimo(ItemLista<T> i) {
        this.ultimo = i;
    }

    private void setQuantidade(int tam) {
        this.qtdeElementos = tam;
    }

    private ItemLista<T> descobre(int posicao) {
        ItemLista<T> atual = primeiro;
        int contador = 0;
        while (atual != null) {
            if (contador == posicao) {
                return atual;
            }
            /*
			 * ItemLista temp = atual.getProx(); atual = temp;
             */
            atual = atual.getProx();
            contador++;
        }
        return null;
    }

}
