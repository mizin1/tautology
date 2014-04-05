package pl.waw.mizinski.li.tautology.main;

import pl.waw.mizinski.li.tautology.formula.Formula;
import pl.waw.mizinski.li.tautology.parser.Parser;
import pl.waw.mizinski.li.tautology.tree.Operation;
import pl.waw.mizinski.li.tautology.tree.RemoveConjunction;
import pl.waw.mizinski.li.tautology.tree.RemoveDisjunction;
import pl.waw.mizinski.li.tautology.tree.RemoveImplication;
import pl.waw.mizinski.li.tautology.tree.RemoveNonLiteralNegation;
import pl.waw.mizinski.li.tautology.tree.Sequent;

public class Main {
	
	static Operation[] operations = {	
		new RemoveConjunction(), new RemoveDisjunction(), new RemoveImplication(), new RemoveNonLiteralNegation()
	};
	
	public static void main(String[] args) throws Exception {
//		Formula formula = new Conjunction(new Implication(new Negation(new Literal("A")), new Literal("B")), new Disjunction(new Literal("C"), new Literal("A")));
//		Sequent sequent = new Sequent(formula);
//		checkSequent(sequent, "");
		String a = "(((A=>B)&(B=>C))=>~(A&~C))";
		Formula formula = new Parser(a).getFormula();
		checkSequent(new Sequent(formula), "");
		
	}
	
	private static void checkSequent(Sequent sequent, String spaces) {
		System.out.print(spaces);
		System.out.println(sequent );//+ " " + sequent.isIrreducible() + " " + sequent.isPrimary() );
		for (Operation operation : operations) {
			if (operation.isOperationPossible(sequent)){
				for(Sequent sequent2 : operation.doOperation(sequent)){
					checkSequent(sequent2, spaces + "\t");
				}
				break;
			}
		}
	}
}
