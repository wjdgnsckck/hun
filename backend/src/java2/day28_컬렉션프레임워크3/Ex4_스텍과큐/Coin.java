package java2.day28_컬렉션프레임워크3.Ex4_스텍과큐;

public class Coin {

	private int value;

	public int getValue() {
		return value;
	}

	public Coin(int value) {
		super();
		this.value = value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Coin [value=" + value + "]";
	}
	
	
	
}
