package com.example.savecontactsapi.service

import com.example.savecontactsapi.entity.Contacts
import com.example.savecontactsapi.exceptions.SaveContactsNotFoundException
import com.example.savecontactsapi.repository.ContactsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ContactsService(
    @Autowired
    private val repository: ContactsRepository
) {
    fun findAllContacts(): List<Contacts> {
        return repository.findAll()
    }

    fun findContactsBy(id: Long): Optional<Contacts> {
        val idContacts = this.repository.findById(id)

        if (!idContacts.isPresent) {
            throw SaveContactsNotFoundException("O contato de número $id não existe")
        }
        return idContacts
    }
}