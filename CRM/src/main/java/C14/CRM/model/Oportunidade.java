package C14.CRM.model;

import java.util.UUID;

public class Oportunidade {
    public enum Status { ABERTA, GANHA, PERDIDA }

    private String id;
    private String descricao;
    private double valor;
    private Status status;

    public Oportunidade() {
        this.id = UUID.randomUUID().toString();
        this.status = Status.ABERTA;
    }

    public Oportunidade(String descricao, double valor) {
        this();
        this.descricao = descricao;
        this.valor = valor;
    }

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    @Override
    public String toString() {
        return "Oportunidade {" +
                "descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", status=" + status +
                '}';
    }
}