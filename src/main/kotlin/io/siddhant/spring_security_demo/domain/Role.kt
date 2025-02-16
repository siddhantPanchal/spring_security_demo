package io.siddhant.spring_security_demo.domain

import jakarta.persistence.*

@Entity
@Table(name = "role")
open class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "name", nullable = false, unique = true, length = 45)
    open var name: String? = null

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "role_permissions",
        joinColumns = [JoinColumn(name = "role_id")],
        inverseJoinColumns = [JoinColumn(name = "permissions_id")]
    )
    open var permissions: MutableSet<Permission> = mutableSetOf()


    constructor(name: String?, permissions: MutableSet<Permission>) {
        this.permissions = permissions
        this.name = name
    }
}