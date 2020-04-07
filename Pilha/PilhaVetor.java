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
public class PilhaVetor<T> implements Pilha<T> {

    private int n;
    private int tam;
    private T[] vet;

    //Construtores
    public PilhaVetor() {
        vet = (T[]) new Object[100];
    }

    public PilhaVetor(int tamanho) {
        vet = (T[]) new Object[tamanho];
    }

    //Métodos
    @Override
    public void push(T valor) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T pop() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T peek() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean vazia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void libera() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
