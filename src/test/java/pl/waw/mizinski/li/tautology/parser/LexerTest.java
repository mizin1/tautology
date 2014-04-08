package pl.waw.mizinski.li.tautology.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import pl.waw.mizinski.li.tautology.parser.token.CloseBracket;
import pl.waw.mizinski.li.tautology.parser.token.ConjunctionToken;
import pl.waw.mizinski.li.tautology.parser.token.DisjunctionToken;
import pl.waw.mizinski.li.tautology.parser.token.ImplicationToken;
import pl.waw.mizinski.li.tautology.parser.token.LiteralToken;
import pl.waw.mizinski.li.tautology.parser.token.NegationToken;
import pl.waw.mizinski.li.tautology.parser.token.OpenBracket;
import pl.waw.mizinski.li.tautology.parser.token.Token;

public class LexerTest {

	@Test
	public void shoulRecognizeOpenBracket() throws Exception {
		List<Token> tokens = new Lexer("(").tokenize();
		assertEquals(1, tokens.size());
		assertTrue(tokens.get(0) instanceof OpenBracket);
	}

	@Test
	public void shoulRecognizeCloseBracket() throws Exception {
		List<Token> tokens = new Lexer(")").tokenize();
		assertEquals(1, tokens.size());
		assertTrue(tokens.get(0) instanceof CloseBracket);
	}

	@Test
	public void shoulRecognizeConjunctionToken() throws Exception {
		List<Token> tokens = new Lexer("&").tokenize();
		assertEquals(1, tokens.size());
		assertTrue(tokens.get(0) instanceof ConjunctionToken);
	}

	@Test
	public void shoulRecognizeDisjunctionToken() throws Exception {
		List<Token> tokens = new Lexer("+").tokenize();
		assertEquals(1, tokens.size());
		assertTrue(tokens.get(0) instanceof DisjunctionToken);
	}

	@Test
	public void shoulRecognizeImplicationToken() throws Exception {
		List<Token> tokens = new Lexer("=>").tokenize();
		assertEquals(1, tokens.size());
		assertTrue(tokens.get(0) instanceof ImplicationToken);
	}

	@Test
	public void shoulRecognizeNegationToken() throws Exception {
		List<Token> tokens = new Lexer("~").tokenize();
		assertEquals(1, tokens.size());
		assertTrue(tokens.get(0) instanceof NegationToken);
	}

	@Test
	public void shoulRecognizeLiteralToken() throws Exception {
		List<Token> tokens = new Lexer("A").tokenize();
		assertEquals(1, tokens.size());
		Token token = tokens.get(0);
		assertTrue(tokens.get(0) instanceof LiteralToken);
		assertEquals("A", ((LiteralToken) token).getValue());
	}
	
	@Test
	public void shouldRecnizeExpression() throws Exception {
		List<Token> tokens = new Lexer("()+&=>ABC").tokenize();
		assertEquals(8, tokens.size());
		assertTrue(tokens.get(0) instanceof OpenBracket);
		assertTrue(tokens.get(1) instanceof CloseBracket);
		assertTrue(tokens.get(2) instanceof DisjunctionToken);
		assertTrue(tokens.get(3) instanceof ConjunctionToken);
		assertTrue(tokens.get(4) instanceof ImplicationToken);
		assertTrue(tokens.get(5) instanceof LiteralToken);
		assertTrue(tokens.get(6) instanceof LiteralToken);
		assertTrue(tokens.get(7) instanceof LiteralToken);
		
	}
	
	@Test
	public void shouldRecnizeExpressionWithWhiteSpaces() throws Exception {
		List<Token> tokens = new Lexer("( ) + & => A B C").tokenize();
		assertEquals(8, tokens.size());
		assertTrue(tokens.get(0) instanceof OpenBracket);
		assertTrue(tokens.get(1) instanceof CloseBracket);
		assertTrue(tokens.get(2) instanceof DisjunctionToken);
		assertTrue(tokens.get(3) instanceof ConjunctionToken);
		assertTrue(tokens.get(4) instanceof ImplicationToken);
		assertTrue(tokens.get(5) instanceof LiteralToken);
		assertTrue(tokens.get(6) instanceof LiteralToken);
		assertTrue(tokens.get(7) instanceof LiteralToken);
		
	}
	
	@Test(expected = ParseException.class)
	public void shouldThrowExceptionWhenInvalidValueIsGiven() throws Exception {
		new Lexer("=<").tokenize();
	}
}
