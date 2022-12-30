package com.example.savecontactsapi.entity

import jakarta.persistence.*
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

@Entity
@Table(name = "contacts")
class Contacts(

    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @field:NotNull
    @field:Size(min = 5, max = 50)
    var condominio: String,

    @field:NotNull
    @field:Email
    var email: String,

    @field:NotNull
    var endereco: String,

    @field: NotNull
    @field:Size(min = 8, max = 11)
    var tel_sindico: Long,


    @field: Column
    @field:Size(min = 8, max = 11)
    var cel_sindico: Long,

    @field: NotNull
    @field:Size(min = 8, max = 11)
    var tel_zelador: Long,

    @field: Column
    @field:Size(min = 8, max = 11)
    var cel_zelador: Long,

)
