package pl.waw.mizinski.li.tautology.formula;

import pl.waw.mizinski.li.tautology.parser.ParseException;
import pl.waw.mizinski.li.tautology.parser.Parser;

public class Formula {
	
	public static Formula parse(String expression) throws ParseException {
		return new Parser(expression).getFormula();
	}
	
}
