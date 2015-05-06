package app.security

import grails.transaction.Transactional

@Transactional
class UserService {

    User findByUserNameAndPassword(String username, String password) {
    	User user = User.findByUserNameAndPassword(username, password)
    	return user
    }
}
