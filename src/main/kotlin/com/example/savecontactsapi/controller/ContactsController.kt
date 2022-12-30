package com.example.savecontactsapi.controller

import com.example.savecontactsapi.entity.Contacts
import com.example.savecontactsapi.exceptions.SaveContactsNotFoundException
import com.example.savecontactsapi.repository.ContactsRepository
import com.example.savecontactsapi.service.ContactsService
import jakarta.persistence.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/save-contacts")
class ContactsController(
    @Autowired
    private val repository: ContactsRepository,
    @Autowired
    private val service: ContactsService
) {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(
        value = ["/contacts"]
    )
    fun getContactsList(): List<Contacts> {
        return service.findAllContacts()
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(
        value = ["/{id}"]
    )
    fun getIdContacts(@PathVariable("id") id: Long): Optional<Contacts> {
        return service.findContactsBy(id)
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(
        value = ["/"]
    )
    fun createContacts(@RequestBody contacts: Contacts): Contacts {
        return repository.save(contacts)
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(
        value = ["/{id}"]
    )
    fun updateContacts(@PathVariable("id") id: Long, @RequestBody newContacts: Contacts): Contacts {
        val contacts = repository.findById(id).orElseThrow {
            SaveContactsNotFoundException(
                "O contato de número $id não existe")
        }

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

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(
        value = ["/{id}"]
    )
    fun deleteContacts(@PathVariable("id") id: Long) {
        val contacts = repository.findById(id).orElseThrow { EntityNotFoundException() }
        repository.delete(contacts)
    }
}
