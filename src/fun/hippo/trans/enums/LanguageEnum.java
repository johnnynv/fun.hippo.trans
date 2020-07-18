package fun.hippo.trans.enums;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public enum LanguageEnum {
	
	VIETNAMESE(0, "vi", "VN", "Tiếng Việt"), 
	ENGLISH(1, "en", "US", "English"), 
	JAPANESE(2, "ja", "JP", "日本語");
	private int langNo;
	private String langCode;
	private String locale;
	private String display;

	private LanguageEnum(int _langNo, String _langCode, String _locale, String _display) {
		this.langNo = _langNo;
		this.langCode = _langCode;
		this.locale = _locale;
		this.display = _display;
	}
	
	public int getLangNo(){
		return this.langNo;
	}
	
	public String getLangCode() {
		return this.langCode;
	}

	public String getLocale() {
		return this.locale;
	}

	public String getDisplay() {
		return this.display;
	}

	public String getSpecificCombination() {
		return this.langCode + "-" + this.locale;
	}

	public static String[] getDisplayArr() {
		List<String> temp = new ArrayList<String>();
		for (LanguageEnum _enum : EnumSet.allOf(LanguageEnum.class)) {
			temp.add(_enum.getDisplay());
		}
		return temp.toArray(new String[0]);
	}

	@Override
	public String toString() {
		return getDisplay();
	}
}
