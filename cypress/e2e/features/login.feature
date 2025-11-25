#language: pt

Funcionalidade: Logins válidos e inválidos

    Eu, como usuário do sistema,
    Quero testar diferentes cenários de login,
    Para garantir que o sistema autentique corretamente os usuários.

    Contexto: Estar na página de login do saucedemo
        Dado que eu estou na página de login do saucedemo

    Cenário: Login válido - Usuário padrão
        Quando eu insiro o usuário padrão e a senha correta
        E clico no botão de login
        Então eu devo ser redirecionado para a página de Produtos
    
    # Cenário: Login inválido - Usuário errado
    #     Quando eu insiro um usuário inválido e a senha correta
    #     E clico no botão de login
    #     Então eu devo ver uma mensagem de erro indicando que o usuário é inválido

     Cenário: Login válido - Usuário padrão
        Quando eu insiro o usuário "standard_user"
        E inserir a senha "secret_sauce"
        E clico no botão de login
        Então eu devo ser redirecionado para a página de Produtos
        
    Cenário: Login inválido - Usuário errado
        Quando eu insiro o usuário "standard_errado"
        E inserir a senha "secret_sauce"
        E clico no botão de login
        Então eu devo ver uma mensagem de erro "Epic sadface: Username and password do not match any user in this service"

    Cenário: Login inválido - Senha errada
        Quando eu insiro o usuário "standard_user"
        E inserir a senha "secret_errada"
        E clico no botão de login
        Então eu devo ver uma mensagem de erro "Epic sadface: Username and password do not match any user in this service"

    Cenário: Login inválido - Usuário branco
        Quando eu insiro o usuário ""
        E inserir a senha "secret_sauce"
        E clico no botão de login
        Então eu devo ver uma mensagem de erro "Epic sadface: Username is required"
    
    Cenário: Login inválido - Senha em branco
        Quando eu insiro o usuário "standard_user"
        E inserir a senha ""
        E clico no botão de login
        Então eu devo ver uma mensagem de erro "Epic sadface: Password is required"

    Esquema do Cenário: Logins inválidos: Usuário "<username>" e Senha "<password>"
        Quando eu insiro o usuário "<username>"
        E inserir a senha "<password>"
        E clico no botão de login
        Então eu devo ver uma mensagem de erro "<errorMessage>"

        Exemplos:
            | username          | password       | errorMessage                                                        |
            | standard_errado   | secret_sauce   | Epic sadface: Username and password do not match any user in this service |
            | standard_user     | secret_errada  | Epic sadface: Username and password do not match any user in this service |
            |                   | secret_sauce   | Epic sadface: Username is required                                  |
            | standard_user     |                | Epic sadface: Password is required                                  |
            | locked_out_user   | secret_sauce   | Epic sadface: Sorry, this user has been locked out.                 |