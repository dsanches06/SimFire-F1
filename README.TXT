----------------------------------------------------------------------------
Este é o arquivo README do projeto. Você deve descrever aqui o seu projeto.
Informe ao usuário (alguém que não sabe nada sobre este projeto!) tudo que
ele/ela precisa saber. Os comentários devem incluir, pelo menos:
------------------------------------------------------------------------

TITULO DO PROJETO:
OBJETIVO DO PROJETO:
VERSÃO ou DATA:
COMO INICIAR O PROJETO:
AUTORES:
INSTRUÇÕES PARA O USUÁRIO:


Bombeiro:
- id
- quartel
- veiculo
  - tipo de incendio
- nivel de energia
- pode conduzir veiculo ou nao

- operam veiculos se tiverem habilitado
  - usam mangueira para apagar fogo
- os restantens podem ajudar 
- 1 bombeiro nao pode estar mais de 18h seguidas apagando fogo
  - descansar pelo 6h
- 1 bombeiro no veiculo em movimento 
  - consome metade de energia
    - permite descansar mais de 18h maxima

Veiculos de Combate:
- id
- capacidade atual de agua
- capacidade maxima entre 1500 a 20000 litros de aguas em ]500[
- quartel
- incendio (tipo)
- lugar para 3 a 8 bombeiros
- posicao  
  - o valor da latitude no intervalo de [-90.0, 90.0] graus (>0 é norte, <0 é sul)
  - e o da longitude de [-180.0, 180.0] graus (>0 é este, <0 é oeste)


Posto de Abastecimento:
- nome/designaçao
- contem agua
- localizaçao
- recebe veiculos para reabastecer
  - somente os da mesma posiçao

Incendio:
- localizaçao
- area do incendio (m^2)
- meios alocado ao combate
- hora de inicio e fim

Tempo - condiçoes climaterica:
- temperatura em ºC -> ]0, 45[
- humidade em % -> ]0 a 100[
- velocidade vento em km/h -> ]0 a 100[

Quarteis:
- nome
- localizaçao
- capacidade maxima de veiculos
- capacidade maxima de bombeiros


Classe Time