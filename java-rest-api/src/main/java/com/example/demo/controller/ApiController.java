package com.example.demo.controller;

import com.example.demo.model.Item;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import com.example.demo.exception.InvalidItemDataException;
@Autowired
private ItemService itemService;

@RestController
@RequestMapping("/api/items")
public class ApiController {

    private List<Item> items = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<Item>> getAllItems() {
        return ResponseEntity.ok(items);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Item>> searchByName(@RequestParam String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidItemDataException("Nome não pode ser vazio");
        }
        List<Item> items = itemService.findByName(name);
        return ResponseEntity.ok(items);
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> countItems() {
        return ResponseEntity.ok(itemService.count());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        // Atribui um novo ID para garantir que seja único
        item.setId(counter.incrementAndGet());
        items.add(item);
        // Retorna o status 201 Created, que é a prática correta
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item item) {

        if (item.getName() == null || item.getName().isEmpty()) {
            throw new InvalidItemDataException("Nome inválido");
        }

        if (item.getDescription() == null || item.getDescription().isEmpty()) {
            throw new InvalidItemDataException("Descrição inválida");
        }

        items.add(item); // ou service.createItem(item)

        return ResponseEntity.status(201).body(item);
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        return items.stream()
                .filter(item -> id.equals(item.getId()))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}