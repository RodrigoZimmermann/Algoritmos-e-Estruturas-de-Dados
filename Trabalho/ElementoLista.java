
/**
 *
 * @author Rodrigo Luís Zimmermann
 */
public class ElementoLista<T> {

    private T info;
    private ElementoLista<T> prox;

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public ElementoLista<T> getProx() {
        return prox;
    }

    public void setProx(ElementoLista<T> prox) {
        this.prox = prox;
    }

}
