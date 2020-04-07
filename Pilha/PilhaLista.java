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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T peek() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean vazia() {
        return (topo.getInfo().equals(null));
    }

    @Override
    public void libera() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
