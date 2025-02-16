package io.siddhant.spring_security_demo.domain

import jakarta.persistence.*

@Entity
@Table(name = "permission")
open class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "name", nullable = false, unique = true)
    open var name: String? = null

    constructor(name: String?) {
        this.name = name
    }
}