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
        this.status = Status.ABERTA; // Começa com aberta
    }

    public Oportunidade(String descricao, double valor) {
        this();
        setDescricao(descricao);
        setValor(valor);
    }

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("A descrição da oportunidade não pode ser vazia.");
        }
        this.descricao = descricao;
    }

    public double getValor() { return valor; }
    public void setValor(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor da oportunidade deve ser maior que zero.");
        }
        this.valor = valor;
    }

    public Status getStatus() { return status; }
    public void setStatus(Status status) {
        if (status == null) {
            throw new IllegalArgumentException("O status da oportunidade não pode ser nulo.");
        }
        this.status = status;
    }

    @Override
    public String toString() {
        return "Oportunidade {" +
                "descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", status=" + status +
                '}';
    }
}