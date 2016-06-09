package net.sandius.rembulan.parser.ast;

import net.sandius.rembulan.util.Check;

public class Var implements LValue {

	private final Name name;

	public Var(Name name) {
		this.name = Check.notNull(name);
	}

}