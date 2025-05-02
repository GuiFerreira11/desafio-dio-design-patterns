package desafio.dio.design_patterns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import desafio.dio.design_patterns.model.Cliente;
import desafio.dio.design_patterns.service.ClienteService;

@RestController
@RequestMapping("clientes")
@Tag(name = "Clientes API", description = "API para gerenciamento de clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    @Operation(summary = "Listar todos os clientes", description = "Retorna uma lista com todos os clientes cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista de clientes retornada com sucesso")
    public ResponseEntity<Iterable<Cliente>> buscarTodos() {
        return ResponseEntity.ok(clienteService.buscarTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar cliente por ID", description = "Retorna um cliente único pelo seu ID")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200", 
            description = "Cliente encontrado com sucesso",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Cliente.class))
        ),
        @ApiResponse(
            responseCode = "404", 
            description = "Cliente não encontrado",
            content = @Content
        )
    })
    public ResponseEntity<Cliente> buscarPorId(
        @Parameter(description = "ID do cliente", required = true, example = "1")
        @PathVariable Long id) {
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @PostMapping
    @Operation(summary = "Criar novo cliente", description = "Cria um novo cliente no sistema")
    @ApiResponse(
        responseCode = "200", 
        description = "Cliente criado com sucesso",
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = Cliente.class))
    )
    public ResponseEntity<Cliente> inserir(
        @Parameter(description = "Dados do novo cliente", required = true)
        @RequestBody Cliente cliente) {
        clienteService.inserir(cliente);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar cliente", description = "Atualiza os dados de um cliente existente")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200", 
            description = "Cliente atualizado com sucesso",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Cliente.class))
        ),
        @ApiResponse(
            responseCode = "404", 
            description = "Cliente não encontrado",
            content = @Content
        )
    })
    public ResponseEntity<Cliente> atualizar(
        @Parameter(description = "ID do cliente", required = true, example = "1")
        @PathVariable Long id,
        @Parameter(description = "Dados atualizados do cliente", required = true)
        @RequestBody Cliente cliente) {
        clienteService.atualizar(id, cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar cliente", description = "Remove um cliente do sistema")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200", 
            description = "Cliente removido com sucesso"
        ),
        @ApiResponse(
            responseCode = "404", 
            description = "Cliente não encontrado",
            content = @Content
        )
    })
    public ResponseEntity<Void> deletar(
        @Parameter(description = "ID do cliente", required = true, example = "1")
        @PathVariable Long id) {
        clienteService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
