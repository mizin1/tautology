package pl.waw.mizinski.li.tautology.parser.token;

public class LiteralToken extends Token{
	
	private String value;

	public LiteralToken(String value) {
		this.value = value;
	}
	
	public LiteralToken(char c) {
		this.value = String.valueOf(c);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
