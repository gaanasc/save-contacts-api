package com.example.savecontactsapi.controller

import com.example.savecontactsapi.entity.Contacts
import com.example.savecontactsapi.repository.ContactsRepository
import jakarta.persistence.EntityNotFoundException
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/save-contacts")
class ContactsController {

    @Autowired
    lateinit var repository: ContactsRepository

    @GetMapping
    fun getContactsList(): List<Contacts> {
        return repository.findAll()
    }

    @GetMapping("/{id}")
    fun getIdContacts(@PathVariable("id") id: Long): Optional<Contacts> {
        return repository.findById(id)
    }

    @PostMapping
    fun createContacts(@Valid @RequestBody contacts: Contacts): Contacts {
        return repository.save(contacts)
    }

    @PutMapping("/{id}")
    fun updateContacts(@PathVariable("id") id: Long, @Valid @RequestBody newContacts: Contacts): Contacts {
        val contacts = repository.findById(id).orElseThrow { EntityNotFoundException() }

        contacts.apply {
            this.condominio = newContacts.condominio
            this.email = newContacts.email
            this.endereco = newContacts.endereco
            this.tel_sindico = newContacts.tel_sindico
            this.cel_sindico = newContacts.cel_sindico
            this.tel_zelador = newContacts.tel_zelador
            this.cel_zelador = newContacts.cel_zelador

        }
        return repository.save(contacts)
    }

    @DeleteMapping("/{id}")
    fun deleteContacts(@PathVariable("id") id: Long) {
        val contacts = repository.findById(id).orElseThrow { EntityNotFoundException() }
        repository.delete(contacts)
    }
}