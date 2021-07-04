package br.com.bruno.despesa

import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface DespesaRepository: JpaRepository<Despesa, Long> {

}
