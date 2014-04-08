package pl.waw.mizinski.li.tautology.tree;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static pl.waw.mizinski.li.tautology.common.TestConstants.A;
import static pl.waw.mizinski.li.tautology.common.TestConstants.B;
import static pl.waw.mizinski.li.tautology.common.TestConstants.NA;
import static pl.waw.mizinski.li.tautology.common.TestConstants.NB;

import org.junit.Test;

import pl.waw.mizinski.li.tautology.formula.Conjunction;
import pl.waw.mizinski.li.tautology.formula.Disjunction;
import pl.waw.mizinski.li.tautology.formula.Implication;
import pl.waw.mizinski.li.tautology.formula.Negation;

public class SequentTest {
	
	@Test
	public void shouldCheckSequetIsIrreducible() throws Exception {
		assertTrue(new Sequent(A).isIrreducible());
		assertTrue(new Sequent(A, B).isIrreducible());
		assertTrue(new Sequent(A, A).isIrreducible());
		assertTrue(new Sequent(NA).isIrreducible());
		assertTrue(new Sequent(A, NB).isIrreducible());
		assertTrue(new Sequent(A, A , B, NA, NB).isIrreducible());
	}
	
	@Test
	public void shouldCheckSequetIsReducible() throws Exception {
		assertFalse(new Sequent(new Conjunction(A, B)).isIrreducible());
		assertFalse(new Sequent(new Negation(NA)).isIrreducible());
		assertFalse(new Sequent(A, B, new Conjunction(A, A)).isIrreducible());
		assertFalse(new Sequent(A, new Disjunction(A, B)).isIrreducible());
		assertFalse(new Sequent(NA, new Implication(A, B), NB, A).isIrreducible());
	}
	
	@Test
	public void shouldCheckSequentIsPromary() throws Exception {
		assertFalse(new Sequent(A, B).isPrimary());
		assertTrue(new Sequent(A, B, NA).isPrimary());
	}
}
