package pl.waw.mizinski.li.tautology.formula;


public class Conjunction extends BinaryOperatorFormula {

	public Conjunction(Formula leftArgument, Formula rightArgument) {
		super(leftArgument, rightArgument);
	}

	@Override
	public String toString() {
		return "(" + leftArgument.toString() + " & " + rightArgument.toString() + ")";
	}
}
