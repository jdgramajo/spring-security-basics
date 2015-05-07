package app.security

import com.vaadin.navigator.View
import com.vaadin.navigator.ViewChangeListener

class SecuredViewChangeListener implements ViewChangeListener {

	@Override
	boolean beforeViewChange(ViewChangeListener.ViewChangeEvent event) {
		return ViewSecurity.isViewAccessible(event.newView)
	}

	@Override
	void afterViewChange(ViewChangeListener.ViewChangeEvent event) {
		// nothing to do yet
	} 

}