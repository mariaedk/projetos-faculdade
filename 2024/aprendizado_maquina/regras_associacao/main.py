import pandas as pd
from apyori import apriori

# alunos: maria eduarda krutzsch, luan guarnieri, kaue reblin, arthur pinotti

'''
    Questão 1
'''
base_mercado1 = pd.read_csv('mercado.csv', header=None)
transacoes_mercado1 = []
for i in range(0, 10):
    transacoes_mercado1.append([str(base_mercado1.values[i,j]) for j in range(0, 4)])

# aplicar função das regras
# configurar parâmetros -> vai filtrar somente as regras que entram nessas características
regras_mercado1 = apriori(transacoes_mercado1, min_support=0.3, min_confidence=0.8, min_lift=2, min_length=2)

# listar regras de associação descobertas
resultados_mercado1 = list(regras_mercado1)

# primeira info que aparece = frozenset -> produtos
# ao lado, valores de suporte, confiança e lift
# traz 38 regras encontradas
resultados2_mercado1 = [list(x) for x in resultados_mercado1]

resultadoFormatado_mercado1 = []
for j in range(0, 3):
    resultadoFormatado_mercado1.append([list(x) for x in resultados2_mercado1[j][2]]) # na 3a coluna tem os dados de confiança e lift
print(resultadoFormatado_mercado1)


'''
    Questão 2
'''
base_mercado2 = pd.read_csv('mercado2.csv', header=None)

transacoes_mercado2 = []
for i in range(len(base_mercado2)):
    transacoes_mercado2.append([str(base_mercado2.values[i, j]) for j in range(base_mercado2.shape[1])])

'''
a) Vamos supor que você quer extrair Regras da Associação para os produtos que são vendidos pelo menos quatro vezes ao 
dia, ou seja, 28 vezes por semana (4*7). Adicione o valor de suporte de acordo com o problema.

Para adicionar o valor de suporte, você deve calcular o valor de 28 (quantidade de produtos vendidos) dividido pela 
quantidade total de produtos na base de dados.

Execute o algoritmo e responda qual é o resultado.
'''
min_vendas_semanais = 28
total_transacoes = len(base_mercado2)
min_support = min_vendas_semanais / total_transacoes
print("suporte mínimo:", min_support)

'''
b) Adicione o valor de confiança para 0.2 e o lift para 3. Quantos registros foram retornados?
'''
regras_mercado2 = apriori(transacoes_mercado2, min_support=min_support, min_confidence=0.2, min_lift=3)
resultados_mercado2 = list(regras_mercado2)
print(f"quantidade de registros retornados: {len(resultados_mercado2)}")

'''
c) Adicione o código abaixo para poder visualizar melhor os dados. Faça comentário do que acontece em cada linha do código
'''
A = []
B = []
suporte = []
confianca = []
lift = []

for resultado in resultados_mercado2:
    s = resultado[1]
    result_rules = resultado[2]
    for result_rule in result_rules:
        a = list(result_rule[0])
        b = list(result_rule[1])
        c = result_rule[2]
        l = result_rule[3]
        A.append(a)
        B.append(b)
        suporte.append(s)
        confianca.append(c)
        lift.append(l)

rules_df = pd.DataFrame({'A': A, 'B': B, 'suporte': suporte, 'confianca': confianca, 'lift': lift})

rules_df_sorted_by_lift = rules_df.sort_values(by='lift', ascending=False)
print("regras ordenadas por lift:")
print(rules_df_sorted_by_lift)

print('\n')
rules_df_sorted_by_confidence = rules_df.sort_values(by='confianca', ascending=False)
print("regras ordenadas por confiança:")
print(rules_df_sorted_by_confidence)

'''
d) Ordene pelo valor de confiança para verificar qual regra tem maior confiabilidade. 
Qual o valor da regra com maior confiança?
'''

print('\n')
maior_confianca = rules_df_sorted_by_confidence.iloc[0]
print("regra com maior confiança: \n")
print(maior_confianca)

'''
Resposta: a regra com maior confiança é a de "tomatoes", "olive oil" e "spaghetti".

Regra: Se "tomatoes" e "olive oil" (A) são comprados, então spaghetti (B) também é comprado.
Confiança: 0.611111 (61.11%)

nan -> indica valor nulo ou ausência, ignorar

'''


