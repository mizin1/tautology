package pl.waw.mizinski.li.tautology.formula;

public class Negation extends UnaryOperatorFormula {

	public Negation(Formula argument) {
		super(argument);
	}
	
	@Override
	public String toString() {
		return "~" + argument;
	}
}
