package pl.waw.mizinski.li.tautology.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import static pl.waw.mizinski.li.tautology.common.TestConstants.*;

import org.junit.Test;

import pl.waw.mizinski.li.tautology.formula.BinaryOperatorFormula;
import pl.waw.mizinski.li.tautology.formula.Conjunction;
import pl.waw.mizinski.li.tautology.formula.Disjunction;
import pl.waw.mizinski.li.tautology.formula.Formula;
import pl.waw.mizinski.li.tautology.formula.Implication;
import pl.waw.mizinski.li.tautology.formula.Literal;
import pl.waw.mizinski.li.tautology.formula.Negation;

public class ParserTest {
	
	@Test
	public void shouldParseLiteral() throws Exception{
		Formula formula = new Parser("A").getFormula();
		assertTrue(formula instanceof Literal);
		assertEquals(A, formula);
	}
	
	@Test
	public void shouldParseConjunction() throws Exception{
		Formula formula = new Parser("A & B").getFormula();
		assertTrue(formula instanceof Conjunction);
		assertEquals(A, ((BinaryOperatorFormula)formula).getLeftArgument());
		assertEquals(B, ((BinaryOperatorFormula)formula).getRightArgument());
	}
	
	@Test
	public void shouldParseDisjunction() throws Exception{
		Formula formula = new Parser("A + B").getFormula();
		assertTrue(formula instanceof Disjunction);
		assertEquals(A, ((BinaryOperatorFormula)formula).getLeftArgument());
		assertEquals(B, ((BinaryOperatorFormula)formula).getRightArgument());
	}
	@Test
	public void shouldParseNegation() throws Exception{
		Formula formula = new Parser("~A").getFormula();
		assertTrue(formula instanceof Negation);
		assertEquals(A, ((Negation)formula).getArgument());
	}
	
	@Test
	public void shouldParseImplication() throws Exception{
		Formula formula = new Parser("A => B").getFormula();
		assertTrue(formula instanceof Implication);
		assertEquals(A, ((BinaryOperatorFormula)formula).getLeftArgument());
		assertEquals(B, ((BinaryOperatorFormula)formula).getRightArgument());
	}
	
	@Test
	public void shouldParseBrackets() throws Exception{
		Formula formula = new Parser("((((((((A))))))))").getFormula();
		assertTrue(formula instanceof Literal);
		assertEquals(A, formula);
	}
	
	@Test
	public void shouldParseLongExpr() throws Exception{
		String expr = "(((A=>B)&(B=>C))=>~(A&~C))";
		Formula formula = new Parser(expr).getFormula();
		assertTrue(formula instanceof Implication);
		assertEquals(expr, formula.toString().replaceAll("\\s", ""));
	}
	
	
}
