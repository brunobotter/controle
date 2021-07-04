package br.com.bruno.despesa

import br.com.bruno.contas.Conta
import br.com.bruno.receita.Receita
import java.math.BigDecimal
import java.time.LocalDate
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

class AtualizaDespesaRequest(
    @field:NotNull val dataEntrada: LocalDate,
    @field:Positive val valor: BigDecimal
) {
    fun toModel(conta: Conta) = Despesa(conta, dataEntrada, valor)
}