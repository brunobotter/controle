package br.com.bruno.receita

import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface ReceitaRepository: JpaRepository<Receita, Long> {
}