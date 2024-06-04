package io.github.mikaojk.springbootcrudrestapi

import io.github.mikaojk.springbootcrudrestapi.user.UserRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@Testcontainers
@SpringBootTest
class SpringBootCrudRestApiApplicationTests {
    @Autowired
    lateinit var userRepository: UserRepository

    @Container
    var postgresql: PostgreSQLContainer<*> = PostgreSQLContainer("postgres:14-alpine").apply {
        withCommand("postgres", "-c", "wal_level=logical")
        start()
        System.setProperty("spring.datasource.url", "$jdbcUrl&reWriteBatchedInserts=true")
        System.setProperty("spring.datasource.username", username)
        System.setProperty("spring.datasource.password", password)
    }

    @Test
    fun contextLoads() {
    }

}
