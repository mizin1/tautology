package pl.waw.mizinski.li.tautology.formula;

public abstract class BinaryOperatorFormula extends OperatorFormula {
	
	protected Formula leftArgument;
	protected Formula rightArgument;
	
	public BinaryOperatorFormula(Formula leftArgument, Formula rightArgument) {
		this.leftArgument = leftArgument;
		this.rightArgument = rightArgument;
	}

	public Formula getLeftArgument() {
		return leftArgument;
	}

	public Formula getRightArgument() {
		return rightArgument;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((leftArgument == null) ? 0 : leftArgument.hashCode());
		result = prime * result
				+ ((rightArgument == null) ? 0 : rightArgument.hashCode());
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
		BinaryOperatorFormula other = (BinaryOperatorFormula) obj;
		if (leftArgument == null) {
			if (other.leftArgument != null)
				return false;
		} else if (!leftArgument.equals(other.leftArgument))
			return false;
		if (rightArgument == null) {
			if (other.rightArgument != null)
				return false;
		} else if (!rightArgument.equals(other.rightArgument))
			return false;
		return true;
	}

	
	
}