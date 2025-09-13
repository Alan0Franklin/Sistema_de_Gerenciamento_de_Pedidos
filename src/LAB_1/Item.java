package LAB_1;

public class Item {
	private String nome_item;
	private double preco_item;
	
	public Item(String nome_item, double preco_item) {
		this.nome_item = nome_item;
		this.preco_item = preco_item;
	}
	
	public String getNome_item() {return nome_item;}
	public double getPreco_item() {return preco_item;}	
}
