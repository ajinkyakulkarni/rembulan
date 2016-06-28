package net.sandius.rembulan.compiler;

import net.sandius.rembulan.compiler.ir.UpVar;
import net.sandius.rembulan.compiler.ir.Var;
import net.sandius.rembulan.util.Check;

import java.util.List;
import java.util.Objects;

public class IRFunc {

	private final FunctionId id;
	private final List<Var> params;
	private final List<UpVar> upvals;
	private final Blocks blocks;

	public IRFunc(FunctionId id, List<Var> params, List<UpVar> upvals, Blocks blocks) {
		this.id = Check.notNull(id);
		this.params = Check.notNull(params);
		this.upvals = Check.notNull(upvals);
		this.blocks = Check.notNull(blocks);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		IRFunc that = (IRFunc) o;
		return id.equals(that.id)
				&& params.equals(that.params)
				&& upvals.equals(that.upvals)
				&& blocks.equals(that.blocks);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, params, blocks);
	}

	public FunctionId id() {
		return id;
	}

	public List<Var> params() {
		return params;
	}

	public List<UpVar> upvals() {
		return upvals;
	}

	public Blocks blocks() {
		return blocks;
	}

	public IRFunc update(Blocks blocks) {
		if (this.blocks.equals(blocks)) {
			return this;
		}
		else {
			return new IRFunc(id, params, upvals, blocks);
		}
	}

}