package io.github.mikaojk.springbootcrudrestapi.service

import io.github.mikaojk.springbootcrudrestapi.user.User
import io.github.mikaojk.springbootcrudrestapi.user.UserRepository
import org.springframework.stereotype.Service


@Service
class UserService(private val userRepository: UserRepository) {

    fun saveUser(user: User): User {
        return userRepository.save(user)
    }

    fun fetchUserList(): MutableIterable<User> {
        return userRepository.findAll()
    }

    fun updateUser(user: User, userId: Long): User {
        val userDB: User = userRepository.findById(userId).get()
        return userDB
    }

    fun deleteUserById(userId: Long) {
        userRepository.deleteById(userId)
    }

}