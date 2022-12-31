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

    @Column(nullable = false, length = 30)
    var bairro: String,

    @Column(nullable = false, length = 20)
    var complemento: String,

    @Column(nullable = false, length = 8)
    var cep: Int,

    @Column(nullable = false, length = 15)
    var cidade: String,

    @Column(nullable = false, length = 20)
    var nome_sindico: String,

    @Column(nullable = false, length = 15)
    var tel_sindico: Long,

    @Column(nullable = true, length = 15)
    var cel_sindico: Long,

    @Column(nullable = false, length = 20)
    var nome_zelador: String,

    @Column(nullable = false, length = 15)
    var tel_zelador: Long,

    @Column(nullable = true, length = 15)
    var cel_zelador: Long,

    @Column(nullable = true, length = 250)
    var observacao: String
)