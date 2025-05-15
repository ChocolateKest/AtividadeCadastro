
package model;


public class Produto {
    private String produtos;
    private double preco;

    public Produto(){
        this("",0);
    }

    public Produto(String produtos, double preco) {
        this.produtos = produtos;
        this.preco = preco;
    }

    public String getProdutos() {
        return produtos;
    }

    public void setProdutos(String produtos) {
        this.produtos = produtos;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }



}