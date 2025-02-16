package io.siddhant.spring_security_demo.controller

import io.siddhant.spring_security_demo.domain.Domain
import io.siddhant.spring_security_demo.repository.DomainRepository
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/domain")
class DomainController(private val domainRepository: DomainRepository) {

    @PreAuthorize("hasAuthority('VIEW_DOMAIN')")
    @GetMapping
    fun getAllDomains() = domainRepository.findAll()


    @PostMapping
    @PreAuthorize("hasAuthority('CREATE_DOMAIN')")
    fun createDomain(@RequestBody name: String) = domainRepository.save(Domain(name))


    @GetMapping("/debug")
    fun debugAuthorities(authentication: Authentication): Map<String, Any> {
        return mapOf(
            "username" to authentication.name,
            "authorities" to authentication.authorities.map { it.authority }
        )
    }


}