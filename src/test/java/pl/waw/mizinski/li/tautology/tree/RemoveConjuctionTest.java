package pl.waw.mizinski.li.tautology.tree;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import pl.waw.mizinski.li.tautology.formula.Conjunction;
import pl.waw.mizinski.li.tautology.formula.Literal;

public class RemoveConjuctionTest {

	private Operation operation = new RemoveConjunction();
	
	@Test
	public void shouldRemoveConjuction() throws Exception {
		Conjunction conjunction = new Conjunction(new Literal("A"), new Literal("B"));
		Sequent sequent = new Sequent(conjunction);
		assertTrue(operation.isOperationPossible(sequent));
		List<Sequent> sequents = operation.doOperation(sequent);
		assertEquals(2, sequents.size());
	}
	
}
