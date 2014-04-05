package pl.waw.mizinski.li.tautology.tree;

import java.util.Arrays;
import java.util.List;

import pl.waw.mizinski.li.tautology.formula.Formula;

public abstract class AbstractOperation implements Operation{
	
	public boolean hasFormula(Sequent sequent, Class<? extends Formula> clazz) {
		for (Formula formula : sequent) {
			if (clazz.isInstance(formula)) {
				return true;
			}
		}
		return false;
	}
	
	public List<Sequent> asList(Sequent... sequents){
		return Arrays.asList(sequents);
	}
}
