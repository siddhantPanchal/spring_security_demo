package io.siddhant.spring_security_demo.service

import io.siddhant.spring_security_demo.repository.DomainRepository
import org.springframework.stereotype.Service


@Service
class DomainService(private val domainRepository: DomainRepository) {
}