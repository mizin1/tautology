package pl.waw.mizinski.li.tautology.tree;

import pl.waw.mizinski.li.tautology.formula.Formula;
import pl.waw.mizinski.li.tautology.tree.operations.Operation;
import pl.waw.mizinski.li.tautology.tree.operations.RemoveConjunction;
import pl.waw.mizinski.li.tautology.tree.operations.RemoveDisjunction;
import pl.waw.mizinski.li.tautology.tree.operations.RemoveImplication;
import pl.waw.mizinski.li.tautology.tree.operations.RemoveNonLiteralNegation;

public class TautologyChecker {

	private static Operation[] operations = { new RemoveConjunction(),
			new RemoveDisjunction(), new RemoveImplication(),
			new RemoveNonLiteralNegation() };

	private Formula formula;

	private Boolean tautology;
	private Sequent counterexample;

	public TautologyChecker(Formula formula) {
		super();
		this.formula = formula;
	}

	public void printTree() {
		checkTautogy(true, new Sequent(formula));
	}

	public boolean isTautology() {
		if (tautology == null) {
			checkTautogy(false, new Sequent(formula));
		}
		return tautology;
	}

	public Sequent getCounterexample() {
		if (counterexample == null) {
			checkTautogy(false, new Sequent(formula));
		}
		return counterexample;
	}
	
	private void checkTautogy(boolean printTree, Sequent sequent) {
		checkTautogyViaRSDistribution(printTree, sequent, "");
		tautology = (counterexample == null);
	}

	private void checkTautogyViaRSDistribution(boolean printTree, Sequent sequent, String spaces) {
		printSequent(printTree, sequent, spaces);
		if (sequent.isIrreducible() && !sequent.isPrimary()) {
			counterexample = sequent;
			return;
		}
		for (Operation operation : operations) {
			if (operation.isOperationPossible(sequent)){
				for(Sequent sequent2 : operation.doOperation(sequent)){
					checkTautogyViaRSDistribution(printTree, sequent2, spaces + "\t");
				}
				break;
			}
		}
	}

	private void printSequent(boolean print, Sequent sequent, String before) {
		if (print) {
			System.out.print(before);
			System.out.println(sequent);
		}
	}

}
