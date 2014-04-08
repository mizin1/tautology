package pl.waw.mizinski.li.tautology.tree.operations;

import java.util.List;

import pl.waw.mizinski.li.tautology.tree.Sequent;

public interface Operation {
	
	List<Sequent> doOperation(Sequent sequent);
	
	boolean isOperationPossible(Sequent sequent);
}
