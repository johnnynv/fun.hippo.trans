package fun.hippo.trans.enums;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public enum TransServiceEnum {

	GOOGLE(1, "fun.hippo.trans.service.GoogleTranslateService", "Google Translate");

	private int serviceNo;
	private String serviceClass;
	private String serviceName;

	private TransServiceEnum(int _serviceNo, String _serviceClass,
			String _serviceName) {
		this.serviceNo = _serviceNo;
		this.serviceClass = _serviceClass;
		this.serviceName = _serviceName;
	}

	public int getServiceNo() {
		return serviceNo;
	}

	public String getServiceClass() {
		return serviceClass;
	}

	public String getServiceName() {
		return serviceName;
	}

	public static String[] getServiceNameArr() {
		List<String> temp = new ArrayList<String>();
		for (TransServiceEnum _enum : EnumSet.allOf(TransServiceEnum.class)) {
			temp.add(_enum.getServiceName());
		}
		return temp.toArray(new String[0]);
	}

	@Override
	public String toString() {
		return this.getServiceName();
	}

}
