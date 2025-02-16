package io.siddhant.spring_security_demo.repository

interface UserRepository: org.springframework.data.jpa.repository.JpaRepository<io.siddhant.spring_security_demo.domain.User, kotlin.Long> {
}