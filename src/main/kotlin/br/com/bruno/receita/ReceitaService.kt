package br.com.bruno.receita

import br.com.bruno.contas.ContaRepository
import br.com.bruno.receita.Receita
import br.com.bruno.receita.ReceitaRepository
import br.com.bruno.receita.ReceitaRequest
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ReceitaService(
    @Inject val receitaRepository: ReceitaRepository,
    @Inject val contaRepository: ContaRepository
) {

    fun adicionar(request: ReceitaRequest): Receita {
        val conta = contaRepository.findById(request.idConta)
        //TODO: validação da conta e dos dados
        val receita = request.toModel(conta.get())
        return receitaRepository.save(receita)
    }

    fun atualiza(request: AtualizaReceitaRequest, id: Long): Receita {
        val conta = contaRepository.findById(id)
        //TODO: validação da conta e dos dados
        val receita = request.toModel(conta.get())
        return  receitaRepository.update(receita)
    }


}
