package br.com.bruno.contas

import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface ContaRepository: JpaRepository<Conta, Long> {

}
