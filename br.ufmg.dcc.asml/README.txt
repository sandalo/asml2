Antes de gerar nova versão da ASML deve-se fazer backup das classes:
AbstractComponent, AbstractComponentImpl, ExternalClassImpl.

Esse ação se deve ao fato de que, a geração de código feita com xtext apagará a codificação complementar feita manualmente.
A codificação manual foi feita para absorver detalhes específicos da solução e que o xtext não pode gerar.

Obs.:
- Sempre envio o código para o repositório antes de gerar nova linguagem.
- Implemente códigos customizados sempre no final das classes para facilitar a manutenção.
- Use o history para retornar o código mais recente.
XXX