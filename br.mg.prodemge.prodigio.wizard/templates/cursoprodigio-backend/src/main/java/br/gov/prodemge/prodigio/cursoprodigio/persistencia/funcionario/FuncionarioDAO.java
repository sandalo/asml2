package br.gov.prodemge.prodigio.cursoprodigio.persistencia.funcionario;

import br.gov.prodemge.prodigio.cursoprodigio.persistencia.CursoProdigioBaseDAO;

public class FuncionarioDAO extends CursoProdigioBaseDAO {
	/*
	 * protected void montaRestricoes(Object exemplo, Object exemplo2, Criteria criteria, DadosDeSuporteAPesquisa dadosDeSuporteAPesquisa) throws Exception { List<String> properties = Reflexao.recuperaNomeDeAtributosBeansPorClasse(exemplo); Class
	 * tipo = null; if (exemplo instanceof ProBaseVO && ((ProBaseVO) exemplo).getId() != null && ((ProBaseVO) exemplo).getId() >= 1) { Example e = Example.create(exemplo).excludeZeroes(); Criterion exp = Restrictions.eq("id", ((ProBaseVO)
	 * exemplo).getId()); criteria.add(exp); } else { for (String propriedade : properties) { try { Object valor = Reflexao.recuperaValorDeMetodoGet(propriedade, exemplo); if (valor != null && !propriedade.equals("usuarioCriacao") &&
	 * !propriedade.equals("unidadeCriacao")) { Class classe = Reflexao.recuperaTipoDeRetornoDoMetodoGet(propriedade, exemplo); if (classe.equals(String.class)) { if (!"".equals(valor)) { String value = ((String) valor);
	 * 
	 * if (value.startsWith("%") && !value.substring(1).contains("%")) { Criterion ilike = Restrictions.ilike(propriedade, value, MatchMode.END); criteria.add(ilike); } else if (value.endsWith("%") && !value.substring(0, value.length() -
	 * 2).contains("%")) { Criterion ilike = Restrictions.ilike(propriedade, value, MatchMode.START); criteria.add(ilike); } else if (value.startsWith("%") && value.endsWith("%")) { Criterion ilike = Restrictions.ilike(propriedade, value,
	 * MatchMode.ANYWHERE); criteria.add(ilike); } else if (value.startsWith("\"") && value.endsWith("\"")) { Criterion ilike = Restrictions.ilike(propriedade, value.substring(1, value.length() - 1), MatchMode.EXACT); criteria.add(ilike); } else {
	 * Criterion exp = Restrictions.eq(propriedade, valor); criteria.add(exp); } } } else if (valor instanceof Date) { Object valor2 = null; if (exemplo2 != null) valor2 = Reflexao.recuperaValorDeMetodoGet(propriedade, exemplo2); Date data = (Date)
	 * valor; Date data2 = (Date) valor2; Criterion exp = null; if (data.equals(data2) || data2 == null) { Calendar c = Calendar.getInstance(); c.setTime(data); // Now use today date. c.add(Calendar.DATE, 1); // Adding 1 days data2 = c.getTime(); exp
	 * = Restrictions.between(propriedade, data, data2); } else { exp = Restrictions.between(propriedade, data, data2); } criteria.add(exp); // Acordado em 02/06/2015, necessidade equipe // desenvolvimento Istitucional. } else if (valor instanceof
	 * Number) { Object valor2 = null; if (exemplo2 != null) { valor2 = Reflexao.recuperaValorDeMetodoGet(propriedade, exemplo2); } Number primeiroNumero = (Number) valor; Number segundoNumero = (Number) valor2; Criterion exp = null; if
	 * (segundoNumero == null || primeiroNumero.equals(segundoNumero)) { exp = Restrictions.eq(propriedade, primeiroNumero); } else { exp = Restrictions.between(propriedade, primeiroNumero, segundoNumero); } criteria.add(exp); } else if (valor
	 * instanceof ProBaseVO || valor.getClass().isAnnotationPresent(Embeddable.class)) { Object valor2 = null; if (exemplo2 != null) valor2 = Reflexao.recuperaValorDeMetodoGet(propriedade, exemplo2); Criteria criteria2 =
	 * criteria.createCriteria(propriedade, propriedade, JoinType.LEFT_OUTER_JOIN); montaRestricoes(valor, valor2, criteria2, dadosDeSuporteAPesquisa); } else if (valor instanceof java.util.Set) { Set detalhe = (Set) valor; if (detalhe != null &&
	 * !detalhe.isEmpty()) { Criteria criteria2 = criteria.createCriteria(propriedade, propriedade, JoinType.LEFT_OUTER_JOIN); ProBaseVO baseVO = (ProBaseVO) detalhe.toArray()[0]; dadosDeSuporteAPesquisa.temJoin = true; montaRestricoes(baseVO,
	 * baseVO, criteria2, dadosDeSuporteAPesquisa); } } else if (valor instanceof java.util.List) { List detalhe = (List) valor; if (detalhe != null && !detalhe.isEmpty()) { Criteria criteria2 = criteria.createCriteria(propriedade, propriedade,
	 * JoinType.LEFT_OUTER_JOIN); ProBaseVO baseVO = (ProBaseVO) detalhe.toArray()[0]; dadosDeSuporteAPesquisa.temJoin = true; montaRestricoes(baseVO, baseVO, criteria2, dadosDeSuporteAPesquisa); } } else if (valor instanceof String) { Criterion exp
	 * = Restrictions.eq(propriedade.toLowerCase(), ((String) valor).toLowerCase()); criteria.add(exp); } else { Criterion exp = Restrictions.eq(propriedade, valor); criteria.add(exp); } } } catch (Exception e) { throw e; } } } }
	 * 
	 * 
	 * protected void configuraProjecao(Criteria criteria, ProjectionList projectionList, ProBaseVO exemplo, String... projecoes) { String alias = criteria.getAlias(); for (String projecao : projecoes) { if (projecao.contains(".")) { String[]
	 * agregados = projecao.split("\\."); String objetoAgregadoRaiz = agregados[0]; try { ClassReflexao.recuperaTipoDeRetornoDoMetodoGet(objetoAgregadoRaiz, exemplo); } catch (Exception e) { e.printStackTrace(); } Criteria subCriteria =
	 * criaCriteriaParaObjetoAgregadoRaiz(criteria, objetoAgregadoRaiz); String subProjecoes = projecao.replace(objetoAgregadoRaiz + ".", ""); configuraProjecao(subCriteria, projectionList, exemplo, subProjecoes); } else {
	 * configuraAFormaDeProjecao(criteria, projectionList, alias, projecao); } } }
	 * 
	 * 
	 * private void configuraAFormaDeProjecao(Criteria criteria, ProjectionList projectionList, String alias, String projecao) { String propriedadeOrigem = null; String propriedadeResultante = null; if (projecao.contains("conta(")) {
	 * propriedadeOrigem = projecao.replace("conta(", "").replace(")", ""); if (alias == "this") { propriedadeResultante = "qte" + propriedadeOrigem.substring(0, 1).toUpperCase() + propriedadeOrigem.substring(1); } else { propriedadeResultante =
	 * "qte" + alias.substring(0, 1).toUpperCase() + alias.substring(1) + propriedadeOrigem.substring(0, 1).toUpperCase() + propriedadeOrigem.substring(1); } projectionList.add(Property.forName(alias + "." +
	 * propriedadeOrigem).count().as(propriedadeResultante)); } else if (projecao.contains("agrupa(")) { propriedadeOrigem = projecao.replace("agrupa(", "").replace(")", ""); if (alias == "this") { propriedadeResultante = "grp" +
	 * propriedadeOrigem.substring(0, 1).toUpperCase() + propriedadeOrigem.substring(1); } else { propriedadeResultante = "grp" + alias.substring(0, 1).toUpperCase() + alias.substring(1) + propriedadeOrigem.substring(0, 1).toUpperCase() +
	 * propriedadeOrigem.substring(1); } projectionList.add(Property.forName(alias + "." + propriedadeOrigem).group().as(propriedadeResultante)); } else if (projecao.contains("soma(")) { propriedadeOrigem = projecao.replace("soma(", "").replace(")",
	 * ""); if (alias == "this") { propriedadeResultante = "sma" + propriedadeOrigem.substring(0, 1).toUpperCase() + propriedadeOrigem.substring(1); } else { propriedadeResultante = "sma" + alias.substring(0, 1).toUpperCase() + alias.substring(1) +
	 * propriedadeOrigem.substring(0, 1).toUpperCase() + propriedadeOrigem.substring(1); } projectionList.add(Projections.sum(alias + "." + propriedadeOrigem).as(propriedadeResultante)); } else { propriedadeOrigem = alias + "." + projecao;
	 * propriedadeResultante = propriedadeOrigem; projectionList.add(Property.forName(propriedadeResultante)); } // criteria.addOrder(Order.asc(propriedadeResultante)); }
	 */
}
