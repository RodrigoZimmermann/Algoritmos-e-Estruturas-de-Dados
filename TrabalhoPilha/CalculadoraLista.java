
/**
 *
 * @author Rodrigo Luís Zimmermann
 */
public class CalculadoraLista {

    PilhaLista<String> pilha = new PilhaLista<>();
    PilhaLista<String> resultadoExpressao = new PilhaLista<>();
    private int retorno1 = 1;
    private int retorno0 = 0;
    private boolean retorno1True = false;
    private String sinal;
    private String segundoCalculo;
    private String primeiroCalculo;
    private int resultado = 0;

    public void pegaValor(String entrada) throws Exception {
        for (int i = 0; i < entrada.length() - 1;) {
            String concatena = null;
            while (entrada.charAt(i) != ' ') {
                concatena = String.valueOf(entrada.charAt(i));
                i++;
            }
            if (concatena == null) {
                i++;
            }
            if (!(concatena == null)) {
                pilha.push(concatena);
            }
            switch (pilha.peek()) {
                case "*":
                    sinal = pilha.pop();
                    segundoCalculo = pilha.pop();
                    primeiroCalculo = pilha.pop();
                    resultado = Integer.parseInt(primeiroCalculo) * Integer.parseInt(segundoCalculo);
                    resultadoExpressao.push(Integer.toString(resultado));
                    break;
                case "/":
                    sinal = pilha.pop();
                    segundoCalculo = pilha.pop();
                    primeiroCalculo = pilha.pop();
                    resultado = Integer.parseInt(primeiroCalculo) / Integer.parseInt(segundoCalculo);
                    resultadoExpressao.push(Integer.toString(resultado));
                    break;
                case "-":
                    sinal = pilha.pop();
                    segundoCalculo = pilha.pop();
                    primeiroCalculo = pilha.pop();
                    resultado = Integer.parseInt(primeiroCalculo) - Integer.parseInt(segundoCalculo);
                    resultadoExpressao.push(Integer.toString(resultado));
                    break;
                case "+":
                    sinal = pilha.pop();
                    segundoCalculo = pilha.pop();
                    primeiroCalculo = pilha.pop();
                    resultado = Integer.parseInt(primeiroCalculo) + Integer.parseInt(segundoCalculo);
                    resultadoExpressao.push(Integer.toString(resultado));
                    break;
            }
            if (entrada.length() == i + 1) {
                resultadoExpressao.push(Integer.toString(entrada.charAt(i)));
            }
        }

    }

    public String passaValor() throws Exception {
        while (!resultadoExpressao.vazia()) {
            String operador = resultadoExpressao.pop();
            switch (operador) {
                case "42":
                    while (!resultadoExpressao.vazia()) {
                        retorno1True = true;
                        if (!resultadoExpressao.peek().equals("Pilha Vazia")) {
                            segundoCalculo = resultadoExpressao.pop();
                        } else {
                            segundoCalculo = "1";
                        }
                        if (!resultadoExpressao.peek().equals("Pilha Vazia")) {
                            primeiroCalculo = resultadoExpressao.pop();
                        } else {
                            primeiroCalculo = "1";
                        }
                        resultado = Integer.parseInt(primeiroCalculo) * Integer.parseInt(segundoCalculo);
                        retorno1 = retorno1 * resultado;
                    }
                    break;
                case "47":
                    while (!resultadoExpressao.vazia()) {
                        retorno1True = true;
                        if (!resultadoExpressao.peek().equals("Pilha Vazia")) {
                            segundoCalculo = resultadoExpressao.pop();
                        } else {
                            segundoCalculo = "1";
                        }
                        if (!resultadoExpressao.peek().equals("Pilha Vazia")) {
                            primeiroCalculo = resultadoExpressao.pop();
                        } else {
                            primeiroCalculo = "1";
                        }
                        resultado = Integer.parseInt(primeiroCalculo) / Integer.parseInt(segundoCalculo);
                        retorno1 = resultado / retorno1;
                    }
                    break;
                case "43":
                    while (!resultadoExpressao.vazia()) {
                        if (!resultadoExpressao.peek().equals("Pilha Vazia")) {
                            segundoCalculo = resultadoExpressao.pop();
                        } else {
                            segundoCalculo = "0";
                        }
                        if (!resultadoExpressao.peek().equals("Pilha Vazia")) {
                            primeiroCalculo = resultadoExpressao.pop();
                        } else {
                            primeiroCalculo = "0";
                        }
                        resultado = Integer.parseInt(primeiroCalculo) + Integer.parseInt(segundoCalculo);
                        retorno0 = retorno0 + resultado;
                    }
                    break;
                case "45":
                    while (!resultadoExpressao.vazia()) {
                        if (!resultadoExpressao.peek().equals("Pilha Vazia")) {
                            segundoCalculo = resultadoExpressao.pop();
                        } else {
                            segundoCalculo = "0";
                        }
                        if (!resultadoExpressao.peek().equals("Pilha Vazia")) {
                            primeiroCalculo = resultadoExpressao.pop();
                        } else {
                            primeiroCalculo = "0";
                        }
                        resultado = Integer.parseInt(primeiroCalculo) - Integer.parseInt(segundoCalculo);
                        retorno0 = retorno0 - resultado;
                    }
                    break;
            }
        }
        if (retorno1True) {
            return Integer.toString(retorno1);
        } else {
            return Integer.toString(retorno0);
        }
    }

}
