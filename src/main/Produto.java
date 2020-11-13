package main;

public class Produto {
	private long id;
	private String descricao;
	private Double preco;
	private int quantidade;
	
	public Produto() {
		System.out.println("Você criou um produto vazio");
	}
	
	public Produto(String descricao, Double preco) {
		this.descricao = descricao;
		this.preco = preco;
		System.out.println("Você criou um produto com descricao " + descricao + " e preco " + preco);
	}
	
	private Double conversaoDolar(Double preco) {
		return preco*5.5;
	}
	
	public void converterPrecoEmDolar() {
		this.preco = conversaoDolar(this.preco);
		System.out.println("O novo preco é: " + this.preco);
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
