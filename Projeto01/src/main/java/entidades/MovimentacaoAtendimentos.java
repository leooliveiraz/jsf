package entidades;

// Generated 01/09/2015 00:07:35 by Hibernate Tools 4.0.0

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * MovimentacaoAtendimentosId generated by hbm2java
 */
@Entity
@Table(name = "movimentacao_atendimentos", catalog = "rfid_maternidade")
public class MovimentacaoAtendimentos implements java.io.Serializable {

	private int cdMovimentacao;
	private int antenasCdAntena;
	private int tagsCdTag;
	private Date dt_movimentacao;

	public MovimentacaoAtendimentos() {
	}

	public MovimentacaoAtendimentos(int cdMovimentacao, int antenasCdAntena,
			int tagsCdTag) {
		this.cdMovimentacao = cdMovimentacao;
		this.antenasCdAntena = antenasCdAntena;
		this.tagsCdTag = tagsCdTag;
	}
	@Id
	@Column(name = "cd_movimentacao", nullable = false)
	public int getCdMovimentacao() {
		return this.cdMovimentacao;
	}

	public void setCdMovimentacao(int cdMovimentacao) {
		this.cdMovimentacao = cdMovimentacao;
	}

	@Column(name = "antenas_cd_antena", nullable = false)
	public int getAntenasCdAntena() {
		return this.antenasCdAntena;
	}

	public void setAntenasCdAntena(int antenasCdAntena) {
		this.antenasCdAntena = antenasCdAntena;
	}

	@Column(name = "tags_cd_tag", nullable = false)
	public int getTagsCdTag() {
		return this.tagsCdTag;
	}

	public void setTagsCdTag(int tagsCdTag) {
		this.tagsCdTag = tagsCdTag;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_atendimento", length = 10)
	public Date getDt_movimentacao() {
		return dt_movimentacao;
	}

	public void setDt_movimentacao(Date dt_movimentacao) {
		this.dt_movimentacao = dt_movimentacao;
	}
	
	

}
