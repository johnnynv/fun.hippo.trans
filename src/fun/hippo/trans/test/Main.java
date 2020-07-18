package fun.hippo.trans.test;

import fun.hippo.trans.enums.LanguageEnum;
import fun.hippo.trans.enums.TransServiceEnum;
import fun.hippo.trans.exceptions.HippoTransException;
import fun.hippo.trans.service.GoogleTranslateService;
import fun.hippo.trans.service.ITranslateService;
import fun.hippo.trans.service.ServiceProvider;

public class Main {
	public static void main(String[] args) {
		for (String str : LanguageEnum.getDisplayArr())
			System.out.println(str);
		for (String str : TransServiceEnum.getServiceNameArr())
			System.out.println(str);

		ITranslateService service;
		try {
			service = ServiceProvider
					.getServiceProvider(TransServiceEnum.GOOGLE
							.getServiceName());
			System.out.println(service.translate("abc"));

		} catch (HippoTransException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}
}
