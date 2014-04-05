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

//	public void setLeftArgument(Formula leftArgument) {
//		this.leftArgument = leftArgument;
//	}

	public Formula getRightArgument() {
		return rightArgument;
	}

//	public void setRightArgument(Formula rightArgument) {
//		this.rightArgument = rightArgument;
//	}

}