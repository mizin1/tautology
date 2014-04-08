package pl.waw.mizinski.li.tautology.tree.operations;

import java.util.List;

import pl.waw.mizinski.li.tautology.formula.Formula;
import pl.waw.mizinski.li.tautology.formula.Implication;
import pl.waw.mizinski.li.tautology.formula.Negation;
import pl.waw.mizinski.li.tautology.tree.Sequent;

public class RemoveImplication extends AbstractOperation{

	public List<Sequent> doOperation(Sequent sequent) {
		Sequent ret = new Sequent();
		for (Formula formula : sequent) {
			if (formula instanceof Implication) {
				Negation negation = new Negation(((Implication) formula).getLeftArgument());
				ret.add(negation);
				ret.add(((Implication) formula).getRightArgument());
			} else {
				ret.add(formula);
			}
		}
		return asList(ret);
	}

	public boolean isOperationPossible(Sequent sequent) {
		return hasFormula(sequent, Implication.class);
	}

}
