/// <reference types="cypress" />

import { Given, When, Then, And } from "cypress-cucumber-preprocessor/steps";

Given('que eu estou na página de login do saucedemo', () => {
    cy.log('Acessando a página de login do saucedemo');
    cy.visit('https://www.saucedemo.com/');
});

When('eu insiro o usuário padrão e a senha correta', () => {
    cy.log('Inserindo usuário padrão e senha correta');
    cy.get('[data-test="username"]').type('standard_user');
    cy.get('[data-test="password"]').type('secret_sauce');
});

And('clico no botão de login', () => {
    cy.log('Clicando no botão de login');
    cy.get('[data-test="login-button"]').click();
});

Then('eu devo ser redirecionado para a página de Produtos', () => {
    cy.log('Verificando se foi redirecionado para a página de Produtos');
    cy.get('[data-test="title"]').should('be.visible');
});

When('eu insiro um usuário inválido e a senha correta', () => {
    cy.log('Inserindo usuário inválido e senha correta');
    cy.get('[data-test="username"]').type('standard_errado');
    cy.get('[data-test="password"]').type('secret_sauce');
});

Then('eu devo ver uma mensagem de erro de usuário ou senha incorretos', () => {
    cy.log('Verificando mensagem de erro de usuário ou senha incorretos');
    cy.get('[data-test="error"]').should('have.text', 'Epic sadface: Username and password do not match any user in this service');
});

When('eu insiro o usuário {string}', (username) => {
    cy.log(`Inserindo usuário: ${username}`);
    if (username == "") {
        cy.get('[data-test="username"]').clear();
        return;
    } else {
        cy.get('[data-test="username"]').clear().type(username);
    }
});
When('inserir a senha {string}', (password) => {
    cy.log(`Inserindo senha`);
    if (password == "") {
        cy.get('[data-test="password"]').clear()
        return;
    } else {
            cy.get('[data-test="password"]').clear().type(password);
    }
}); 

Then('eu devo ver uma mensagem de erro {string}', (errorMessage) => {
    cy.log(`Verificando mensagem de erro: ${errorMessage}`);
    cy.get('[data-test="error"]').should('have.text', errorMessage);
    cy.screenshot();
});