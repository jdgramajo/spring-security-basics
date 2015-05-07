import app.security.Role
import app.security.User

class BootStrap {

    def init = { servletContext ->
        Role adminRole = new Role(name: 'ADMIN')
        adminRole.save(failOnError: true)
        Role userRole = new Role(name: 'USER')
        userRole.save(failOnError: true)

        User user = new User()
        user.username = "john"
        user.password = "john"
        user.enabled = true
        user.accountNonExpired = true
        user.accountNonLocked = true
        user.credentialsNonExpired = true
        user.roles = []
        user.roles << userRole
        user.roles << adminRole
        user.save(failOnError: true)
    }
    def destroy = {
    }
}