package io.siddhant.spring_security_demo.domain

import jakarta.persistence.*

@Entity
@Table(name = "domain")
class Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    open var id: Long? = null

    @Column(name = "name", nullable = false, length = 45)
    open var name: String? = null

    constructor(name: String?) {
        this.name = name
    }
}