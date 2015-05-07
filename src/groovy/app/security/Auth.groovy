package app.security

import com.vaadin.grails.Grails
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder

class Auth {

	static Authentication login(String username, String password) {
		UsernamePasswordAuthenticationToken request = new UsernamePasswordAuthenticationToken(username, password)

		AuthenticationManager authenticationManager = Grails.get(AuthenticationManager)
		Authentication result = authenticationManager.authenticate(request)

		SecurityContextHolder.context.authentication = result

		return result
	}

}