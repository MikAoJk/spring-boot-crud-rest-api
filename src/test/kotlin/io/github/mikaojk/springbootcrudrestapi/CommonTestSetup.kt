package io.github.mikaojk.springbootcrudrestapi

import io.github.mikaojk.springbootcrudrestapi.user.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import kotlin.concurrent.thread


@Testcontainers
@SpringBootTest(classes = [SpringBootCrudRestApiApplication::class])
abstract class CommonTestSetup {

    @Autowired
    lateinit var userRepository: UserRepository

    companion object {

        @Container
        @ServiceConnection
        @JvmStatic
        var postgreSQLContainer14 = PostgreSQLContainer("postgres:14-alpine").apply {
            withCommand("postgres", "-c", "wal_level=logical")
            start()
            System.setProperty("spring.datasource.url", "$jdbcUrl&reWriteBatchedInserts=true")
            System.setProperty("spring.datasource.username", username)
            System.setProperty("spring.datasource.password", password)
        }

        init {
            val threads = mutableListOf<Thread>()
            thread {
                postgreSQLContainer14
            }.also { threads.add(it) }

            threads.forEach { it.join() }
        }
    }

}
