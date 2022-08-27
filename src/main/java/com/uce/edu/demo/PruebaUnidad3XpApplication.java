package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoSencillo;
import com.uce.edu.demo.repository.modelo.VentaSencillo;
import com.uce.edu.demo.service.IProductoService;
import com.uce.edu.demo.service.IVentaService;

@SpringBootApplication
public class PruebaUnidad3XpApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(PruebaUnidad3XpApplication.class);

	@Autowired
	private IProductoService iProductoService;
	@Autowired
	private IVentaService iVentaService;

	public static void main(String[] args) {
		SpringApplication.run(PruebaUnidad3XpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Producto producto = new Producto();
		producto.setNombre("Pilsener");
		producto.setCategoria("alcohol");
		producto.setPrecio(new BigDecimal(2.50));
		producto.setCodigoBarra("A10000");
		producto.setStock(15);

		// 1. Ingresar Productos
	//	this.iProductoService.insertar(producto);

		List<ProductoSencillo> productoSencillos = new ArrayList<>();
		ProductoSencillo productoSencillo = new ProductoSencillo();
		productoSencillo.setCantidad(3);
		productoSencillo.setCodigoBarras("A10000");

		productoSencillos.add(productoSencillo);
		//2. Realizar Venta
	//	this.iVentaService.realizarVenta(productoSencillos, "12389121", "2");
		
		//3. Reporte ventas
	//	List<VentaSencillo> lista =this.iVentaService.buscarPorFechaCategoriaCantidad(LocalDateTime.now(),"alcohol" , 3);
     //   for (VentaSencillo ventaSencillo : lista) {
     //       LOG.debug("Reporte Venta: " + ventaSencillo);
     //   }
		
		
		//4. Consultar stock
		LOG.info(""+this.iProductoService.buscarPorCodigoBarras("A10000"));

		
	}

}
