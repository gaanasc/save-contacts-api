package com.example.savecontactsapi.repository

import com.example.savecontactsapi.entity.Contacts
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ContactsRepository: JpaRepository<Contacts, Long> {
}