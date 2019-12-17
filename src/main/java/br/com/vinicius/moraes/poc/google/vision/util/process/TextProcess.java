package br.com.vinicius.moraes.poc.google.vision.util.process;

import java.util.List;
import java.util.stream.Collectors;

import com.google.cloud.vision.v1.AnnotateImageResponse;

import br.com.vinicius.moraes.poc.google.vision.model.result.Text;
import br.com.vinicius.moraes.poc.google.vision.model.sub.Vertex;

public class TextProcess {

	public static List<Text> process(AnnotateImageResponse response) {
		return response.getLandmarkAnnotationsList().stream().map(annotation -> {
			
			Text text = new Text();
			
			text.setDescription(annotation.getDescription());
			
			text.setBoundingPoly(annotation.getBoundingPoly().getVerticesList().stream().map(vertices -> {
				Vertex vertex = new Vertex();
				vertex.setX(vertices.getX());
				vertex.setY(vertices.getY());
				return vertex;
			}).collect(Collectors.toList()));
			
			return text;
			
		}).collect(Collectors.toList());
	}
	
}
