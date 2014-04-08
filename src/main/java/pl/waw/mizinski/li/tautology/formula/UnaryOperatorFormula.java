package pl.waw.mizinski.li.tautology.formula;

public abstract class UnaryOperatorFormula extends OperatorFormula {
	
	protected Formula argument;

	public UnaryOperatorFormula(Formula argument) {
		this.argument = argument;
	}

	public Formula getArgument() {
		return argument;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((argument == null) ? 0 : argument.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnaryOperatorFormula other = (UnaryOperatorFormula) obj;
		if (argument == null) {
			if (other.argument != null)
				return false;
		} else if (!argument.equals(other.argument))
			return false;
		return true;
	}

	
}
