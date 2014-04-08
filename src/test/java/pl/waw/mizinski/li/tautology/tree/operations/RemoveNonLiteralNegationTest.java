package pl.waw.mizinski.li.tautology.tree.operations;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static pl.waw.mizinski.li.tautology.common.TestConstants.A;
import static pl.waw.mizinski.li.tautology.common.TestConstants.B;
import static pl.waw.mizinski.li.tautology.common.TestConstants.NA;
import static pl.waw.mizinski.li.tautology.common.TestConstants.NB;

import java.util.List;

import org.junit.Test;

import pl.waw.mizinski.li.tautology.formula.Conjunction;
import pl.waw.mizinski.li.tautology.formula.Disjunction;
import pl.waw.mizinski.li.tautology.formula.Formula;
import pl.waw.mizinski.li.tautology.formula.Implication;
import pl.waw.mizinski.li.tautology.formula.Negation;
import pl.waw.mizinski.li.tautology.tree.Sequent;

public class RemoveNonLiteralNegationTest {

private Operation operation = new RemoveNonLiteralNegation();
	
	@Test
	public void shouldOperationBePossibleForConjunction() throws Exception {
		Sequent sequent = new Sequent(new Negation(new Conjunction(A, B)));
		assertTrue(operation.isOperationPossible(sequent));
	}
	
	@Test 
	public void shouldRemoveNegationOfConjunction() throws Exception {
		Sequent sequent = new Sequent(new Negation(new Conjunction(A, B)));
		List<Sequent> sequents = operation.doOperation(sequent);
		assertEquals(1, sequents.size());
		assertArrayEquals(new Formula[]{new Disjunction(NA, NB)}, sequents.get(0).toArray());
	}
	
	@Test
	public void shouldOperationBePossibleForDisjunction() throws Exception {
		Sequent sequent = new Sequent(new Negation(new Disjunction(A, B)));
		assertTrue(operation.isOperationPossible(sequent));
	}
	
	@Test 
	public void shouldRemoveNegationOfDisjunction() throws Exception {
		Sequent sequent = new Sequent(new Negation(new Disjunction(A, B)));
		List<Sequent> sequents = operation.doOperation(sequent);
		assertEquals(1, sequents.size());
		assertArrayEquals(new Formula[]{new Conjunction(NA, NB)}, sequents.get(0).toArray());
	}
	
	@Test
	public void shouldOperationBePossibleForImplication() throws Exception {
		Sequent sequent = new Sequent(new Negation(new Implication(A, B)));
		assertTrue(operation.isOperationPossible(sequent));
	}
	
	@Test 
	public void shouldRemoveNegationOfImplication() throws Exception {
		Sequent sequent = new Sequent(new Negation(new Implication(A, B)));
		List<Sequent> sequents = operation.doOperation(sequent);
		assertEquals(1, sequents.size());
		assertArrayEquals(new Formula[]{new Conjunction(A, NB)}, sequents.get(0).toArray());
	}
	
	@Test
	public void shouldOperationBePossibleForDoubleNegation() throws Exception {
		Sequent sequent = new Sequent(new Negation(NA));
		assertTrue(operation.isOperationPossible(sequent));
	}
	

	@Test 
	public void shouldRemoveDoubleNegation() throws Exception {
		Sequent sequent = new Sequent(new Negation(NA));
		List<Sequent> sequents = operation.doOperation(sequent);
		assertEquals(1, sequents.size());
		assertArrayEquals(new Formula[]{A}, sequents.get(0).toArray());
	}

	@Test
	public void shouldOperationBeImpossible() throws Exception {
		Sequent sequent = new Sequent(new Conjunction(A, B));
		assertFalse(operation.isOperationPossible(sequent));
	}
	
	@Test
	public void shouldOperationBeImpossibleForSingleNegation() throws Exception {
		Sequent sequent = new Sequent(new Negation(A));
		assertFalse(operation.isOperationPossible(sequent));
	}
	
}
