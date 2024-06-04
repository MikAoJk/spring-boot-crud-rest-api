package io.github.mikaojk.springbootcrudrestapi

import io.github.mikaojk.springbootcrudrestapi.user.UserRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@Testcontainers
@SpringBootTest
class SpringBootCrudRestApiApplicationTests {
    @Autowired
    lateinit var userRepository: UserRepository

    @Container
    @ServiceConnection
    var postgresql: PostgreSQLContainer<*> = PostgreSQLContainer("postgres:14-alpine")


    @Test
    fun contextLoads() {
    }

}
