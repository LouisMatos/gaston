package br.com.matos.gaston.domain.usecases;


import br.com.matos.gaston.domain.entities.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {

  Produto criarProduto(Produto produto);

  Optional<Produto> buscarPorId(Long id);

  List<Produto> listarTodos();

  Produto atualizarProduto(Long id, Produto produto);

  void deletarProduto(Long id);
}