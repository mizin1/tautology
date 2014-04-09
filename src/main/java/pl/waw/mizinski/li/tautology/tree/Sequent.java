package pl.waw.mizinski.li.tautology.tree;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import pl.waw.mizinski.li.tautology.formula.Formula;
import pl.waw.mizinski.li.tautology.formula.Literal;
import pl.waw.mizinski.li.tautology.formula.Negation;

public class Sequent extends HashSet<Formula> {

	private static final long serialVersionUID = 1L;

	public Sequent() {
		super();
	}

	public Sequent(Collection<? extends Formula> c) {
		super(c);
	}

	public Sequent(Formula... forms) {
		super(Arrays.asList(forms));
	}

	public boolean isIrreducible() {
		for (Formula formula : this) {
			if (!(formula instanceof Literal)) {
				if (!(formula instanceof Negation && ((Negation) formula).getArgument() instanceof Literal)) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean isPrimary() {
		for (Formula formula : this) {
			if (formula instanceof Literal) {
				for (Formula formula2 : this) {
					if (formula2 instanceof Negation && ((Negation) formula2).getArgument().equals(formula)) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
