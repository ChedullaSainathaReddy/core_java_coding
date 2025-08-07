package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.GroceryItem;
import com.example.repository.GroceryItemRepository;

@Service
public class GroceryItemService {

    @Autowired
    private GroceryItemRepository repository;

    // ✅ Create/Save method
    public GroceryItem save(GroceryItem item) {
        return repository.save(item);
    }

    public List<GroceryItem> getAllItems() {
        return repository.findAll();
    }

    public Optional<GroceryItem> getItemById(Long id) {
        return repository.findById(id);
    }

    public GroceryItem updateItem(Long id, GroceryItem updatedItem) {
        return repository.findById(id)
                .map(existingItem -> {
                    existingItem.setName(updatedItem.getName());
                    existingItem.setQuantity(updatedItem.getQuantity());
                    return repository.save(existingItem);
                }).orElseThrow(() -> new RuntimeException("Item not found with id: " + id));
    }

    public void deleteItem(Long id) {
        repository.deleteById(id);
    }
}