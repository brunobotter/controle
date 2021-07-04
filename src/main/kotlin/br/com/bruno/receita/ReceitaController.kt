package br.com.bruno.receita

import br.com.bruno.contas.ContaRepository
import io.micronaut.data.jpa.repository.JpaRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import javax.inject.Inject

@Controller("/api/v1/receita")
class ReceitaController(
    @Inject val receitaService: ReceitaService,
    @Inject val receitaRepository: ReceitaRepository
)
{

    @Post
    fun adicionarDespesa(@Body request: ReceitaRequest,) =
        receitaService.adicionar(request).let {
            HttpResponse.ok(it)
        }

    @Get
    fun consultaTodasReceitas() = receitaRepository.findAll().let {
        HttpResponse.ok(it)
    }

    @Get("/{id}")
    fun consultaReceitaPorId(@PathVariable("id") id: Long) =
        receitaRepository.findById(id).let {
        HttpResponse.ok(it)
    }

    //TODO consulta por periodo de dias e talves de mes

    @Delete("/{id}")
    fun deletaReceitaPorId(@PathVariable("id") id: Long) =
        receitaRepository.deleteById(id).let {
            HttpResponse.ok(it)
        }

    @Put("/{id}")
    fun atualizaReceitaPorId(@PathVariable("id") id: Long, @Body request: AtualizaReceitaRequest) =
        receitaService.atualiza(request, id).let {
            HttpResponse.ok(it)
        }
}

