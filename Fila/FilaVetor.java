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
public class FilaVetor<T> implements Fila<T> {

    private int n;
    private int ini;
    private int tam = 100;
    private T[] vet;
    private int fim;

    FilaVetor() {
        vet = (T[]) new Object[tam];
    }

    @Override
    public void insere(T o) throws Exception {
        if (n == tam) {
            throw new RuntimeException("Fila cheia");
        }
        vet[this.getFim()] = o;
        n++;
    }

    private int getFim() {
        return (ini + n) % tam;
    }

    @Override
    public T retira() throws Exception {
        if (vazia()) {
            throw new RuntimeException("Não há o que retirar");
        }
        T valor = vet[ini];
        vet[ini] = null;
        ini = (ini + 1) % tam;
        n--;
        return valor;
    }

    @Override
    public boolean vazia() {
        return n == 0;
    }

    @Override
    public void libera() {
        for (int i = 0; i < n; i++) {
            vet[i] = null;
        }
        n = 0;
        ini = 0;
    }

    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();
        int indice;
        for (int i = 0; i < n; i++) {
            indice = (i + ini) % tam;
            if (i > 0) {
                resultado.append(", ");
            }
            resultado.append(vet[indice]);
        }
        return resultado.toString();
    }

}
