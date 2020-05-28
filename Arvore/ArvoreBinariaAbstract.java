/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arvore;

/**
 *
 * @author Rodrigo Luís Zimmermann
 */
public abstract class ArvoreBinariaAbstract<T> {
    //Atributos
    private NoArvoreBinaria<T> raiz = null;
    
    //Construtor
    public ArvoreBinariaAbstract() {
    }
    
    //Metodos
    
    protected void setRaiz( NoArvoreBinaria<T> no )  {
        raiz = no;
    }
    
    protected NoArvoreBinaria<T> getRaiz() {
    	return this.raiz;
    }
    
    public boolean vazia() {
        return raiz == null;
    }
    
    public NoArvoreBinaria<T> pertence(T info) {
    	if (this.vazia()) {
    		return null;
    	}
    	else {
    		return raiz.pertence( info );
    	}
    }
    
    @Override
    public String toString() {
    	if (this.vazia()) {
    		return "<>";
    	}
    	else {
    		return raiz.imprimePre();
    	}
    }
    
     public String toStringOrdered() {
    	if (this.vazia()) {
    		return "";
    	}
    	else {
    		return raiz.imprimeCentral();
    	}
    }
    
}