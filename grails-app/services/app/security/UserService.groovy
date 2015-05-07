package app.security

import grails.transaction.Transactional

@Transactional
class UserService {

    User findByUsernameAndPassword(String username, String password) {
    	User user = User.findByUsernameAndPassword(username, password)
    	return user
    }
}
