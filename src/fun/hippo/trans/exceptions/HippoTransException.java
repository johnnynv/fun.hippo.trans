package fun.hippo.trans.exceptions;

public class HippoTransException extends Exception{
	
	private static final long serialVersionUID = 1L;
	private String pMessage;
	
	public HippoTransException(String pMessage){
		this.pMessage = pMessage;
	}
	
	@Override
	public String getMessage() {
		return this.pMessage;
	}
}
