package io.siddhant.spring_security_demo.service

import io.siddhant.spring_security_demo.config.UserPrinciple
import io.siddhant.spring_security_demo.domain.User
import io.siddhant.spring_security_demo.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class ApplicationUserDetailsService(private val userRepository: UserRepository) : UserDetailsService {

    @Transactional
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String?): UserDetails {
        val user: User =
            userRepository.findByUsernameIgnoreCase(username) ?: throw UsernameNotFoundException("User not found")
        println(user.roles)
        return UserPrinciple(user)
    }
}