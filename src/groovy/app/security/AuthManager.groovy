package app.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.GrantedAuthority

class AuthManager implements AuthenticationManager {

	@Autowired
	private UserService userService

	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		String username = auth.principal as String
		String password = auth.credentials as String

		User user = userService.findByUsernameAndPassword(username, password)
		if(user != null) {
			Collection<? extends GrantedAuthority> authorities = user.authorities
			return new UsernamePasswordAuthenticationToken(username, password, authorities)
		}

		throw new BadCredentialsException("Bad Credentials")
	}

}