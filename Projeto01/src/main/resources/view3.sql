SELECT 
	a.cd_alerta,
	a.cd_movimentacao,
	a.cd_tipo_alerta,
	m.dt_movimentacao,
	ant.cd_antena,
	ant.ds_antena,
	ate.cd_atendimento,
	p.nm_paciente,
	tip.ds_tipo_alerta
FROM
	alertas a,
	tipo_alerta	tip,
	movimentacao_atendimentos m,
	tags_atendimento t,
	atendimento ate,
	paciente p,
	antenas ant

where

a.cd_movimentacao = m.cd_movimentacao
and m.tags_cd_tag = t.cd_tag_fornecedor
and t.atendimento_cd_atendimento =ate.cd_atendimento
and ate.cd_paciente = p.cd_paciente
and m.antenas_cd_antena = ant.cd_antena
and a.cd_tipo_alerta = tip.cd_tipo_alerta