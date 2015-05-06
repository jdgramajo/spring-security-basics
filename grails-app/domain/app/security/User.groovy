package app.security

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class User implements UserDetails {

    String username
    String password
    boolean accountNonExpired
    boolean accountNonLocked
    boolean credentialsNonExpired
    boolean enabled

    static hasMany = [roles: Role]

    static constraints = {
    }

    @Override
    Collection<? extends GrantedAuthority> getAuthorities() {
        println roles
        return roles.collect { Role authority ->
            new SimpleGrantedAuthority(authority.name)
        }
    }

    @Override
    boolean isAccountNonExpired() {
        return accountNonExpired
    }

    @Override
    boolean isAccountNonLocked() {
        return accountNonLocked
    }

    @Override
    boolean isCredentialsNonExpired() {
        return credentialsNonExpired
    }

    @Override
    boolean isEnabled() {
        return enabled
    }
}