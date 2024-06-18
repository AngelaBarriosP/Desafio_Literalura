package com.aluracursos.buscalibros;

import com.aluracursos.buscalibros.principal.PrincipalBusqueda;
import com.aluracursos.buscalibros.repositorio.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BuscalibrosApplication implements CommandLineRunner {

	@Autowired
	private LibroRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(BuscalibrosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		PrincipalBusqueda principalBusqueda = new PrincipalBusqueda(repository);
		principalBusqueda.muestraElMenu();
	}
}
