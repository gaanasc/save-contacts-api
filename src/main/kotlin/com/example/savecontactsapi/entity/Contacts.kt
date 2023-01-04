package com.example.savecontactsapi.entity

import jakarta.persistence.*

@Entity
@Table(name = "CONTATOS")
data class Contacts(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CONDOMINIO")
    val id_condominio: Long,

    @Column(name = "CONDOMINO", nullable = false, length = 100, unique = true)
    var condominio: String,

    @Column(name = "EMAIL", nullable = false, length = 40)
    var email: String,

    @Column(name = "ENDERECO", nullable = false, length = 100)
    var endereco: String,

    @Column(name = "BAIRRO", nullable = false, length = 30)
    var bairro: String,

    @Column(name = "COMPLEMENTO", nullable = false, length = 20)
    var complemento: String,

    @Column(name = "CEP", nullable = false, length = 8)
    var cep: Int,

    @Column(name = "CIDADE", nullable = false, length = 15)
    var cidade: String,

    @Column(name = "NOME_SINDICO", nullable = true, length = 20)
    var nome_sindico: String,

    @Column(name = "TEL_SINDICO", nullable = false, length = 15)
    var tel_sindico: Long,

    @Column(name = "CEL_SINDICO", nullable = true, length = 15)
    var cel_sindico: Long,

    @Column(name = "NOME_ZELADOR", nullable = true, length = 20)
    var nome_zelador: String,

    @Column(name = "TEL_ZELADOR", nullable = false, length = 15)
    var tel_zelador: Long,

    @Column(name = "CEL_ZELADOR", nullable = true, length = 15)
    var cel_zelador: Long,

    @Column(name = "OBSERVACAO", nullable = true, length = 250)
    var observacao: String
)