package fun.hippo.trans.exceptions;

public class HippoTransReflectionException extends HippoTransException {

	public HippoTransReflectionException(String pMessage) {
		super(pMessage);
	}

	@Override
	public String getMessage() {
		return "Reflection: " + super.getMessage();
	}
}
