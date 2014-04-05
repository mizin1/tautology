package pl.waw.mizinski.li.tautology.formula;

public abstract class UnaryOperatorFormula extends OperatorFormula {
	
	protected Formula argument;

	public UnaryOperatorFormula(Formula argument) {
		this.argument = argument;
	}

	public Formula getArgument() {
		return argument;
	}

//	public void setArgument(Formula argument) {
//		this.argument = argument;
//	}
	
}
