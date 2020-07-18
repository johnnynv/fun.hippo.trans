package fun.hippo.trans.views;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerRow;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import fun.hippo.trans.enums.LanguageEnum;
import fun.hippo.trans.exceptions.HippoTransException;
import fun.hippo.trans.service.ITranslateService;

/**
 * This sample class demonstrates how to plug-in a new workbench view. The view
 * shows data obtained from the model. The sample creates a dummy model on the
 * fly, but a real implementation would connect to the model available either in
 * this or another plug-in (e.g. the workspace). The view is connected to the
 * model using a content provider.
 * <p>
 * The view uses a label provider to define how model objects should be
 * presented in the view. Each view can present the same model objects using
 * different labels and icons, if needed. Alternatively, a single label provider
 * can be shared between views in order to ensure that objects of the same type
 * are presented in the same way everywhere.
 * <p>
 */

public class TranslatorView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "fun.hippo.trans.views.TranslatorView";

	private TableViewer viewer;
	private Action action1;
	private Action action2;
	private Action doubleClickAction;
	
	/*
	 * Components for the translator plugin
	 */
	private ListViewer listViewer;
	private Label lblILang;
	private Label lblOLang;
	private Combo cbILang;
	private Combo cbOLang;
	private Action transAction;
	private Action clickAction;
	private TableViewerRow row1;
	private TableViewerRow row2;
	/*
	 * Translate service provider
	 */
	private ITranslateService service;
	
	/*
	 * The content provider class is responsible for providing objects to the
	 * view. It can wrap existing objects in adapters or simply return objects
	 * as-is. These objects may be sensitive to the current input of the view,
	 * or ignore it and always show the same content (like Task List, for
	 * example).
	 */

//	class ViewContentProvider implements IStructuredContentProvider {
//		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
//		}
//
//		public void dispose() {
//		}
//
//		public Object[] getElements(Object parent) {
//			return new String[] { "One", "Two", "Three" };
//		}
//	}

//	class ViewLabelProvider extends LabelProvider implements
//			ITableLabelProvider {
//		public String getColumnText(Object obj, int index) {
//			return getText(obj);
//		}
//
//		public Image getColumnImage(Object obj, int index) {
//			return getImage(obj);
//		}
//
//		public Image getImage(Object obj) {
//			return PlatformUI.getWorkbench().getSharedImages().getImage(
//					ISharedImages.IMG_OBJ_ELEMENT);
//		}
//	}

//	class NameSorter extends ViewerSorter {
//	}

	/**
	 * The constructor.
	 */
	public TranslatorView() {
		
	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {

		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL);

//		viewer.setContentProvider(new ViewContentProvider());

//		viewer.setLabelProvider(new ViewLabelProvider());

//		viewer.setSorter(new NameSorter());

//		viewer.setInput(getViewSite());

		// Create the help context id for the viewer's control
//		PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(),
//				"fun.hippo.trans.viewer");
//
//		makeActions();
//		hookContextMenu();
//		hookDoubleClickAction();
//		contributeToActionBars();
		initComponents(parent);
	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				TranslatorView.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(action1);
		manager.add(new Separator());
		manager.add(action2);
		
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(action1);
		manager.add(action2);
		manager.add(transAction);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
		
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(action1);
		manager.add(action2);

	}

	private void makeActions() {
		action1 = new Action() {
			public void run() {
				showMessage("Action 1 executed");
			}
		};
		action1.setText("Action 1");
		action1.setToolTipText("Action 1 tooltip");
		action1.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));

		action2 = new Action() {
			public void run() {
				showMessage("Action 2 executed");
			}
		};
		action2.setText("Action 2");
		action2.setToolTipText("Action 2 tooltip");
		action2.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		doubleClickAction = new Action() {
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection) selection)
						.getFirstElement();
				showMessage("Double-click detected on " + obj.toString());
			}
		};

		transAction = new Action() {
			public void run() {
				try {
					showMessage(service.translate(getSelectedText()));
				} catch (HippoTransException e) {
					showMessage(e.getMessage());
				}
			}
		};
		transAction.setText("Translate");
	}

	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});
	}

	private void showMessage(String message) {
		MessageDialog.openInformation(viewer.getControl().getShell(),
				"Translator", message);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
//		viewer.getControl().setFocus();
	}

	private void initComponents(Composite parent) {
		
		lblILang = new Label(parent, SWT.DROP_DOWN);
		lblILang.setText("Input language:");
		
		cbILang = new Combo(parent, SWT.DROP_DOWN);
		cbILang.setItems(LanguageEnum.getDisplayArr());
		cbILang.setSize(100, 30);
		
		lblOLang = new Label(parent, SWT.DROP_DOWN);
		lblOLang.setText("Output language:");

		cbOLang = new Combo(parent, SWT.DROP_DOWN);
		cbOLang.setItems(LanguageEnum.getDisplayArr());
		
		setDefaultComboChoices();
		
	}
	
	
	private void setDefaultComboChoices(){
		//Set default choice for input language and output language
		//Default input as Japanese
		cbILang.select(LanguageEnum.JAPANESE.getLangNo());
		//Default output as Vietnamese
		cbOLang.select(LanguageEnum.VIETNAMESE.getLangNo());
	}
	
	private String getSelectedText() {
		IEditorPart part;

		part = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActiveEditor();
		
		// if(part instanceof ITextEditor){
		// ITextEditor editor = (ITextEditor)part;
		// IDocumentProvider provider = editor.getDocumentProvider();
		// IDocument document = provider.getDocument(editor.getEditorInput());
		return null;
	}
}