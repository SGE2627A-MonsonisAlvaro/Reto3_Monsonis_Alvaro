package com.iesdoctorbalmis.spring.controller.rest;

import com.iesdoctorbalmis.spring.entity.Producto;
import com.iesdoctorbalmis.spring.repository.ProductoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// @RestController = @Controller + @ResponseBody
// Devuelve JSON directamente, sin necesidad de plantilla Thymeleaf
@RestController
@RequestMapping("/api/productos")
public class ProductoRestController {

    private final ProductoRepository productoRepository;

    public ProductoRestController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    // GET /api/productos → lista JSON de todos los productos
    @GetMapping
    public List<Producto> listar() {
        return productoRepository.findAll();
    }
}