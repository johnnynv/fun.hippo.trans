package fun.hippo.trans.service;

import fun.hippo.trans.exceptions.HippoTransServiceException;

public interface ITranslateService {
	
	boolean init();

	String translate(String input) throws HippoTransServiceException;

	boolean flush();
}
