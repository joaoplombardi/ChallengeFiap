package br.com.fiap.b2w.models;

public enum Status {
    CONCLUIDA("Concluída"),
    INICIALIZADA("Em andamento"),
    PARADA("Parada");

    private String status;

    Status(String status) {
        this.status = status;
    }
}
