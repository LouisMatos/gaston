package br.com.matos.gaston.adapters.input.controller;


import br.com.matos.gaston.application.services.ProdutoServiceImpl;
import br.com.matos.gaston.domain.entities.Produto;
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
  public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto) {
    return ResponseEntity.ok(produtoService.criarProduto(produto));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable Long id) {
    return produtoService.buscarPorId(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @GetMapping
  public ResponseEntity<List<Produto>> listarProdutos() {
    return ResponseEntity.ok(produtoService.listarTodos());
  }

  @PutMapping("/{id}")
  public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id,
      @RequestBody Produto produto) {
    return ResponseEntity.ok(produtoService.atualizarProduto(id, produto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
    produtoService.deletarProduto(id);
    return ResponseEntity.noContent().build();
  }
}