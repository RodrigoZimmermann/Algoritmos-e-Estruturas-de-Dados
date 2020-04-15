/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fila;

/**
 *
 * @author Rodrigo Luís Zimmermann
 */
public class TesteFilaVetor {

    public static void main(String[] args) throws Exception {
        FilaVetor<String> fila = new FilaVetor<>();
        fila.insere("A");
        fila.insere("B");
        System.out.println("Esperado A = " + fila.retira());
        fila.insere("C");
        System.out.println("Esperado B = " + fila.retira());
        System.out.println(fila.vazia());
        fila.libera();
        System.out.println(fila.vazia());
        fila.insere("D");
        fila.insere("I");
        fila.insere("G");
        fila.insere("O");
        System.out.println("Esperado D, I, G, O = " + fila.toString());
    }
}
