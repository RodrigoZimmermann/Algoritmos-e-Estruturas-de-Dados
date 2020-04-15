

/**
 *
 * @author Rodrigo Luís Zimmermann
 */
public class TesteCalculadoraLista {

    public static void main(String[] args) throws Exception {
        CalculadoraLista calculadora = new CalculadoraLista();
        calculadora.pegaValor("1 1 + 2 0 + *");
        System.out.println(calculadora.passaValor());
    }
}
