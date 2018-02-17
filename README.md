# Desencripta
Trabalho final  da matéria Linguagens e Técnicas de Programação I, do primeiro período do curso de Ciência da Computação da Universidade FUMEC (Jun/2016).

## Funcionamento
O programa pede que o usuário entre com uma mensagem codificada (números) e com uma matriz, que é a chave decodificadora. 

Então a mensagem decodificada é gerada a partir da seguinte fórmula: (M x C) x C^-1 = M

Onde M x C é a mensagem codificada, C^-1 é a matriz inversa da chave decodificadora e M é a mensagem final decodificada

No final, os valores da matriz mensagem são convertidos para caracteres Ascii.

## Valores para teste
Mensagem codificada: 29, 49, -66, 49, 91, -122, 25, 31, -55

Chave: -1, -2, 3, 2, 3, -5, 2, 4, -5
