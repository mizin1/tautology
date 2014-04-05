package pl.waw.mizinski.li.tautology.tree;

import java.util.List;

public interface Operation {
	
	List<Sequent> doOperation(Sequent sequent);
	
	boolean isOperationPossible(Sequent sequent);
}
