package com.example.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.model.GroceryItem;
import com.example.service.GroceryItemService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/items")
public class GroceryItemController {

    private final GroceryItemService service;

    public GroceryItemController(GroceryItemService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<GroceryItem> create(@Valid @RequestBody GroceryItem item) {
        return ResponseEntity.ok(service.save(item));
    }

    @GetMapping
    public List<GroceryItem> getAll() {
        return service.getAllItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroceryItem> getById(@PathVariable Long id) {
        return service.getItemById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<GroceryItem> update(@PathVariable Long id, @Valid @RequestBody GroceryItem updatedItem) {
        GroceryItem updated = service.updateItem(id, updatedItem);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteItem(id);
        return ResponseEntity.noContent().build();
    }
}
