package questão1;

public class Produto {
    private int id;
    private String descricao;
    private double valor;

    public Produto(int id, String descricao, double valor) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    @Override
    public String toString(){
        return "\nId: "+this.id+
                "\nDescricao: "+this.descricao+
                "\nValor: "+this.valor+"\n-------------------";
    }
}
