

/**
 *
 * @author Rodrigo Luís Zimmermann
 */
public class TesteCalculadoraVetor {

    public static void main(String[] args) throws Exception {
        CalculadoraVetor calculadora = new CalculadoraVetor();
        calculadora.pegaValor("1 1 + 2 0 + *");
        System.out.println(calculadora.passaValor());
    }
}
