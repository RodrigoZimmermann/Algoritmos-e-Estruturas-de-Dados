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

    private int n = 0;
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
        if (n == vet.length) {
            expande();
        }
        vet[n] = valor;
        n++;
    }

    private void expande() {
        T[] novoVetor = (T[]) new Object[vet.length * 2];  //dobrar o tamanho atual
        for (int i = 0; i < vet.length; i++) {
            novoVetor[i] = vet[i];
        }
        vet = novoVetor;
    }

    @Override
    public T pop() throws Exception {
        if (this.vazia()) {
            throw new ListaException("Não há nada na pilha para remover");
        } else {
            T retorno = null;
            for (int i = 0; i <= n; i++) {
                retorno = vet[n];
                vet[n] = null;
            }
            n--;
            return retorno;
        }
    }

    @Override
    public T peek() {
        if (this.vazia()) {
            throw new ListaException("Não há nada para pegar");
        } else {
            T retorno = null;
            for (int i = 0; i <= n; i++) {
                retorno = vet[n];
            }
            return retorno;
        }
    }

    @Override
    public boolean vazia() {
        return n == 0;
    }

    @Override
    public void libera() {
        if (this.vazia()) {
            throw new ListaException("Não há nada na pilha para liberar");
        } else {
            for (int i = 0; i <= n; i++) {
                vet[n] = null;
            }
            n--;
        }
    }

}
