package com.example.grocery_app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.model.GroceryItem;
import com.example.repository.GroceryItemRepository;
import com.example.service.GroceryItemService;
@SpringBootTest
public class GroceryItemServiceTest {

    @Mock
    private GroceryItemRepository repository;

    @InjectMocks
    private GroceryItemService service;

    @Test
    void testSaveItem() {
        GroceryItem item = new GroceryItem();
        item.setName("Apple");
        item.setQuantity(5);

        when(repository.save(item)).thenReturn(item);

        GroceryItem result = service.save(item);
        assertEquals("Apple", result.getName());
    }
}
