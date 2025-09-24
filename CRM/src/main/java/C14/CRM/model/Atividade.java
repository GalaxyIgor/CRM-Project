package C14.CRM.model;

import java.util.UUID;

public class Atividade {
    public enum Tipo { LIGACAO, REUNIAO, EMAIL }

    private String id;
    private Tipo tipo;
    private String descricao;
    private String data; // Usando String para simplificar

    public Atividade() {
        this.id = UUID.randomUUID().toString();
        this.data = java.time.LocalDate.now().toString(); // Data atual como string
    }

    public Atividade(Tipo tipo, String descricao) {
        this();
        setTipo(tipo);
        setDescricao(descricao);
    }

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Tipo getTipo() { return tipo; }
    public void setTipo(Tipo tipo) {
        if (tipo == null) {
            throw new IllegalArgumentException("O tipo da atividade não pode ser nulo.");
        }
        this.tipo = tipo;
    }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("A descrição da atividade não pode ser vazia.");
        }
        this.descricao = descricao;
    }

    public String getData() { return data; }
    public void setData(String data) { this.data = data; }

    @Override
    public String toString() {
        return "Atividade {" +
                "tipo=" + tipo +
                ", descricao='" + descricao + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}