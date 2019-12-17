package br.com.vinicius.moraes.poc.google.vision.model.result;

import java.util.List;

import com.google.cloud.vision.v1.Likelihood;

import br.com.vinicius.moraes.poc.google.vision.model.sub.FaceLandmark;
import br.com.vinicius.moraes.poc.google.vision.model.sub.Vertex;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Face {

	private Float rollAngle;
	private Float panAngle;
	private Float tiltAngle;
	private Float detectionConfidence;
	private Float landmarkingConfidence;
	private Float joyRating;
	private Float sorrowRating;
	private Float angerRating;
	private Float surpriseRating;
	private Float underExposedRating;
	private Float blurredRating;
	private Float headwearRating;
	
	private Likelihood joy;
	private Likelihood sorrow;
	private Likelihood anger;
	private Likelihood surprise;
	private Likelihood underExposed;
	private Likelihood blurred;
	private Likelihood headwear;

	private List<Vertex> boundingPoly;
	private List<Vertex> fdBoundingPoly;
	private List<FaceLandmark> landmarks;

}
