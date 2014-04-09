package pl.waw.mizinski.li.tautology.tree;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import static pl.waw.mizinski.li.tautology.common.TestConstants.A;
import static pl.waw.mizinski.li.tautology.common.TestConstants.NA;
import static pl.waw.mizinski.li.tautology.common.TestConstants.NB;

import java.io.PrintStream;
import java.util.Arrays;

import org.junit.Test;

import pl.waw.mizinski.li.tautology.formula.Formula;
import pl.waw.mizinski.li.tautology.formula.Literal;

public class TautologyCheckerTest {

	@Test
	public void shouldVerifyTautology() throws Exception {
		Formula tautology = Formula.parse("A => A");
		assertTrue(new TautologyChecker(tautology).isTautology());
		Formula tautology2 = Formula.parse("(((A=>B)&(B=>C)))=>~(A&~C)");
		assertTrue(new TautologyChecker(tautology2).isTautology());
	}

	@Test
	public void shouldVeryfyNonTautology() throws Exception {
		Formula formula = Formula.parse("A & ~A");
		assertFalse(new TautologyChecker(formula).isTautology());
		Formula formula2 = Formula.parse("(((A=>B)&(C=>B))=>~(A&~C))");
		assertFalse(new TautologyChecker(formula2).isTautology());
	}

	@Test
	public void shouldGetCounterexample() throws Exception {
		Formula formula = Formula.parse("A & ~A");
		Sequent counterexample = new TautologyChecker(formula).getCounterexample();
		assertTrue(counterexample.size() == 1);
		assertTrue(counterexample.contains(A) || counterexample.contains(NA));
		Formula formula2 = Formula.parse("(((A=>B)&(C=>B))=>~(A&~C))");
		Sequent counterexample2 = new TautologyChecker(formula2)
				.getCounterexample();
		assertTrue(counterexample2.size() == 3);
		assertTrue(counterexample2.containsAll(Arrays.asList(NA, NB, new Literal("C"))));
	}

	@Test
	public void shouldPrintTree() throws Exception {
		PrintStream out = mock(PrintStream.class);
		System.setOut(out);
		Formula tautology = Formula.parse("(((A=>B)&(B=>C)))=>~(A&~C)");
		new TautologyChecker(tautology).printTree();
		verify(out, times(11)).println(any(Sequent.class));
	}

	@Test
	public void shouldDoNotPrintTree() throws Exception {
		PrintStream out = mock(PrintStream.class);
		System.setOut(out);
		Formula tautology = Formula.parse("(((A=>B)&(B=>C)))=>~(A&~C)");
		TautologyChecker tc = new TautologyChecker(tautology);
		tc.isTautology();
		tc.getCounterexample();
		verify(out, never()).println(any(Sequent.class));
	}
}
