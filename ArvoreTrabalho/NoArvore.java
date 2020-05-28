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
public class NoArvore<T> {
    private T info;
    private NoArvore<T> filho;
    private NoArvore<T> irmao;
    
    public NoArvore(T info) {
        this.info = info;
    }
    
    public T getInfo() {
    	return this.info;
    }
    
    public void inserirFilho( NoArvore<T> no ) {
            no.irmao = this.filho;
            this.filho = no;
    }
    
    public NoArvore<T> pertence(T info) {
		if (this.info.equals(info)) {
			return this;
		}

		NoArvore<T> retorno = null;
		if (this.filho != null) {
			retorno = filho.pertence(info);
			if (retorno != null) {
				return retorno;
			}
		}

		if (this.irmao != null) {
			retorno = irmao.pertence(info);
		}

		return retorno;
	}
    
    public String imprimePre() {
		// trata a raiz
		String str = "<" + this.info;

		if (this.filho != null) {
			str += filho.imprimePre();
		}
		str +=  ">";
		if (this.irmao != null) {
			str += irmao.imprimePre();
		}

		return str ;
	}
}
