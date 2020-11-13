package main;

@DBTable(table="TabelaPessoa")
public class Pessoa{
	
	@DBField()
	private long id;
	
	@DBField(colummn = "colunaNome")
	private String nome;
	
	@DBField()
	private String sobrenome;
	
	@DBField()
	private int idade;
	
	public Pessoa() {
		System.out.println("Você criou uma pessoa sem nome e sem idade");
	}
	
	public Pessoa(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
		System.out.println("Você criou uma pessoa com nome " + nome + " e idade " + idade);
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
}
