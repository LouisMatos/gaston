package br.com.matos.gaston.domain.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_produtos")
public class Produto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_produto")
  private Long id;

  private String nome;
  private String descricao;
  private double preco;
  private int quantidade;
  private String unidade;
  private int quantidadeMinimaEstoque;
  private String dataValidade;
  private String categoria;

  public Produto() {
  }

  public Produto(String categoria, String dataValidade, int quantidadeMinimaEstoque, String unidade,
      int quantidade, double preco, String descricao, String nome, Long id) {
    this.categoria = categoria;
    this.dataValidade = dataValidade;
    this.quantidadeMinimaEstoque = quantidadeMinimaEstoque;
    this.unidade = unidade;
    this.quantidade = quantidade;
    this.preco = preco;
    this.descricao = descricao;
    this.nome = nome;
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public double getPreco() {
    return preco;
  }

  public void setPreco(double preco) {
    this.preco = preco;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }

  public String getUnidade() {
    return unidade;
  }

  public void setUnidade(String unidade) {
    this.unidade = unidade;
  }

  public int getQuantidadeMinimaEstoque() {
    return quantidadeMinimaEstoque;
  }

  public void setQuantidadeMinimaEstoque(int quantidadeMinimaEstoque) {
    this.quantidadeMinimaEstoque = quantidadeMinimaEstoque;
  }

  public String getDataValidade() {
    return dataValidade;
  }

  public void setDataValidade(String dataValidade) {
    this.dataValidade = dataValidade;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  @Override
  public String toString() {
    return "Produto{" +
        "id=" + id +
        ", nome='" + nome + '\'' +
        ", descricao='" + descricao + '\'' +
        ", preco=" + preco +
        ", quantidade=" + quantidade +
        ", unidade='" + unidade + '\'' +
        ", quantidadeMinimaEstoque=" + quantidadeMinimaEstoque +
        ", dataValidade='" + dataValidade + '\'' +
        ", categoria='" + categoria + '\'' +
        '}';
  }
}