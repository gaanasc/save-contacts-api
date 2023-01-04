package com.example.savecontactsapi.controller

import com.example.savecontactsapi.entity.Contacts
import com.example.savecontactsapi.repository.ContactsRepository
import com.example.savecontactsapi.service.ContactsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@CrossOrigin(allowCredentials = "")
@RequestMapping("/save-contacts")
class ContactsController(
    @Autowired
    private val service: ContactsService
) {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(
        value = ["/contacts"]
    )
    fun getList(): List<Contacts> {
        return service.findAllContacts()
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(
        value = ["/{id}"]
    )
    fun getId(@PathVariable("id") id: Long): Optional<Contacts> {
        return service.findContactsBy(id)
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(
        value = ["/"]
    )
    fun create(@RequestBody contacts: Contacts): Contacts {
        return service.saveContacts(contacts)
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(
        value = ["/{id}"]
    )
    fun update(@PathVariable("id") id: Long, @RequestBody newContacts: Contacts): Contacts {
        return service.updateContacts(id, newContacts)
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(
        value = ["/{id}"]
    )
    fun delete(@PathVariable("id") id: Long) {
        return service.deleteContacts(id)
    }
}