package pl.waw.mizinski.li.tautology.tree;

import java.util.List;

import pl.waw.mizinski.li.tautology.formula.Conjunction;
import pl.waw.mizinski.li.tautology.formula.Disjunction;
import pl.waw.mizinski.li.tautology.formula.Formula;
import pl.waw.mizinski.li.tautology.formula.Implication;
import pl.waw.mizinski.li.tautology.formula.Negation;

public class RemoveNonLiteralNegation extends AbstractOperation{

	public List<Sequent> doOperation(Sequent sequent) {
		Sequent ret = new Sequent();
		for (Formula formula : sequent) {
			if (isNegationOfNegation(formula)) {
				ret.add(removeDoubleNegation((Negation) formula));
			} else if (isNegationOfConjunction(formula)) {
				ret.add(removeNegationOfConjunction((Negation) formula));
			} else if (isNegationOfDisjunction(formula)) {
				ret.add(removeNegationOfDisjunction((Negation) formula));
			} else if (isNegationOfImplication(formula)) {
				ret.add(removeNegationOfImplication((Negation) formula));
			} else {
				ret.add(formula);
			}
		}
		return asList(ret);
	}

	private Formula removeDoubleNegation(Negation negation) {
		Negation secondNegation = (Negation) negation.getArgument();
		return secondNegation.getArgument();
	}

	private Formula removeNegationOfConjunction(Negation negation) {
		Conjunction conjunction = (Conjunction) negation.getArgument();
		Formula formula1 = new Negation(conjunction.getLeftArgument());
		Formula formula2 = new Negation(conjunction.getRightArgument());
		return new Disjunction(formula1, formula2);
	}
	
	private Formula removeNegationOfDisjunction(Negation negation) {
		Disjunction disjunction = (Disjunction) negation.getArgument();
		Formula formula1 = new Negation(disjunction.getLeftArgument());
		Formula formula2 = new Negation(disjunction.getRightArgument());
		return new Conjunction(formula1, formula2);
	}
	
	private Formula removeNegationOfImplication(Negation negation) {
		Implication disjunction = (Implication) negation.getArgument();
		Formula formula1 = disjunction.getLeftArgument();
		Formula formula2 = new Negation(disjunction.getRightArgument());
		return new Conjunction(formula1, formula2);
	}
	
	public boolean isOperationPossible(Sequent sequent) {
		for (Formula formula : sequent) {
			if (isNegationOfNegation(formula) || isNegationOfConjunction(formula) || isNegationOfDisjunction(formula) || isNegationOfImplication(formula) ){
				return true;
			}
		}
		return false;
	}

	private boolean isNegationOfNegation(Formula formula) {
		if (formula instanceof Negation) {
			return ((Negation) formula).getArgument() instanceof Negation;
		}
		return false;
	}
	
	private boolean isNegationOfConjunction(Formula formula) {
		if (formula instanceof Negation) {
			return ((Negation) formula).getArgument() instanceof Conjunction;
		}
		return false;
	}
	
	private boolean isNegationOfDisjunction(Formula formula) {
		if (formula instanceof Negation) {
			return ((Negation) formula).getArgument() instanceof Disjunction;
		}
		return false;
	}
	
	private boolean isNegationOfImplication(Formula formula) {
		if (formula instanceof Negation) {
			return ((Negation) formula).getArgument() instanceof Implication;
		}
		return false;
	}
	

}
