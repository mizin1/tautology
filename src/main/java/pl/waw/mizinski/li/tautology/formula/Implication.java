package pl.waw.mizinski.li.tautology.formula;

public class Implication extends BinaryOperatorFormula {

	public Implication(Formula leftArgument, Formula rightArgument) {
		super(leftArgument, rightArgument);
	}

	@Override
	public String toString() {
		return "(" + leftArgument.toString() + " => " + rightArgument.toString() + ")";
	}
}
