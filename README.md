<h3>O projeto deve: </h3>
1) Possua um link de acesso na barra de navegação com o texto "Gerencie Vocábulos" que
direcione à nova página;


2) Abra uma lista contendo todos os vocábulos cadastrados no banco de dados ao ser aberta. Cada
vocábulo deve apresentar somente id, termo, significado, versão e situação. A situação deve ser
preenchida de acordo com a coluna “voc_data_hora_desativacao”, assumindo valor “desativado”
se estiver preenchida ou “ativo” se possuir valor nulo;


3) Permita o cadastro de um novo vocábulo. Após o cadastro, a lista do item 2 deve ser atualizada e
os "inputs" devem ser limpos;


4) Permita a consulta de um vocábulo usando termo e versão. O resultado deve ser apresentado na
mesma lista do item 2. Caso nenhum vocábulo com as características buscadas exista, substitua a
lista por uma mensagem (exemplo: “Nenhum vocábulo foi encontrado para os critérios
fornecidos”).



Dicas:
● Em caso de erro por diferença de versões do Java, use o comando "mvn clean" no terminal;
● Não esqueça de criar o banco de dados antes de executar o backend;
● Para entradas do tipo "datetime" é possíve utilizar o tipo "datetime-local" de "input"
(https://www.w3schools.com/tags/att_input_type_datetime-local.asp).
