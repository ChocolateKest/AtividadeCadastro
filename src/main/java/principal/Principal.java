package principal;
import javax.swing.JOptionPane;
import model.Produto;
public class Principal {
    public static void main(String[] args){
        Produto[] produtos = new Produto[10];


        while(true){

            String input = JOptionPane.showInputDialog(null,
                    "1) Inserir dados: \n" +
                            "2) Listar Produtos: \n" +
                            "3) Fazer média: \n" +
                            "4) Sair: \n" +
                            "Escolha uma opção:");


            if(input == null){
                break;
            }

            try {
                int opcao = Integer.parseInt(input);

                switch (opcao) {
                    case 1:
                        JOptionPane.showMessageDialog(null, "Abaixo, liste 10 produtos: ");

                        for(int i = 0; i < 10; i++){
                            String nome = JOptionPane.showInputDialog(null, "Digite o nome do produto " + (i + 1) + ":");

                            if(nome == null || nome.trim().isEmpty()){
                                JOptionPane.showMessageDialog(null, "Nome inválido. Tente novamente.");
                                i--;
                                continue;
                            }

                            String precos = JOptionPane.showInputDialog(null, "Digite o preço do produto " + (i + 1) + ":");

                            try{
                                double preco = Double.parseDouble(precos);
                                produtos[i] = new Produto(nome, preco);
                            } catch (NumberFormatException e){
                                JOptionPane.showMessageDialog(null, "Preço inválido. Digite um número");
                                i--;
                            }
                        }

                        break;
                    case 2:

                        boolean preenchido1 = false;
                        for(Produto p : produtos){
                            if(p != null){

                                preenchido1 = true;
                                break;
                            }
                        }
                        if(!preenchido1){
                            JOptionPane.showMessageDialog(null, "Você precisa inserir os produtos primeiro (Opção 1)!");
                            break;
                        }

                        StringBuilder lista = new StringBuilder("Segue a lista de produtos abaixo:\n");
                        for(int i = 0; i < produtos.length; i++){
                            if(produtos[i]!= null){
                                lista.append("Produto " + (i + 1) + ":" + produtos[i].getProdutos() + " - R$" + produtos[i].getPreco()+ "\n");
                            }
                        }

                        JOptionPane.showMessageDialog(null, lista.toString());
                        break;
                    case 3:
                        boolean preenchido = false;
                        for(Produto p : produtos){
                            if(p != null){

                                preenchido = true;
                                break;
                            }
                        }
                        if(!preenchido){
                            JOptionPane.showMessageDialog(null, "Você precisa inserir os produtos primeiro (Opção 1)!");
                            break;
                        }
                        double soma = 0;
                        double contador = 0;

                        for(Produto p : produtos){
                            if (p != null){
                                soma += p.getPreco();
                                contador++;
                            }
                        }

                        double media = soma / contador;

                        JOptionPane.showMessageDialog(null, "A média de preços dos produtos é: R$ " + media);
                        break;

                    case 4:
                        JOptionPane.showMessageDialog(null, "Saindo...");
                        return;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida! Escolha de 1 a 4.");
                        break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, digite apenas números para escolher uma opção.");
            }


        }



    }

}