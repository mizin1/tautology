package pl.waw.mizinski.li.tautology.tree.operations;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static pl.waw.mizinski.li.tautology.common.TestConstants.A;
import static pl.waw.mizinski.li.tautology.common.TestConstants.B;

import java.util.List;

import org.junit.Test;

import pl.waw.mizinski.li.tautology.formula.Conjunction;
import pl.waw.mizinski.li.tautology.formula.Formula;
import pl.waw.mizinski.li.tautology.formula.Implication;
import pl.waw.mizinski.li.tautology.tree.Sequent;

public class RemoveConjuctionTest {

	private Operation operation = new RemoveConjunction();
	
	@Test
	public void shouldOperationBePossible() throws Exception {
		Sequent sequent = new Sequent(new Conjunction(A, B));
		assertTrue(operation.isOperationPossible(sequent));
	}
	
	@Test 
	public void shouldRemoveConjunction() throws Exception {
		Sequent sequent = new Sequent(new Conjunction(A, B));
		List<Sequent> sequents = operation.doOperation(sequent);
		assertEquals(2, sequents.size());
		assertArrayEquals(new Formula[]{A}, sequents.get(0).toArray());
		assertArrayEquals(new Formula[]{B}, sequents.get(1).toArray());
	}
	
	@Test
	public void shouldOperationBeImpossible() throws Exception {
		Sequent sequent = new Sequent(new Implication(A, B));
		assertFalse(operation.isOperationPossible(sequent));
	}
	
	
}
