package fun.hippo.trans.exceptions;

public class HippoTransServiceException extends HippoTransException{

	private static final long serialVersionUID = 1L;

	public HippoTransServiceException(String pMessage) {
		super(pMessage);
	}
	
	@Override
	public String getMessage() {
		return "Service: " + super.getMessage();
	}

}
