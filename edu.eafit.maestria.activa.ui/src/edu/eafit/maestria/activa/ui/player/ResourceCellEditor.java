package edu.eafit.maestria.activa.ui.player;

import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;

public class ResourceCellEditor extends DialogCellEditor {

	public ResourceCellEditor(Composite parent) {
		super(parent);
	}
	
	@Override
	protected Object openDialogBox(Control cellEditorWindow) {
		FileDialog fileDialog = new FileDialog(getControl().getShell());
		
		String value = (String) getValue();

        if (getValue() != null) {
           fileDialog.setFileName(value);
        }
        
        // Open Dialog and save result of selection
        String data = fileDialog.open();
			
        if (data != null) {
        	return data;
        }

        return getValue();
        
	}

}
