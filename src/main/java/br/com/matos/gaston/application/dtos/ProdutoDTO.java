package br.com.matos.gaston.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {

  private Long id;
  private String nome;
  private String descricao;
  private String categoria;
  private String unidade;
  private int quantidade;
  private int quantidadeMinimaEstoque;
  private double preco;
  private String dataValidade;








}
