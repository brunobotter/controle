package br.com.bruno.despesa

import br.com.bruno.contas.Conta
import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Despesa(
    val conta: Conta,
    val dataEntrada: LocalDate,
    val valor: BigDecimal
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idDespesa: Long? = null

}
