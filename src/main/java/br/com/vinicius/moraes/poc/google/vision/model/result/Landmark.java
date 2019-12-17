package br.com.vinicius.moraes.poc.google.vision.model.result;

import java.util.List;

import br.com.vinicius.moraes.poc.google.vision.model.sub.Coordinates;
import br.com.vinicius.moraes.poc.google.vision.model.sub.Vertex;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Landmark {

	private String description;

	private Float score;

	private List<Vertex> boundingPoly;
	private List<Coordinates> locations;

}
