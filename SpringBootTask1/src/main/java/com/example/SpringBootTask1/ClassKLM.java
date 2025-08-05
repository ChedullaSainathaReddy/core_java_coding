package com.example.SpringBootTask1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component
public class ClassKLM {

    @Autowired
    @Qualifier("classABC") // Injecting ClassABC specifically
    private InterfacePQR interfacePQR;

    public void show() {
        interfacePQR.display();

}
}
