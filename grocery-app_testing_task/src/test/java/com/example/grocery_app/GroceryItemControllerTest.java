package com.example.grocery_app;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.controller.GroceryItemController;
import com.example.model.GroceryItem;
import com.example.service.GroceryItemService;

@WebMvcTest(GroceryItemController.class)
public class GroceryItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GroceryItemService service;

    @Test
    void testCreateItem() throws Exception {
        GroceryItem item = new GroceryItem();
        item.setId(1L);
        item.setName("Banana");
        item.setQuantity(10);

        when(service.save(any())).thenReturn(item);

        mockMvc.perform(post("/items")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Banana\", \"quantity\":10}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Banana"))
                .andExpect(jsonPath("$.quantity").value(10));
    }
}
