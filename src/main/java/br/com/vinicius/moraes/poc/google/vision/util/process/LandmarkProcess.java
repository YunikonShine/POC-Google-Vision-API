package br.com.vinicius.moraes.poc.google.vision.util.process;

import java.util.List;
import java.util.stream.Collectors;

import com.google.cloud.vision.v1.AnnotateImageResponse;

import br.com.vinicius.moraes.poc.google.vision.model.result.Landmark;
import br.com.vinicius.moraes.poc.google.vision.model.sub.Coordinates;
import br.com.vinicius.moraes.poc.google.vision.model.sub.Vertex;

public class LandmarkProcess {

	public static List<Landmark> process(AnnotateImageResponse response) {
		return response.getLandmarkAnnotationsList().stream().map(annotation -> {
			
			Landmark landmark = new Landmark();
			
			landmark.setDescription(annotation.getDescription());
			landmark.setScore(annotation.getScore());
			
			landmark.setBoundingPoly(annotation.getBoundingPoly().getVerticesList().stream().map(vertices -> {
				Vertex vertex = new Vertex();
				vertex.setX(vertices.getX());
				vertex.setY(vertices.getY());
				return vertex;
			}).collect(Collectors.toList()));
			
			landmark.setLocations(annotation.getLocationsList().stream().map(locations -> {
				Coordinates coordinates = new Coordinates();
				coordinates.setLat(locations.getLatLng().getLatitude());
				coordinates.setLng(locations.getLatLng().getLongitude());
				return coordinates;
			}).collect(Collectors.toList()));
			
			return landmark;
			
		}).collect(Collectors.toList());
	}
	
}
