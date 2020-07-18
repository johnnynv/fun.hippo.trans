package fun.hippo.trans.views;

import org.eclipse.jface.action.Separator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.ViewPart;

import fun.hippo.trans.enums.LanguageEnum;
import fun.hippo.trans.service.ITranslateService;

public class HippoTranslatorView extends ViewPart {

	private Label lblFlow;
	private Combo cbInLang;
	private Combo cbOutLang;

	private ITranslateService service;

	private void initControl(Composite parent) {

//		Composite firstRow = new Composite(parent, SWT.WRAP);
		cbInLang = new Combo(parent, SWT.LEFT);
		cbInLang.setItems(LanguageEnum.getDisplayArr());
		cbInLang.select(0);
		
		lblFlow = new Label(parent, SWT.CENTER);
		lblFlow.setText(">>");

		cbOutLang = new Combo(parent, SWT.RIGHT);
		cbOutLang.setItems(LanguageEnum.getDisplayArr());
		cbOutLang.select(0);
		
			
	}
	
	private void setEventListener(){
		
	}

	/**
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		initControl(parent);

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
