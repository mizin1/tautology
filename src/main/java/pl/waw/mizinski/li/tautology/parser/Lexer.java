package pl.waw.mizinski.li.tautology.parser;

import java.util.ArrayList;
import java.util.List;

import pl.waw.mizinski.li.tautology.parser.token.CloseBracket;
import pl.waw.mizinski.li.tautology.parser.token.ConjunctionToken;
import pl.waw.mizinski.li.tautology.parser.token.DisjunctionToken;
import pl.waw.mizinski.li.tautology.parser.token.ImplicationToken;
import pl.waw.mizinski.li.tautology.parser.token.LiteralToken;
import pl.waw.mizinski.li.tautology.parser.token.NegationToken;
import pl.waw.mizinski.li.tautology.parser.token.OpenBracket;
import pl.waw.mizinski.li.tautology.parser.token.Token;

public class Lexer {
	
	private String expression;

	public Lexer(String expression) {
		this.expression = expression;
	}
	
	public List<Token> tokenize() throws ParseException {
		List<Token> ret = new ArrayList<Token>();
		
		for(int i=0; i<expression.length(); ++i){
			char c = charAt(i);
			if (Character.isWhitespace(c)){
			} else if (c == '(') {
				ret.add(new OpenBracket());
			} else if (c == ')') {
				ret.add(new CloseBracket());
			} else if (c == '&') {
				ret.add(new ConjunctionToken());
			} else if (c == '+') {
				ret.add(new DisjunctionToken());
			} else if (c == '~') {
				ret.add(new NegationToken());
			} else if (c == '=' && charAt(i+1) == '>') {
				ret.add(new ImplicationToken());
				i++;
			} else if (Character.isAlphabetic(c)){
				ret.add(new LiteralToken(c));
			} else {
				throw new ParseException("Unknown character: " + c);
				}
		}
		return ret;
	}

	private char charAt(int i) {
		if (i >=0 && i < expression.length()) {
			return expression.charAt(i);
		}
		return 0;
	}
}
