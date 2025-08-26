package br.com.mk.dto;

import java.math.BigDecimal;

public class PixHistory {

        private final String nome;
        private final String chave;
        private final String horario;
        private final BigDecimal valor;
        
        public PixHistory(String nome, BigDecimal valor, String chave, String horario) {
            this.nome = nome;
            this.valor = valor;
            this.chave = chave;
            this.horario = horario;
        }

        public String getNome() { return nome; }
        public BigDecimal getValor() { return valor; }
        public String getChave() { return chave; }
        public String getHorario() { return horario; }
}