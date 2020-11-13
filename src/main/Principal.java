package main;

public class Principal {
	public static void main(String[] args) {
	    Repositorio repo = new Repositorio();

	    Pessoa pe = new Pessoa("Nelson", 28);
	    pe.setSobrenome("Pereira");
	    
	    Produto pr = new Produto("Video Game", 2500.00);
	    pr.setQuantidade(1);

	    try {
	      repo.insert(pe);
	      repo.insert(pr);
	    } catch (Throwable e) {
	      e.printStackTrace();
	    }
	  }

}
