package pl.waw.mizinski.li.tautology.main;

import pl.waw.mizinski.li.tautology.formula.Formula;
import pl.waw.mizinski.li.tautology.formula.Negation;
import pl.waw.mizinski.li.tautology.tree.TautologyChecker;

public class Main {
	
	public static void main(String[] args) throws Exception {
		String arg = null;
		if (args.length == 0) {
			System.out.println("Niepoprawne wywonie programu, oczekiwano formuły złożonej z znaków $, +, =>, liter oraz nawiasów!");
			System.exit(1);
		} else {
			arg = args[0];
		}
		Formula formula = Formula.parse(arg);
		TautologyChecker checker = new TautologyChecker(formula);
		checker.printTree();
		if (checker.isTautology()) {
			System.out.println("Podana formuła jest tautologią");
		} else {
			System.out.println("Podana formuła nie jest tautologią ponieważ");
			System.out.println("sekwent: " + checker.getCounterexample() + " jest nieredukowalny oraz nie jest prosty");
			Negation negation = new Negation(formula);
			TautologyChecker negationChecker = new TautologyChecker(negation);
			if (negationChecker.isTautology()){
				System.out.println("Formuła nie jest spełnialna ponieważ");
				System.out.println("formuła " + negation +" jest tautologią");
			} else {
				System.out.println("Formuła jest spełnialna ponieważ");
				System.out.println("formuła " + negation +" nie jest tautologią");
			}
			
		}
	}
	
}
