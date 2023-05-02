package chap01;

public class Greater {
	
	private String format;
	
	public String great(String guest) {
		return String.format(format,  guest);
	}
	
	public void setFormat(String format) {
		this.format = format;
	}
	
	
}
