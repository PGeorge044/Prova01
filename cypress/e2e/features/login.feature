#language: pt
Funcionalidade: Login de Usuário
    Como um usuário registrado
    Eu quero fazer login no swags labs
    Para acessar a loja (tela Products) ou não  acessar (tela de erro) dependendo das credenciais fornecidas

    Cenário: Login válido
        Dado que o usuário está na página de login do swags labs
        Quando o usuário informar usuário e senha e confirmar
        Então o usuário deve ser redirecionado para a página Products