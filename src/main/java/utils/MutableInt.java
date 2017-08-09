package utils;

public class MutableInt {

	private int value;

	public MutableInt() {
		value = 1;
	}

	public void increment() {
		value++;
	}

	public int get() {
		return value;
	}

	@Override
	public String toString() {
		return Integer.toString(value);
	}
}
