package br.com.bruno.receita

import br.com.bruno.contas.Conta
import java.math.BigDecimal
import java.time.LocalDate
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

class AtualizaReceitaRequest(
    @field:NotNull val dataEntrada: LocalDate,
    @field:Positive val valor: BigDecimal
) {
    fun toModel(conta: Conta) = Receita(conta, dataEntrada, valor)
}
