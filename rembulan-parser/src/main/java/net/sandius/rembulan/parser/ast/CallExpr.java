package net.sandius.rembulan.parser.ast;

import net.sandius.rembulan.util.Check;

import java.util.List;

public abstract class CallExpr extends Expr {

	protected final List<Expr> args;

	protected CallExpr(Attributes attr, List<Expr> args) {
		super(attr);
		this.args = Check.notNull(args);
	}

	public List<Expr> args() {
		return args;
	}

	public static class FunctionCallExpr extends CallExpr {

		private final Expr fn;

		public FunctionCallExpr(Attributes attr, Expr fn, List<Expr> args) {
			super(attr, args);
			this.fn = Check.notNull(fn);
		}

		public Expr fn() {
			return fn;
		}

		public FunctionCallExpr update(Expr fn, List<Expr> args) {
			if (this.fn.equals(fn) && this.args.equals(args)) {
				return this;
			}
			else {
				return new FunctionCallExpr(attributes(), fn, args);
			}
		}

		@Override
		public Expr accept(Transformer tf) {
			return tf.transform(this);
		}

	}

	public static class MethodCallExpr extends CallExpr {

		private final Expr target;
		private final Name methodName;

		public MethodCallExpr(Attributes attr, Expr target, Name methodName, List<Expr> args) {
			super(attr, args);
			this.target = Check.notNull(target);
			this.methodName = Check.notNull(methodName);
		}

		public Expr target() {
			return target;
		}

		public Name methodName() {
			return methodName;
		}

		public MethodCallExpr update(Expr target, Name methodName, List<Expr> args) {
			if (this.target.equals(target) && this.methodName.equals(methodName) && this.args.equals(args)) {
				return this;
			}
			else {
				return new MethodCallExpr(attributes(), target, methodName, args);
			}
		}

		@Override
		public Expr accept(Transformer tf) {
			return tf.transform(this);
		}

	}

}