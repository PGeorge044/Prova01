package com.example.demo.service;

import com.example.demo.model.Item;
import com.example.demo.exception.InvalidItemDataException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final List<Item> items = new ArrayList<>();

    // LISTAR TODOS
    public List<Item> getAllItems() {
        return items;
    }

    // CRIAR ITEM
    public Item createItem(Item item) {
        if (item.getName() == null || item.getName().trim().isEmpty()) {
            throw new InvalidItemDataException("Nome inválido");
        }

        if (item.getDescription() == null || item.getDescription().trim().isEmpty()) {
            throw new InvalidItemDataException("Descrição inválida");
        }

        items.add(item);
        return item;
    }

    // BUSCAR POR ID
    public Optional<Item> getItemById(Long id) {
        return items.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();
    }

    // 🔹 NOVO: BUSCAR POR NOME
    public List<Item> findByName(String name) {
        return items.stream()
                .filter(item -> item.getName().equalsIgnoreCase(name))
                .toList();
    }

    // 🔹 NOVO: CONTAR ITENS
    public int count() {
        return items.size();
    }
}