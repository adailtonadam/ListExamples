ListExamples
============

Android Studio: Exemplos de ListView e ExpandableListView

Problemas ocorridos.
1 - Evento de onclick em um textview sobrepôs o evento de alterar a cor quando se clica no item da lista.
  A solução foi colocar o selector no background do textview que ocupa a area toda.
  
2 - Utilizando o selector, não é possível diferenciar se um item numa lista expandida está vazia. 
   A variável state_empty do selector  somente é validada quando o item está expandido.

