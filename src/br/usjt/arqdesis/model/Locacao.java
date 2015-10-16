package br.usjt.arqdesis.model;

import java.sql.Timestamp;
import java.util.List;

public class Locacao {
	private Long codigo;
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
	private List<Acessorio> listaAcessorios;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public Timestamp getData_locacao() {
		return data_locacao;
	}
	public void setData_locacao(Timestamp data_locacao) {
		this.data_locacao = data_locacao;
	}
	public String getLocal_locacao() {
		return local_locacao;
	}
	public void setLocal_locacao(String local_locacao) {
		this.local_locacao = local_locacao;
	}
	public Timestamp getData_prevista_devolucao() {
		return data_prevista_devolucao;
	}
	public void setData_prevista_devolucao(Timestamp data_prevista_devolucao) {
		this.data_prevista_devolucao = data_prevista_devolucao;
	}
	public String getLocal_previsto_devolucao() {
		return local_previsto_devolucao;
	}
	public void setLocal_previsto_devolucao(String local_previsto_devolucao) {
		this.local_previsto_devolucao = local_previsto_devolucao;
	}
	public Timestamp getData_devolucao() {
		return data_devolucao;
	}
	public void setData_devolucao(Timestamp data_devolucao) {
		this.data_devolucao = data_devolucao;
	}
	public String getLocal_devolucao() {
		return local_devolucao;
	}
	public void setLocal_devolucao(String local_devolucao) {
		this.local_devolucao = local_devolucao;
	}
	public String getTipo_tarifa() {
		return tipo_tarifa;
	}
	public void setTipo_tarifa(String tipo_tarifa) {
		this.tipo_tarifa = tipo_tarifa;
	}
	public double getValor_estimado() {
		return valor_estimado;
	}
	public void setValor_estimado(double valor_estimado) {
		this.valor_estimado = valor_estimado;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Automovel getAutomovel() {
		return automovel;
	}
	public void setAutomovel(Automovel automovel) {
		this.automovel = automovel;
	}
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	public List<Acessorio> getListaAcessorios() {
		return listaAcessorios;
	}
	public void setListaAcessorios(List<Acessorio> listaAcessorios) {
		this.listaAcessorios = listaAcessorios;
	}
	
	@Override
	public String toString() {
		return "Locacao [data_locacao=" + data_locacao + ", local_locacao=" + local_locacao
				+ ", data_prevista_devolucao=" + data_prevista_devolucao + ", local_previsto_devolucao="
				+ local_previsto_devolucao + ", data_devolucao=" + data_devolucao + ", local_devolucao="
				+ local_devolucao + ", tipo_tarifa=" + tipo_tarifa + ", valor_estimado=" + valor_estimado + ", cliente="
				+ cliente + ", automovel=" + automovel + ", grupo=" + grupo + ", listaAcessorios=" + listaAcessorios
				+ "]";
	}
	
	
}
