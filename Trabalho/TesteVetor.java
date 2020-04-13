
/**
 *
 * @author Rodrigo Luís Zimmermann
 */
public class TesteVetor {

    public static void main(String[] args) throws Exception {
        PilhaVetor<String> pilha = new PilhaVetor<>();
        System.out.println("Esperado Pilha Vazia = " + pilha.peek());
        pilha.push("A");
        pilha.push("B");
        System.out.println("Esperado B = " + pilha.peek());
        pilha.push("C");
        System.out.println("Esperado C = " + pilha.peek());
        System.out.println("Esperado C = " + pilha.pop());
        System.out.println("Esperado B = " + pilha.peek());
        pilha.libera();
        System.out.println("Esperado A = " + pilha.peek());
        System.out.println("Esperado false " + pilha.vazia());
        System.out.println("Esperado A = " + pilha.pop());
        System.out.println("Esperado true " + pilha.vazia());
    }
}
