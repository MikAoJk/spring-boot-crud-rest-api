package io.github.mikaojk.springbootcrudrestapi.user

import org.springframework.web.bind.annotation.*

@RestController
class UserAPiController(private val userService: UserService) {

    @PostMapping("/user")
    fun saveUser(
        @RequestBody user: User
    ): User? {
        return userService.saveUser(user)
    }

    @GetMapping("/users/")
    fun fetchUserList(): MutableIterable<User> {
        return userService.fetchUserList()
    }

    @PutMapping("/user/{id}")
    fun updateUser(
        @RequestBody user: User,
        @PathVariable("id") userid: Long
    ): User? {
        return userService.updateUser(
            user, userid
        )
    }

    @DeleteMapping("/user/{id}")
    fun deleteUserById(@PathVariable("id") userid: Long): String {
        userService.deleteUserById(
            userid
        )
        return "Deleted Successfully"
    }
}
