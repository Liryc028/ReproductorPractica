package com.mx.ReproductorPractica.Respuesta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Respuesta {

	String respuesta;
	Object obj;
	boolean success;

}
