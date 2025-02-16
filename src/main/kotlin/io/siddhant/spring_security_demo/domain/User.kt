package io.siddhant.spring_security_demo.domain

import jakarta.persistence.*

@Entity
@Table(name = "users")
open class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "username", nullable = false, unique = true, length = 45)
    open var username: String? = null

    @Column(name = "password", nullable = false)
    open var password: String? = null

    @ManyToMany
    @JoinTable(
        name = "user_roles",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "roles_id")]
    )
    open var roles: MutableSet<Role> = mutableSetOf()


    constructor(username: String?, password: String?, roles: MutableSet<Role>) {
        this.username = username
        this.password = password
        this.roles = roles
    }
}