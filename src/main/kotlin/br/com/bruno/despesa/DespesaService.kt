package br.com.bruno.despesa

import br.com.bruno.contas.ContaRepository
import br.com.bruno.receita.Receita
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DespesaService(
    @Inject val despesaRepository: DespesaRepository,
    @Inject val contaRepository: ContaRepository
) {

    fun adicionar(request: DespesaRequest): Despesa {
        val conta = contaRepository.findById(request.idConta)
        //TODO: validação da conta e dos dados
        val despesa = request.toModel(conta.get())
        return despesaRepository.save(despesa)
    }

    fun atualiza(request: AtualizaDespesaRequest, id: Long): Despesa {
        val conta = contaRepository.findById(id)
        //TODO: validação da conta e dos dados
        val despesa = request.toModel(conta.get())
        return despesaRepository.update(despesa)
    }


}
