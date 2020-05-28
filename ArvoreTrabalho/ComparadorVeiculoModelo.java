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
import java.util.Comparator;

public class ComparadorVeiculoModelo implements Comparator<Veiculo>{

	@Override
	public int compare(Veiculo o1, Veiculo o2) {
		return o1.getModelo().compareTo(o2.getModelo());
	}

}