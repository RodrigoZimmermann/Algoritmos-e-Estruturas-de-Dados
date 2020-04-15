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
public interface Fila<T> {

    void insere(T o) throws Exception;

    T retira() throws Exception;

    boolean vazia();

    void libera();

    String toString();
    
}
