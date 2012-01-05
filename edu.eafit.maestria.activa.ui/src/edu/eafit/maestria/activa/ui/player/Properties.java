package edu.eafit.maestria.activa.ui.player;

import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.databinding.fieldassist.ControlDecorationSupport;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.handlers.CollapseAllHandler;
import org.eclipse.wb.swt.SWTResourceManager;

import edu.eafit.maestria.activa.model.IEntity;
import edu.eafit.maestria.activa.model.IResource;
import edu.eafit.maestria.activa.model.ITaggedResource;
import edu.eafit.maestria.activa.model.IType;
import edu.eafit.maestria.activa.ui.model.EntityWrapper;
import edu.eafit.maestria.activa.ui.model.ModelProvider;
import edu.eafit.maestria.activa.ui.model.PropertyWrapper;
import edu.eafit.maestria.activa.ui.model.TaggedResourceWrapper;
import edu.eafit.maestria.activa.ui.utils.Messages;

public class Properties extends Composite {
	private EntityWrapper entity;
	
	private Canvas thumbnail;
	private Text nameInput;
	private Text descriptionInput;
	private ComboViewer comboViewer;
//	private Button newProperty;
	private Button delProperty;
	private TableViewer propertiesViewer;
	private Button newResource;
	private Button delResource;
	private TableViewer resourcesViewer;

	/**
	 * Create the composite.
	 * @param player 
	 * @param parent
	 * @param style
	 */
	public Properties(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(3, false));
		new Label(this, SWT.NONE);// to make the table structure valid
		
		createElements();
		registerListeners();
		
	}

	private void createElements() {
		thumbnail = new Canvas(this, SWT.NONE);
		GridData gd_thumbnail = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_thumbnail.heightHint = 154;
		gd_thumbnail.widthHint = 181;
		thumbnail.setLayoutData(gd_thumbnail);
		thumbnail.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		new Label(this, SWT.NONE);
		
		Label name = new Label(this, SWT.NONE);
		name.setText(Messages.PROPERTIES_NAME);
		
		nameInput = new Text(this, SWT.BORDER);
		GridData gd_nameInput = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
		gd_nameInput.widthHint = 235;
		nameInput.setLayoutData(gd_nameInput);
		
		Label description = new Label(this, SWT.NONE);
		description.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		description.setText(Messages.PROPERTIES_DESCRIPTION);
		
		descriptionInput = new Text(this, SWT.BORDER | SWT.MULTI);
		GridData gd_descriptionInput = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
		gd_descriptionInput.heightHint = 77;
		gd_descriptionInput.widthHint = 236;
		descriptionInput.setLayoutData(gd_descriptionInput);
		
		Label type = new Label(this, SWT.NONE);
		type.setText(Messages.PROPERTIES_TYPE);
		
		comboViewer = new ComboViewer(this, SWT.READ_ONLY);
		comboConfig();
		Combo typeCmb = comboViewer.getCombo();
		GridData gd_typeCmb = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
		gd_typeCmb.widthHint = 240;
		typeCmb.setLayoutData(gd_typeCmb);
		
		Label properties = new Label(this, SWT.NONE);
		properties.setText(Messages.PROPERTIES_PROPERTIES);
		new Label(this, SWT.NONE);
		
		delProperty = new Button(this, SWT.NONE);
		delProperty.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		delProperty.setText("-");
		delProperty.setToolTipText(Messages.PROPERTIES_DELETE_PROPERTY);
		
		propertiesViewer = new TableViewer(this, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER | SWT.FULL_SELECTION);
		createPropertiesColumns();
		propertiesViewer.setContentProvider(new ArrayContentProvider());
		
		Table propertiesTable = propertiesViewer.getTable();
		GridData gd_propertiesTable = new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1);
		gd_propertiesTable.heightHint = 104;
		gd_propertiesTable.widthHint = 302;
		propertiesTable.setLayoutData(gd_propertiesTable);
		propertiesTable.setLinesVisible(true);
		propertiesTable.setHeaderVisible(true);
		
		Label resources = new Label(this, SWT.NONE);
		resources.setText(Messages.PROPERTIES_RESOURCES);
		
		newResource = new Button(this, SWT.NONE);
		newResource.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		newResource.setText("+");
		newResource.setToolTipText(Messages.PROPERTIES_NEW_RESOURCE);
		
		delResource = new Button(this, SWT.NONE);
		delResource.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		delResource.setText("-");
		delResource.setToolTipText(Messages.PROPERTIES_DELETE_RESOURCE);
		
		resourcesViewer =new TableViewer(this, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER | SWT.FULL_SELECTION);
		createResourcesColumns();
		resourcesViewer.setContentProvider(new ArrayContentProvider());
		
		Table resourcesTable = resourcesViewer.getTable();
		GridData gd_resourcesTable = new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1);
		gd_resourcesTable.heightHint = 103;
		gd_resourcesTable.widthHint = 302;
		resourcesTable.setLayoutData(gd_resourcesTable);
		resourcesTable.setLinesVisible(true);
		resourcesTable.setHeaderVisible(true);
	}

	private void createPropertiesColumns() {
		//name
		TableViewerColumn col = createTableViewerColumn(propertiesViewer, Messages.PROPERTIES_NAME_COLUMN, 157, 0);
		col.setLabelProvider(
			new CellLabelProvider() {
				@Override
				public void update(ViewerCell cell) {
					cell.setText(((PropertyWrapper) cell.getElement()).getKey());
				}
			}
		);
		col.setEditingSupport(new PropertyKeyEditingSupport(propertiesViewer));
		//value
		col = createTableViewerColumn(propertiesViewer, Messages.PROPERTIES_VALUE_COLUMN, 157, 1);
		col.setLabelProvider(
			new CellLabelProvider() {
				@Override
				public void update(ViewerCell cell) {
					cell.setText(((PropertyWrapper) cell.getElement()).getValue());
				}
			}
		);
		col.setEditingSupport(new PropertyValueEditingSupport(propertiesViewer));
	}

	private void createResourcesColumns() {
		//name
		TableViewerColumn col = createTableViewerColumn(resourcesViewer, Messages.PROPERTIES_NAME_COLUMN, 157, 0);
		col.setLabelProvider(
			new CellLabelProvider() {
				@Override
				public void update(ViewerCell cell) {
					cell.setText(((TaggedResourceWrapper) cell.getElement()).getTag().getName());
				}
			}
		);
		col.setEditingSupport(new TagEditingSupport(resourcesViewer));
		//value
		col = createTableViewerColumn(resourcesViewer, Messages.PROPERTIES_VALUE_COLUMN, 157, 1);
		col.setLabelProvider(
			new CellLabelProvider() {
				@Override
				public void update(ViewerCell cell) {
					IResource resource = ((TaggedResourceWrapper) cell.getElement()).getResource();
					String name = "";
					if (resource != null)
						name = resource.getName();
					cell.setText(name);
				}
			}
		);
		col.setEditingSupport(new ResourceEditingSupport(resourcesViewer));
	}
	
	private TableViewerColumn createTableViewerColumn(TableViewer tableViewer, String title, int bound, final int colNumber) {
		final TableViewerColumn viewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		final TableColumn column = viewerColumn.getColumn();
		column.setText(title);
		column.setWidth(bound);
		column.setResizable(true);
		return viewerColumn;
	}

	private void comboConfig() {
		comboViewer.setContentProvider(new ArrayContentProvider());
		comboViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof IType) {
					IType type = (IType)element;
					return type.getLabel();
				}
				return super.getText(element);
			}
		});
		comboViewer.setInput(ModelProvider.INSTANCE.getTypes());
		
		comboViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection selection = (IStructuredSelection) event.getSelection();
				IType type = (IType) selection.getFirstElement();
				entity.setType(type);
			}
		});
		
	}

	private void registerListeners(){
//		newProperty.addSelectionListener(listener);
		delProperty.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					deleteProperty();
				}

		});
		
		//TODO para volver a poner el keylistener hay que hacer mas bien el delete property en un command
		//y ver como la tecla DEL que ya esta en el plugin.xml puede manejar 2 acciones dependiendo de lo que este
		//seleccionado, o la ventana o el player, etc
//		propertiesViewer.getTable().addKeyListener(new KeyAdapter() {
//			
//			@Override
//			public void keyPressed(KeyEvent e) {
//				if (e.keyCode == SWT.DEL) {
//					deleteProperty();
//				}
//				
//			}
//		});
		
//		newResource.addSelectionListener(listener);
		delResource.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				deleteResource();
			}

		});
	}
	
	private void deleteProperty() {
		if (!propertiesViewer.getSelection().isEmpty()) {
			ISelection selection =  propertiesViewer.getSelection();
			if (selection != null && selection instanceof IStructuredSelection) {
				
				IStructuredSelection sel = (IStructuredSelection) selection;
				for (Iterator<PropertyWrapper> iterator = sel.iterator(); iterator.hasNext();) {
					PropertyWrapper property = iterator.next();
					entity.removeProperty(property);
				}
				propertiesViewer.refresh();
			}
		}
	}
	
	private void deleteResource() {
		if (!resourcesViewer.getSelection().isEmpty()) {
			ISelection selection =  resourcesViewer.getSelection();
			if (selection != null && selection instanceof IStructuredSelection) {
				
				IStructuredSelection sel = (IStructuredSelection) selection;
				for (Iterator<ITaggedResource> iterator = sel.iterator(); iterator.hasNext();) {
					ITaggedResource resource = iterator.next();
					entity.getTaggedResources().remove(resource);
				}
				resourcesViewer.refresh();
			}
		}
	}
	
	private void bindValues(){
		DataBindingContext ctx = new DataBindingContext();
		//name
		IObservableValue widgetValue = WidgetProperties.text(SWT.Modify).observe(nameInput);
		IObservableValue modelValue = BeanProperties.value(EntityWrapper.class,	"name").observe(entity);
		IValidator validator = new IValidator() {
			@Override
			public IStatus validate(Object value) {
				String s = (String) value;
				if (StringUtils.isBlank(s)) {
					return ValidationStatus.error("Name should't be empty");
				}
				return ValidationStatus.ok();
			}
		};

		UpdateValueStrategy strategy = new UpdateValueStrategy();
		strategy.setBeforeSetValidator(validator);
		Binding bindValue = ctx.bindValue(widgetValue, modelValue, strategy, null);
		ControlDecorationSupport.create(bindValue, SWT.TOP | SWT.LEFT);
		
		//desc
		widgetValue = WidgetProperties.text(SWT.Modify).observe(descriptionInput);
		modelValue = BeanProperties.value(EntityWrapper.class,	"description").observe(entity);
		ctx.bindValue(widgetValue, modelValue);
	}
	
	public void setEntity(IEntity entity) {
		this.entity = new EntityWrapper(entity);
		//TODO asi se selecciona el que corresponde al objeto seleccionado
		//comboViewer.setSelection(new StructuredSelection(entity.getType()));
		
		propertiesViewer.setInput(this.entity.getProperties());
		resourcesViewer.setInput(this.entity.getTaggedResources());
		
		bindValues();
	}
	
	public IEntity getEntity(){
		return entity.getWrappedEntity();
	}
	
	public void setEnabled(boolean enabled){
		if (!enabled) {
			//TODO inicializar los campos nuevamente
		}
		super.setEnabled(enabled);
	}
	
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
