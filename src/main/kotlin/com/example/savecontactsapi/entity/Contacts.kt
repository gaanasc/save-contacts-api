package com.example.savecontactsapi.entity

import jakarta.persistence.*

@Entity
@Table(name = "contacts")
data class Contacts(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(nullable = false, length = 70, unique = true)
    var condominio: String,

    @Column(nullable = false, length = 40)
    var email: String,

    @Column(nullable = false, length = 100)
    var endereco: String,

    @Column(nullable = false, length = 15)
    var tel_sindico: Long,

    @Column(nullable = true, length = 15)
    var cel_sindico: Long,

    @Column(nullable = false, length = 15)
    var tel_zelador: Long,

    @Column(nullable = true, length = 15)
    var cel_zelador: Long
)