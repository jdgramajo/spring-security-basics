package app.security

import com.vaadin.navigator.View
import org.springframework.security.authentication.InternalAuthenticationServiceException
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder

class ViewSecurity {

	private static Map<Class<? extends View>, List<String>> views = [:]

	static add(Class<? extends View> view, List<String> roles) {
		views.put(view, roles)
	}

	static boolean isViewAccessible(View view) {

		List<String> roles = views.get(view.class)
		if(!roles) {
			// If roles is null, then access is public (not secured)
			return true
		}

		Authentication authentication = SecurityContextHolder.context.authentication
		if(!authentication) {
			throw new InternalAuthenticationServiceException('No authentication found in context.')
		}

		List<GrantedAuthority> authorities = authentication.authorities

		roles.each {
			boolean isRoleAssigned = it in authorities*.authority
			if(isRoleAssigned) {
				return
			}
		}

		return false

	}

}