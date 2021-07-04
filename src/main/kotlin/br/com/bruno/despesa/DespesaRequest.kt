package br.com.bruno.despesa

import br.com.bruno.contas.Conta
import java.math.BigDecimal
import java.time.LocalDate

import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

class DespesaRequest(
    @field:NotNull @field:Positive val idConta: Long,
    @field:NotNull val dataEntrada: LocalDate,
    @field:Positive val valor: BigDecimal
) {
    fun toModel(conta: Conta) = Despesa(conta, dataEntrada, valor)
}
