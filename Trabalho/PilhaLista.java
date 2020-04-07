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
public class PilhaLista<T> implements Pilha<T> {

    private ElementoLista<T> topo;

    @Override
    public void push(T valor) throws Exception {
        ElementoLista<T> novo = new ElementoLista<>();
        if (vazia()) {
            topo.setInfo(valor);
        } else {
            novo.setInfo(valor);
            novo.setProx(topo);
        }
    }

//Métodos
    @Override
    public T pop() throws Exception {
        T retorno;
        if (vazia()) {
            throw new ListaException("Não há nada na lista");
        } else {
            retorno = (topo.getInfo());
            topo = topo.getProx();
        }
        return retorno;
    }

    @Override
    public T peek() {
        T retorno;
        if (vazia()) {
            retorno = (T) "Lista Vazia";
        } else {
            retorno = (topo.getInfo());
        }
        return retorno;
    }

    @Override
    public boolean vazia() {
        return (topo.getInfo().equals(null));
    }

    @Override
    public void libera() {
        if (vazia()) {
            throw new ListaException("Não há nada na lista para liberar");
        } else {
            topo = topo.getProx();
        }
    }
}
