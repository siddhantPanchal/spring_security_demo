package io.siddhant.spring_security_demo

import io.siddhant.spring_security_demo.domain.Permission
import io.siddhant.spring_security_demo.domain.Role
import io.siddhant.spring_security_demo.domain.User
import io.siddhant.spring_security_demo.repository.PermissionRepository
import io.siddhant.spring_security_demo.repository.RoleRepository
import io.siddhant.spring_security_demo.repository.UserRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.password.PasswordEncoder

@SpringBootApplication
class SpringSecurityDemoApplication(
    private val roleRepository: RoleRepository,
    private val permissionRepository: PermissionRepository,
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {

    @Bean
    fun setUp(): CommandLineRunner {
        return CommandLineRunner {
            val permissions = listOf(
                Permission("DELETE_DOMAIN"),
                Permission("CREATE_DOMAIN"),
                Permission("VIEW_DOMAIN"),
                Permission("UPDATE_DOMAIN"),
            )
            permissionRepository.saveAll(permissions)

            val roles = listOf(
                Role("ROLE_ADMIN", permissions.toMutableSet()),
                Role(
                    "ROLE_USER",
                    setOf(permissions[2]).toMutableSet(),
                ),
            )
            roleRepository.saveAll(roles)

            val adminRole = roles.find { it.name == "ROLE_ADMIN" }?.let { mutableSetOf(it) } ?: mutableSetOf()
            val userRole = roles.find { it.name == "ROLE_USER" }?.let { mutableSetOf(it) } ?: mutableSetOf()

            val users = listOf(
                User("admin", passwordEncoder.encode("1234"), adminRole),
                User("user", passwordEncoder.encode("1234"), userRole),
            )

            userRepository.saveAll(users)

        }
    }

}

fun main(args: Array<String>) {
    runApplication<SpringSecurityDemoApplication>(*args)
}
