package br.com.matos.gaston.adapters.input.controller;

import br.com.matos.gaston.application.dtos.ProdutoDTO;
import br.com.matos.gaston.application.services.ProdutoServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

  private final ProdutoServiceImpl produtoService;

  public ProdutoController(ProdutoServiceImpl produtoService) {
    this.produtoService = produtoService;
  }

  @PostMapping
  public ResponseEntity<ProdutoDTO> criarProduto(@RequestBody ProdutoDTO produtoDTO) {
    return ResponseEntity.ok(produtoService.criarProduto(produtoDTO));
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProdutoDTO> buscarProdutoPorId(@PathVariable Long id) {
    return produtoService.buscarPorId(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @GetMapping
  public ResponseEntity<List<ProdutoDTO>> listarProdutos() {
    return ResponseEntity.ok(produtoService.listarTodos());
  }

  @PutMapping("/{id}")
  public ResponseEntity<ProdutoDTO> atualizarProduto(@PathVariable Long id,
      @RequestBody ProdutoDTO produtoDTO) {
    return ResponseEntity.ok(produtoService.atualizarProduto(id, produtoDTO));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
    produtoService.deletarProduto(id);
    return ResponseEntity.noContent().build();
  }
}