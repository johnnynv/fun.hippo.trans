package fun.hippo.trans.service;

public class GoogleTranslateService implements
		ITranslateService {

	protected GoogleTranslateService() {

	}

	@Override
	public String translate(String input) {
		
		return "Using GGTrans";
	}

	@Override
	public boolean flush() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean init() {
		// TODO Auto-generated method stub
		return false;
	}

}
