
/**
 *
 * @author Rodrigo Lu�s Zimmermann
 */
public class PilhaVetor<T> implements Pilha<T> {

    private int n = 0;
    private T[] vet;

    //Construtores
    public PilhaVetor() {
        vet = (T[]) new Object[1];
    }

    //M�todos
    @Override
    public void push(T valor) throws Exception {
        if (n == vet.length) {
            expande();
        }
        vet[n] = valor;
        n++;
    }

    private void expande() {
        T[] novoVetor = (T[]) new Object[vet.length + 1];  //aumenta 1
        for (int i = 0; i < vet.length; i++) {
            novoVetor[i] = vet[i];
        }
        vet = novoVetor;
    }

    @Override
    public T pop() throws Exception {
        if (this.vazia()) {
            throw new ListaException("N�o h� nada na pilha para remover");
        } else {
            T retorno = vet[n - 1];
            vet[n - 1] = null;
            n--;
            return retorno;
        }
    }

    @Override
    public T peek() {
        T retorno = null;
        if (this.vazia()) {
            retorno = (T) "Pilha Vazia";
        } else {
                retorno = vet[n-1];
        }
        return retorno;
    }

    @Override
    public boolean vazia() {
        return n == 0;
    }

    @Override
    public void libera() {
        if (this.vazia()) {
            throw new ListaException("N�o h� nada na pilha para liberar");
        } else {
            vet[n - 1] = null;
            n--;
        }
    }

}
