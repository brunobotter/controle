package br.com.bruno.contas

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Conta(val nome: String) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idConta: Long? = null
}