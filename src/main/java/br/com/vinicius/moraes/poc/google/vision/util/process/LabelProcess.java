package br.com.vinicius.moraes.poc.google.vision.util.process;

import java.util.List;
import java.util.stream.Collectors;

import com.google.cloud.vision.v1.AnnotateImageResponse;

import br.com.vinicius.moraes.poc.google.vision.model.result.Label;

public class LabelProcess {

	public static List<Label> process(AnnotateImageResponse response) {
		return response.getLabelAnnotationsList().stream().map(annotation -> {
			
			Label label = new Label();
			
			label.setDescription(annotation.getDescription());
			label.setScore(annotation.getScore());
			
			return label;
			
		}).collect(Collectors.toList());
	}

}
