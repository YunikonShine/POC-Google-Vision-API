package br.com.vinicius.moraes.poc.google.vision.model.sub;

import com.google.cloud.vision.v1.FaceAnnotation.Landmark.Type;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FaceLandmark {
	
	private Type type;
	
	private Float x;
	private Float y;
	private Float z;

}
