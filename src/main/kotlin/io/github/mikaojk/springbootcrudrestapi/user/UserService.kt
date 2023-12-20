package io.github.mikaojk.springbootcrudrestapi.user

import org.springframework.stereotype.Service


@Service
class UserService(private val userRepository: UserRepository) {

    fun saveUser(user: User): User {
        return userRepository.save(user)
    }

    fun fetchUserList(): MutableIterable<User> {
        return userRepository.findAll()
    }

    fun fetchUser(id: Long) : User? {
        return userRepository.findById(id).orElse(null)
    }

    fun updateUser(user: User, userId: Long): User {
        val userDB: User = userRepository.findById(userId).get()
        return userDB
    }

    fun deleteUserById(userId: Long) {
        userRepository.deleteById(userId)
    }
}
