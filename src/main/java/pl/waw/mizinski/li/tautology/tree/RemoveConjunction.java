package pl.waw.mizinski.li.tautology.tree;

import java.util.List;

import pl.waw.mizinski.li.tautology.formula.Conjunction;
import pl.waw.mizinski.li.tautology.formula.Formula;

public class RemoveConjunction extends AbstractOperation {

	public List<Sequent> doOperation(Sequent sequent) {
		for (Formula formula : sequent) {
			if(formula instanceof Conjunction) {
				return branchSequent(sequent, (Conjunction) formula);
			}
		}
		return asList(sequent);
	}

	private List<Sequent> branchSequent(Sequent sequent, Conjunction conjunction) {
		sequent.remove(conjunction);
		Sequent sequent1 = sequent;
		Sequent sequent2 = (Sequent) sequent1.clone();
		sequent1.add(conjunction.getLeftArgument());
		sequent2.add(conjunction.getRightArgument());
		return asList(sequent1, sequent2);
	}

	public boolean isOperationPossible(Sequent sequent) {
		return hasFormula(sequent, Conjunction.class);
	}

}
