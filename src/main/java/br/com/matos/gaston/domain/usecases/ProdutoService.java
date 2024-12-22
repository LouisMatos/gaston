package br.com.matos.gaston.domain.usecases;


import br.com.matos.gaston.application.dtos.ProdutoDTO;
import java.util.List;
import java.util.Optional;

public interface ProdutoService {
  ProdutoDTO criarProduto(ProdutoDTO produtoDTO);
  Optional<ProdutoDTO> buscarPorId(Long id);
  List<ProdutoDTO> listarTodos();
  ProdutoDTO atualizarProduto(Long id, ProdutoDTO produtoDTO);
  void deletarProduto(Long id);
}