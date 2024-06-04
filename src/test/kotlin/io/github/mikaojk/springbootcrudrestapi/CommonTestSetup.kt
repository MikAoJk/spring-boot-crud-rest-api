package io.github.mikaojk.springbootcrudrestapi

import io.github.mikaojk.springbootcrudrestapi.user.UserRepository
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.testcontainers.containers.PostgreSQLContainer
import kotlin.concurrent.thread

@Container
private class PostgreSQLContainer14 : PostgreSQLContainer<PostgreSQLContainer14>("postgres:14-alpine")

@Testcontainers
@SpringBootTest(classes = [SpringBootCrudRestApiApplication::class])
abstract class CommonTestSetup {

    @Autowired
    lateinit var userRepository: UserRepository

    companion object {
        init {
            val threads = mutableListOf<Thread>()

            thread {
                PostgreSQLContainer14().apply {
                    withCommand("postgres", "-c", "wal_level=logical")
                    start()
                    System.setProperty("spring.datasource.url", "$jdbcUrl&reWriteBatchedInserts=true")
                    System.setProperty("spring.datasource.username", username)
                    System.setProperty("spring.datasource.password", password)
                }
            }.also { threads.add(it) }

            threads.forEach { it.join() }
        }
    }

}
