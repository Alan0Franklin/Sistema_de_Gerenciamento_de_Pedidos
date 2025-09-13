package LAB_1;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;

public class Sistema {
	public static void main(String[] args) {
		try (Scanner cin = new Scanner(System.in)){
			int operacao;
			ArrayList<Pedido> lista_pedidos = new ArrayList<Pedido>();
			do {
				System.out.println("> Selecione uma operação: ");
				System.out.println("  | 1 - Registrar um Pedido");
				System.out.println("  | 2 - Remover um Pedido");
				System.out.println("  | 3 - Listar Pedidos");
				System.out.println("  | 4 - Sair");
				System.out.print("  !:> ");
				operacao = cin.nextInt();
				cin.nextLine();
				System.out.println("  | ===");
				switch(operacao) {
					case 1:
						lista_pedidos.add(new Pedido(cin));
						System.out.println("  └─> Registro de Pedido Concluído.\n");
						break;
					case 2:
						System.out.print("  !:> Informe o Número do Pedido que Deseja ser Removido: ");
						int id_pedido_removido = cin.nextInt();
						cin.nextLine();
						int qnt_pedidos = lista_pedidos.size();
						for (int i = 0; i < qnt_pedidos; i++) {
							if (lista_pedidos.get(i).getId_pedido() == id_pedido_removido) {
								lista_pedidos.remove(i);
								break;
							}
						}
						if (qnt_pedidos != lista_pedidos.size()) {System.out.println("  └─> Pedido " + id_pedido_removido + " Removido com Sucesso!");}
						else {System.out.println("  └─> Error: Pedido " + id_pedido_removido + " não encontrado.");}
						System.out.println();
						break;
					case 3:
						qnt_pedidos = lista_pedidos.size();
						System.out.println("  ├─> Quantidade de Pedidos: " + qnt_pedidos);
						System.out.println("  | ===");
						lista_pedidos.sort(Comparator.comparing((Pedido pedido) -> pedido.getId_pedido()));
						for (int i = 0; i < qnt_pedidos; i++) {
							System.out.println("  |");
							lista_pedidos.get(i).resumo_pedido();
						}
						System.out.println("  └─> Listagem Finalizada.\n");
						break;
					case 4:
						break;
					default:
						System.out.println("  └─> Error: Número de Operação Inválido! Digite novamente.\n");
				}
			} while (operacao != 4);
			System.out.print("  └─> Fim da Execução.");
			cin.close();
		}
	}
}