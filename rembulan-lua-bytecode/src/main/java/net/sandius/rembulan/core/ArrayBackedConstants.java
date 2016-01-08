package net.sandius.rembulan.core;

import net.sandius.rembulan.util.Check;
import net.sandius.rembulan.util.ReadOnlyArray;

import java.util.ArrayList;

public class ArrayBackedConstants extends AbstractConstants {

	private final ReadOnlyArray<Object> consts;

	public ArrayBackedConstants(ReadOnlyArray<Object> consts) {
		Check.notNull(consts);
		this.consts = consts;

		// validate
		for (Object o : consts) {
			if (!(o == null
					|| o instanceof Boolean
					|| o instanceof Long
					|| o instanceof Double
					|| o instanceof String)) {
				throw new IllegalArgumentException("Illegal constant of type " + o.getClass().getCanonicalName() + ": " + o.toString());
			}
		}
	}

	@Override
	public int size() {
		return consts.size();
	}

	@Override
	public boolean isNil(int idx) {
		return consts.get(idx) == null;
	}

	@Override
	public boolean isBoolean(int idx) {
		return consts.get(idx) instanceof Boolean;
	}

	@Override
	public boolean isInteger(int idx) {
		return consts.get(idx) instanceof Long;
	}

	@Override
	public boolean isFloat(int idx) {
		return consts.get(idx) instanceof Double;
	}

	@Override
	public boolean isString(int idx) {
		return consts.get(idx) instanceof String;
	}

	@Override
	public boolean getBoolean(int idx) {
		return (Boolean) consts.get(idx);
	}

	@Override
	public long getInteger(int idx) {
		return (Long) consts.get(idx);
	}

	@Override
	public double getFloat(int idx) {
		return (Double) consts.get(idx);
	}

	@Override
	public String getString(int idx) {
		return (String) consts.get(idx);
	}

}