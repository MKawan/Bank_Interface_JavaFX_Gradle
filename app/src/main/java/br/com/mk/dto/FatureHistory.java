package br.com.mk.dto;

import java.math.BigDecimal;

public class FatureHistory {
    private final String fatura;
    private final BigDecimal valor;
    private final String data;
    
    public FatureHistory(String fatura, BigDecimal valor, String data) {
        this.fatura = fatura;
        this.valor = valor;
        this.data = data;
    }

    public String getFatura() { return fatura; }
    public BigDecimal getValor() { return valor; }
    public String getData() { return data; }
}
