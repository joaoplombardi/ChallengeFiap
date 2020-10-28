package br.com.connectall.b2w.models;

public enum Status {
    CONCLUIDA("Concluída"),
    CRIADA("Criada"),
    INICIALIZADA("Em andamento"),
    PARADA("Parada");

    private String status;

    private Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return status;
    }
}
