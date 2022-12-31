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

    fun updateContacts(id: Long, newContacts: Contacts): Contacts {
        val contacts = repository.findById(id).orElseThrow {
            SaveContactsNotFoundException(
                "Ja existe um contato com o id $id, ou o mesmo não existe"
            )
        }

        contacts.apply {
            this.condominio = newContacts.condominio
            this.email = newContacts.email
            this.endereco = newContacts.endereco
            this.bairro = newContacts.bairro
            this.complemento = newContacts.complemento
            this.cep = newContacts.cep
            this.cidade = newContacts.cidade
            this.nome_sindico = newContacts.nome_sindico
            this.tel_sindico = newContacts.tel_sindico
            this.cel_sindico = newContacts.cel_sindico
            this.nome_zelador = newContacts.nome_zelador
            this.tel_zelador = newContacts.tel_zelador
            this.cel_zelador = newContacts.cel_zelador
            this.observacao = newContacts.observacao
        }
        return repository.save(newContacts)
    }

    fun saveContacts(contacts: Contacts): Contacts{
        return repository.save(contacts)
    }

    fun deleteContacts(id: Long) {
        val contacts = repository.findById(id).orElseThrow {
            SaveContactsNotFoundException(
                "O id $id não existe"
            )
        }
        repository.delete(contacts)
    }
}
//TODO: verificar duplicidade de nome de
// condominio, regra de cadastrar uma nova ou não