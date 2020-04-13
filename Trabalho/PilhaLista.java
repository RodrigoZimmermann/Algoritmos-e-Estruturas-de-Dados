
/**
 *
 * @author Rodrigo Luís Zimmermann
 */
public class PilhaLista<T> implements Pilha<T> {

    private ElementoLista<T> topo;

    @Override
    public void push(T valor) throws Exception {
        ElementoLista<T> novo = new ElementoLista<>();
        if (this.vazia()) {
            topo = new ElementoLista<>();
            topo.setInfo(valor);
        } else {
            novo.setInfo(valor);
            novo.setProx(topo);
            topo = novo;
        }
    }

//Métodos
    @Override
    public T pop() throws Exception {
        T retorno;
        if (this.vazia()) {
            throw new ListaException("Não há nada na pilha");
        } else {
            retorno = (topo.getInfo());
            topo = topo.getProx();
        }
        return retorno;
    }

    @Override
    public T peek() {
        T retorno;
        if (this.vazia()) {
            retorno = (T) "Pilha Vazia";
        } else {
            retorno = (topo.getInfo());
        }
        return retorno;
    }

    @Override
    public boolean vazia() {
        return topo == null;
    }

    @Override
    public void libera() {
        if (this.vazia()) {
            throw new ListaException("Não há nada na pilha para liberar");
        } else {
            topo = topo.getProx();
        }
    }
}
