package br.com.matos.gaston.adapters.input.mapper;


import br.com.matos.gaston.application.dtos.ProdutoDTO;
import br.com.matos.gaston.domain.entities.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

  public ProdutoDTO toDTO(Produto produto) {
    return ProdutoDTO.builder()
        .id(produto.getId())
        .nome(produto.getNome())
        .descricao(produto.getDescricao())
        .preco(produto.getPreco())
        .quantidade(produto.getQuantidade())
        .categoria(produto.getCategoria())
        .dataValidade(produto.getDataValidade())
        .quantidadeMinimaEstoque(produto.getQuantidadeMinimaEstoque())
        .unidade(produto.getUnidade())
        .build();
  }

  public Produto toEntity(ProdutoDTO produtoDTO) {
    Produto produto = new Produto();
    produto.setNome(produtoDTO.getNome());
    produto.setDescricao(produtoDTO.getDescricao());
    produto.setPreco(produtoDTO.getPreco());
    produto.setQuantidade(produtoDTO.getQuantidade());
    produto.setCategoria(produtoDTO.getCategoria());
    produto.setDataValidade(produtoDTO.getDataValidade());
    produto.setQuantidadeMinimaEstoque(produtoDTO.getQuantidadeMinimaEstoque());
    produto.setUnidade(produtoDTO.getUnidade());
    produto.setId(produtoDTO.getId());
    return produto;
  }


}