package pl.waw.mizinski.li.tautology.tree;

import java.util.List;

import pl.waw.mizinski.li.tautology.formula.Disjunction;
import pl.waw.mizinski.li.tautology.formula.Formula;

public class RemoveDisjunction extends AbstractOperation {

	public List<Sequent> doOperation(Sequent sequent) {
		Sequent ret = new Sequent();
		for (Formula formula : sequent) {
			if (formula instanceof Disjunction) {
				ret.add(((Disjunction) formula).getLeftArgument());
				ret.add(((Disjunction) formula).getRightArgument());
			} else {
				ret.add(formula);
			}
		}
		return asList(ret);
	}

	public boolean isOperationPossible(Sequent sequent) {
		return hasFormula(sequent, Disjunction.class);
	}

}
