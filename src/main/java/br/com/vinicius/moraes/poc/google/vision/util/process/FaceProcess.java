package br.com.vinicius.moraes.poc.google.vision.util.process;

import java.util.List;
import java.util.stream.Collectors;

import com.google.cloud.vision.v1.AnnotateImageResponse;

import br.com.vinicius.moraes.poc.google.vision.model.result.Face;
import br.com.vinicius.moraes.poc.google.vision.model.sub.FaceLandmark;
import br.com.vinicius.moraes.poc.google.vision.model.sub.Vertex;
import br.com.vinicius.moraes.poc.google.vision.util.converter.LikelihoodConverter;

public class FaceProcess {

	public static List<Face> process(AnnotateImageResponse response) {
		return response.getFaceAnnotationsList().stream().map(annotation -> {
			
			Face face = new Face();

			face.setRollAngle(annotation.getRollAngle());
			face.setPanAngle(annotation.getPanAngle());
			face.setTiltAngle(annotation.getTiltAngle());
			face.setDetectionConfidence(annotation.getDetectionConfidence());
			face.setLandmarkingConfidence(annotation.getLandmarkingConfidence());
			
			face.setJoy(annotation.getJoyLikelihood());
			face.setJoyRating(LikelihoodConverter.likelihoodToNumber(annotation.getJoyLikelihood()));
			
			face.setSorrow(annotation.getSorrowLikelihood());
			face.setSorrowRating(LikelihoodConverter.likelihoodToNumber(annotation.getSorrowLikelihood()));
			
			face.setAnger(annotation.getAngerLikelihood());
			face.setAngerRating(LikelihoodConverter.likelihoodToNumber(annotation.getAngerLikelihood()));
			
			face.setSurprise(annotation.getSurpriseLikelihood());
			face.setSurpriseRating(LikelihoodConverter.likelihoodToNumber(annotation.getSurpriseLikelihood()));
			
			face.setUnderExposed(annotation.getUnderExposedLikelihood());
			face.setUnderExposedRating(LikelihoodConverter.likelihoodToNumber(annotation.getUnderExposedLikelihood()));
			
			face.setBlurred(annotation.getBlurredLikelihood());
			face.setBlurredRating(LikelihoodConverter.likelihoodToNumber(annotation.getBlurredLikelihood()));
			
			face.setHeadwear(annotation.getHeadwearLikelihood());
			face.setHeadwearRating(LikelihoodConverter.likelihoodToNumber(annotation.getHeadwearLikelihood()));

			face.setBoundingPoly(annotation.getBoundingPoly().getVerticesList().stream().map(vertices -> {
				Vertex vertex = new Vertex();
				vertex.setX(vertices.getX());
				vertex.setY(vertices.getY());
				return vertex;
			}).collect(Collectors.toList()));

			face.setFdBoundingPoly(annotation.getFdBoundingPoly().getVerticesList().stream().map(vertices -> {
				Vertex vertex = new Vertex();
				vertex.setX(vertices.getX());
				vertex.setY(vertices.getY());
				return vertex;
			}).collect(Collectors.toList()));

			face.setLandmarks(annotation.getLandmarksList().stream().map(landmark -> {
				FaceLandmark faceLandmark = new FaceLandmark();
				faceLandmark.setType(landmark.getType());
				faceLandmark.setX(landmark.getPosition().getX());
				faceLandmark.setY(landmark.getPosition().getY());
				faceLandmark.setZ(landmark.getPosition().getZ());
				return faceLandmark;
			}).collect(Collectors.toList()));

			return face;

		}).collect(Collectors.toList());
	}

}
