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
public class Arvore<T> {
	private NoArvore<T> raiz = null;
	
    //Construtor
    public Arvore() {
    }
    
    //Metodos
    
    public void setRaiz(NoArvore<T> no)  {
        this.raiz = no;
    }
    
    public NoArvore<T> getRaiz() {
    	return this.raiz;
    }
    
    public boolean vazia() {
        return raiz == null;
    }
    
    public NoArvore<T> pertence(T info) {
    	if (this.vazia()) {
    		return null;
    	}
    	else {
    		return raiz.pertence(info);
    	}
    }
    
    @Override
    public String toString() {
    	if (this.vazia()) {
    		return "";
    	}
    	else {
    		return raiz.imprimePre();
    	}
    }
}
