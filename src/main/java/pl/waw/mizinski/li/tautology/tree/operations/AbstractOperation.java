package pl.waw.mizinski.li.tautology.tree.operations;

import java.util.Arrays;
import java.util.List;

import pl.waw.mizinski.li.tautology.formula.Formula;
import pl.waw.mizinski.li.tautology.tree.Sequent;

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
