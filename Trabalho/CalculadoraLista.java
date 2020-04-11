/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pilha;

/**
 *
 * @author Rodrigo Luís Zimmermann
 */
public class CalculadoraLista {

    int countNumero = 0;
    int countCaracter = 0;
    int count = 0;
    boolean um = true;
    boolean dois = false;
    boolean tres = false;
    boolean finalizado = false;
    private char[] expressao;
    PilhaLista<String> pilha = new PilhaLista<>();

    public String pegaValor(String entrada) throws Exception {

        String manipula = entrada.trim();
        String concatena;
        String primeiro = null;
        String segundo = null;

        for (int i = 0; i < manipula.length(); i++) {
            String checkLetra = String.valueOf(manipula.charAt(i));
            if(checkLetra.substring(i).matches("[a-z]") ||checkLetra.substring(i).matches("[A-Z]")){
                 throw new ListaException("Encontrado palavra na expressão");
            }
            if (um) {
                if (manipula.charAt(0) == '*' || manipula.charAt(0) == '/'
                        || manipula.charAt(0) == '+' || manipula.charAt(0) == '-') {
                    throw new ListaException("Esperado um número");
                } else {
                    while (manipula.charAt(i) != ' ') {
                        if (manipula.charAt(i) != '*' || manipula.charAt(i) != '/'
                                || manipula.charAt(i) != '+' || manipula.charAt(i) != '-'
                                && !checkLetra.substring(i).matches("[a-z]") ||!checkLetra.substring(i).matches("[A-Z]")) {
                            concatena = String.valueOf(manipula.charAt(i));
                            primeiro += concatena;
                        } else {
                            throw new ListaException("Erro");
                        }
                    }
                    pilha.push(primeiro);
                    um = false;
                    dois = true;
                }
            }
            if (dois) {
                if (manipula.charAt(i + 1) != ' '
                        && manipula.charAt(i + 1) != '*' || manipula.charAt(i + 1) != '/'
                        || manipula.charAt(i + 1) != '+' || manipula.charAt(i + 1) != '-') {
                    while (manipula.charAt(i) != ' ') {
                        if (manipula.charAt(i) != '*' || manipula.charAt(i) != '/'
                                || manipula.charAt(i) != '+' || manipula.charAt(i) != '-'
                                && !checkLetra.substring(i).matches("[a-z]") ||!checkLetra.substring(i).matches("[A-Z]")) {
                            concatena = String.valueOf(manipula.charAt(i));
                            segundo += concatena;
                        } else {
                            throw new ListaException("caracter junto de números");
                        }
                    }
                    pilha.push(segundo);
                    dois = false;
                    tres = true;
                }
            } else {
                throw new ListaException("Esperado um número");
            }
            if (tres) {
                if (manipula.charAt(i) == '*' || manipula.charAt(i) == '/'
                        || manipula.charAt(i) == '+' || manipula.charAt(i) == '-') {
                     pilha.push(String.valueOf(manipula.charAt(i)));
                    if (manipula.charAt(i + 1) != '*' || manipula.charAt(i + 1) != '/'
                            || manipula.charAt(i + 1) != '+' || manipula.charAt(i + 1) != '-'
                            && manipula.charAt(i + 1) == ' ' || manipula.charAt(i + 1) == ' '
                            || manipula.charAt(i + 1) == ' ' || manipula.charAt(i + 1) == ' '
                            && !checkLetra.substring(i).matches("[a-z]") || !checkLetra.substring(i).matches("[A-Z]")) {
                        um = true;
                        tres = false;
                    } else if (manipula.endsWith("*") || manipula.endsWith("/")
                            || manipula.endsWith("-") || manipula.endsWith("+")) {
                        pilha.push(String.valueOf(manipula.charAt(i+1)));
                        finalizado = true;
                    } else {
                        throw new ListaException("Esperando finalizar a expressão ou continuar");
                    }
                }
            } else {
                throw new ListaException("Esperado um caracter");
            }
            
            if(finalizado){
                
               ca pilha.pop();
            }
        }

        return null;

    }

}
