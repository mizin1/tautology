package pl.waw.mizinski.li.tautology.common;

import pl.waw.mizinski.li.tautology.formula.Formula;
import pl.waw.mizinski.li.tautology.formula.Literal;
import pl.waw.mizinski.li.tautology.formula.Negation;

public class TestConstants {
	
	public static final Formula A = new Literal("A");
	public static final Formula B = new Literal("B");
	
	public static final Formula NA = new Negation(A);
	public static final Formula NB = new Negation(B);
}
