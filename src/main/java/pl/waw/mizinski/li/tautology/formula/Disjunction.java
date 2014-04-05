package pl.waw.mizinski.li.tautology.formula;

public class Disjunction extends BinaryOperatorFormula {

	public Disjunction(Formula leftArgument, Formula rightArgument) {
		super(leftArgument, rightArgument);
	}

	@Override
	public String toString() {
		return "(" + leftArgument.toString() + " + " + rightArgument.toString() + ")";
	}
	
}
