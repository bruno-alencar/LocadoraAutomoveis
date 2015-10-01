package br.usjt.arqdesis.model;

import java.sql.Time;

import com.sun.jmx.snmp.Timestamp;

public class Locacao {
	private Timestamp data_locacao;
	private String local_locacao;
	private Timestamp data_prevista_devolucao;
	private String local_previsto_devolucao;
	private Timestamp data_devolucao;
	private String local_devolucao;
	private String tipo_tarifa;
	private double valor_estimado;
	private Cliente cliente;
	private Automovel automovel;
	private Grupo grupo;
}
