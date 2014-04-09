package pl.waw.mizinski.li.tautology.tree.operations;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static pl.waw.mizinski.li.tautology.common.TestConstants.A;
import static pl.waw.mizinski.li.tautology.common.TestConstants.B;
import static pl.waw.mizinski.li.tautology.common.TestConstants.NA;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import pl.waw.mizinski.li.tautology.formula.Conjunction;
import pl.waw.mizinski.li.tautology.formula.Formula;
import pl.waw.mizinski.li.tautology.formula.Implication;
import pl.waw.mizinski.li.tautology.tree.Sequent;

public class RemoveImplicationTest {

private Operation operation = new RemoveImplication();
	
	@Test
	public void shouldOperationBePossible() throws Exception {
		Sequent sequent = new Sequent(new Implication(A, B));
		assertTrue(operation.isOperationPossible(sequent));
	}
	
	@Test 
	public void shouldRemoveImplication() throws Exception {
		Sequent sequent = new Sequent(new Implication(A, B));
		List<Sequent> sequents = operation.doOperation(sequent);
		assertEquals(1, sequents.size());
		assertTrue( sequents.get(0).containsAll(Arrays.asList(NA, B)));
	}
	
	@Test
	public void shouldOperationBeImpossible() throws Exception {
		Sequent sequent = new Sequent(new Conjunction(A, B));
		assertFalse(operation.isOperationPossible(sequent));
	}
	
}
