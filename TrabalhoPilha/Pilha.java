
/**
 *
 * @author Rodrigo Luís Zimmermann
 */
public interface Pilha<T> {

    void push(T valor) throws Exception;

    T pop() throws Exception;

    T peek();

    boolean vazia();

    void libera();
}
