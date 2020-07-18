package fun.hippo.trans.service;

import fun.hippo.trans.enums.TransServiceEnum;
import fun.hippo.trans.exceptions.HippoTransException;
import fun.hippo.trans.exceptions.HippoTransReflectionException;

public class ServiceProvider {
	private static ITranslateService service;

	public static ITranslateService getServiceProvider(String _serviceName)
			throws HippoTransException {
		if (null != service)
			service.flush();
		for (TransServiceEnum _enum : TransServiceEnum.values()) {
			if (_enum.getServiceName().equals(_serviceName)) {
				try {
					service = (ITranslateService) Class.forName(_enum.getServiceClass()).newInstance();
				} catch (InstantiationException  e) {
					throw new HippoTransReflectionException("Instantiation failed.");
				} catch (IllegalAccessException e) {
					throw new HippoTransReflectionException("Instantiation failed.");
				} catch (ClassNotFoundException e) {
					throw new HippoTransReflectionException("Instantiation failed.");
				} catch (NullPointerException e) {
					throw new HippoTransReflectionException("Instantiation failed.");
				}
			}
		}

		return service;
	}

}
