package pl.waw.mizinski.li.tautology.parser;

import java.util.List;

import pl.waw.mizinski.li.tautology.formula.Conjunction;
import pl.waw.mizinski.li.tautology.formula.Disjunction;
import pl.waw.mizinski.li.tautology.formula.Formula;
import pl.waw.mizinski.li.tautology.formula.Implication;
import pl.waw.mizinski.li.tautology.formula.Literal;
import pl.waw.mizinski.li.tautology.formula.Negation;
import pl.waw.mizinski.li.tautology.parser.token.CloseBracket;
import pl.waw.mizinski.li.tautology.parser.token.ConjunctionToken;
import pl.waw.mizinski.li.tautology.parser.token.DisjunctionToken;
import pl.waw.mizinski.li.tautology.parser.token.ImplicationToken;
import pl.waw.mizinski.li.tautology.parser.token.LiteralToken;
import pl.waw.mizinski.li.tautology.parser.token.NegationToken;
import pl.waw.mizinski.li.tautology.parser.token.OpenBracket;
import pl.waw.mizinski.li.tautology.parser.token.Token;

public class Parser {

	private List<Token> tokens;
	int i = 0;
	
	public Parser(String expression) throws ParseException {
		tokens = new Lexer(expression).tokenize();
	}
	
	public Formula getFormula() throws ParseException {
		i = 0;
		return parseFormula();
	}

	private Formula parseFormula() throws ParseException {
		Token token = popNextToken();
		Formula formula = null;
		if (token instanceof LiteralToken) {
			formula = parseLiteral((LiteralToken) token);
		} else if (token instanceof NegationToken) {
			formula = parseNegation();
		} else if (token instanceof OpenBracket) {
			formula = parseBrackets();
		}
		if (formula == null) {
			throw new ParseException("Illegal token occured: " + token);
		}
		token = getNextToken();
		if (token instanceof ConjunctionToken) {
			popNextToken();
			return new Conjunction(formula, parseFormula());
		} else if (token instanceof DisjunctionToken) {
			popNextToken();
			return new Disjunction(formula, parseFormula());
		} else if (token instanceof ImplicationToken) {
			popNextToken();
			return new Implication(formula, parseFormula());
		}
		
		return formula;
	}
	
	private Formula parseNegation() throws ParseException {
		return new Negation(parseFormula());
	}

	private Formula parseLiteral(LiteralToken literalToken) {
		return new Literal(literalToken.getValue());
	}

	private Formula parseBrackets() throws ParseException {
		Formula formula = parseFormula();
		Token token = popNextToken();
		if (token instanceof CloseBracket) {
			return formula;
		} else {
			throw new ParseException("Close bracket is needed!");
		}
	}

	private boolean hasNextToken() {
		return i < tokens.size(); 
	}
	
	private Token getNextToken() {
		if (hasNextToken()) {
			return tokens.get(i);
		} else {
			return null;
		}
	}
	
	private Token popNextToken() {
		Token ret = getNextToken();
		i++;
		return ret;
	}
}
