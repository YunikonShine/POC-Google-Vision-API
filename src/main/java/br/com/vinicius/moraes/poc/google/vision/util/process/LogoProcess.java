package br.com.vinicius.moraes.poc.google.vision.util.process;

import java.util.List;
import java.util.stream.Collectors;

import com.google.cloud.vision.v1.AnnotateImageResponse;

import br.com.vinicius.moraes.poc.google.vision.model.result.Logo;
import br.com.vinicius.moraes.poc.google.vision.model.sub.Vertex;

public class LogoProcess {

	public static List<Logo> process(AnnotateImageResponse response) {
		return response.getLogoAnnotationsList().stream().map(annotation -> {
			
			Logo logo = new Logo();
			
			logo.setDescription(annotation.getDescription());
			logo.setScore(annotation.getScore());
			
			logo.setBoundingPoly(annotation.getBoundingPoly().getVerticesList().stream().map(vertices -> {
				Vertex vertex = new Vertex();
				vertex.setX(vertices.getX());
				vertex.setY(vertices.getY());
				return vertex;
			}).collect(Collectors.toList()));
			
			return logo;
			
		}).collect(Collectors.toList());
	}
	
}
