/// <reference types="cypress" />

import { Given, When, Then, And } from 'cypress-cucumber-preprocessor/steps';

Given('que o usuário está na página de login do swags labs', () => {
    cy.visit('https://www.saucedemo.com/');
    cy.log('Navegou para a página de login do Swag Labs');
});

When('o usuário informar usuário e senha e confirmar', () => {
    cy.get('[data-test="username"]').type('standard_user');
    cy.get('[data-test="password"]').type('secret_sauce');
    cy.get('[data-test="login-button"]').click();
    cy.log('Usuário informou credenciais e confirmou o login');
});

Then('o usuário deve ser redirecionado para a página Products', () => {
    cy.get('[data-test="title"]').should('be.visible');
    cy.log('Usuário foi redirecionado para a página Products com sucesso');
});