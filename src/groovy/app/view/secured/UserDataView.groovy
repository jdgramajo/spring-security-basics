package app.view.secured

import com.vaadin.navigator.View
import com.vaadin.navigator.ViewChangeListener
import com.vaadin.ui.Label
import com.vaadin.ui.VerticalLayout

class UserDataView extends VerticalLayout implements View {

	static final String VIEW_NAME = "secured"

	@Override
	void enter(ViewChangeListener.ViewChangeEvent event) {
		setMargin(true)
		addComponent(new Label("Secured content, only after login!"))
	}

}