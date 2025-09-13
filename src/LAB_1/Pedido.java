package LAB_1;

import java.util.Scanner;
import java.util.ArrayList;

public class Pedido {
    private static int nextid = 1;
	private int id_pedido;

	private String nome_cliente;
	private ArrayList<Item> lista_itens;
	
	public Pedido(Scanner cin) {
		System.out.print("  !:> Informe o nome do cliente: ");
		this.nome_cliente = cin.nextLine(); 
		System.out.println("  |");
		int qnt_itens;
		do {
			System.out.print("  !:> Informe quantos itens deseja-se incluir: ");
			qnt_itens = cin.nextInt();
			cin.nextLine(); 
			if (qnt_itens >= 1) {break;}
			System.out.println("  ├─> Error: Número Inválido! Digite novamente.");
		}
		while (true);
		System.out.println("  |");
		this.lista_itens = new ArrayList<Item>();
		System.out.println("  ├─> Definindo " + qnt_itens + " Itens");
		for (int i = 1; i <= qnt_itens; i++) {
			System.out.print("  !:> Informe o Nome do Item " + i + ": ");
			String nome_item = cin.nextLine();
			double preco_item;
			do {
				System.out.print("  !:> Informe o Preço do Item " + i + ": ");
				preco_item = cin.nextDouble();
				cin.nextLine();
				if (preco_item >= 0) {break;}
				System.out.println("  ├─> Error: Número Inválido! Digite novamente.");
			}
			while (true);
			this.lista_itens.add(new Item(nome_item, preco_item)); 
			System.out.println("  |");
		}
		this.id_pedido = nextid;
		nextid++;
		resumo_pedido();
	}
	
	public void resumo_pedido() {
		System.out.println("  ├─> Pedido " + this.id_pedido);
		System.out.println("  |   | ---");
		System.out.println("  |   | # Nome do Cliente: " + this.nome_cliente);
		System.out.println("  |   | ---" );
		System.out.print("  |   | + Lista de Itens" );
		int qnt_itens = this.lista_itens.size();
		for (int i = 0; i < qnt_itens; ) {
			Item item = this.lista_itens.get(i);
			i++;
			System.out.println("\n  |   | * Item " + i + ": " + item.getNome_item());
			System.out.printf("  |   |  Preço: R$ %.2f%n", item.getPreco_item());
			System.out.print("  |   | " );
		}
		System.out.println("===");
		System.out.printf("  |   |  Total: R$ %.2f%n", valor_total_itens());
		System.out.println("  |   ' " );
	}
	
	public double valor_total_itens() {
		double total = 0;
		int qnt_itens = this.lista_itens.size();
		for (int i = 0; i < qnt_itens; i++) {total += this.lista_itens.get(i).getPreco_item();}
		return total;
	}
	
	public int getId_pedido() {return id_pedido;}
}
