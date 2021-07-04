package br.com.bruno.despesa

import br.com.bruno.contas.ContaRepository
import br.com.bruno.receita.AtualizaReceitaRequest
import io.micronaut.data.jpa.repository.JpaRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import javax.inject.Inject

@Controller("/api/v1/despesa")
class DespesaController(
    @Inject val despesaService: DespesaService,
    @Inject val despesaRepository: DespesaRepository
)
{

    @Post
    fun adicionarDespesa(@Body request: DespesaRequest,) =
        despesaService.adicionar(request).let {
            HttpResponse.ok(it)
        }
    @Get
    fun consultaTodasDespesas() = despesaRepository.findAll().let {
        HttpResponse.ok(it)
    }

    @Get("/{id}")
    fun consultaDespesaPorId(@PathVariable("id") id: Long) =
        despesaRepository.findById(id).let {
            HttpResponse.ok(it)
        }

    //TODO consulta por periodo de dias e talves de mes

    @Delete("/{id}")
    fun deletaDespesaPorId(@PathVariable("id") id: Long) =
        despesaRepository.deleteById(id).let {
            HttpResponse.ok(it)
        }

    @Put("/{id}")
    fun atualizaDespesaPorId(@PathVariable("id") id: Long, @Body request: AtualizaDespesaRequest) =
        despesaService.atualiza(request, id).let {
            HttpResponse.ok(it)
        }
}

