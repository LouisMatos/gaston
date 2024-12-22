package br.com.matos.gaston.application.services;

import br.com.matos.gaston.adapters.input.mapper.ProdutoMapper;
import br.com.matos.gaston.application.dtos.ProdutoDTO;
import br.com.matos.gaston.domain.entities.Produto;
import br.com.matos.gaston.domain.usecases.ProdutoService;
import br.com.matos.gaston.infrastructure.database.repositories.ProdutoRepository;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProdutoServiceImpl implements ProdutoService {

  private final ProdutoRepository produtoRepository;
  private final ProdutoMapper produtoMapper;

  public ProdutoServiceImpl(ProdutoRepository produtoRepository, ProdutoMapper produtoMapper) {
    this.produtoRepository = produtoRepository;
    this.produtoMapper = produtoMapper;
  }

  @Override
  public ProdutoDTO criarProduto(ProdutoDTO produtoDTO) {
    Produto produto = produtoMapper.toEntity(produtoDTO);
    Produto savedProduto = produtoRepository.save(produto);
    return produtoMapper.toDTO(savedProduto);
  }

  @Override
  public Optional<ProdutoDTO> buscarPorId(Long id) {
    return produtoRepository.findById(id)
        .map(produtoMapper::toDTO);
  }

  @Override
  public List<ProdutoDTO> listarTodos() {
    return produtoRepository.findAll().stream()
        .map(produtoMapper::toDTO)
        .collect(Collectors.toList());
  }

  @Override
  public ProdutoDTO atualizarProduto(Long id, ProdutoDTO produtoDTO) {
    return produtoRepository.findById(id)
        .map(p -> {
          p.setNome(produtoDTO.getNome());
          p.setDescricao(produtoDTO.getDescricao());
          p.setPreco(produtoDTO.getPreco());
          p.setQuantidade(produtoDTO.getQuantidade());
          p.setCategoria(produtoDTO.getCategoria());
          p.setDataValidade(produtoDTO.getDataValidade());
          p.setQuantidadeMinimaEstoque(produtoDTO.getQuantidadeMinimaEstoque());
          p.setUnidade(produtoDTO.getUnidade());
          Produto updatedProduto = produtoRepository.save(p);
          return produtoMapper.toDTO(updatedProduto);
        })
        .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
  }

  @Override
  public void deletarProduto(Long id) {
    produtoRepository.deleteById(id);
  }
}