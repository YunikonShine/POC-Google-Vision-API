package br.com.vinicius.moraes.poc.google.vision.util.process;

import com.google.cloud.vision.v1.AnnotateImageResponse;

import br.com.vinicius.moraes.poc.google.vision.model.result.SafeSearch;
import br.com.vinicius.moraes.poc.google.vision.util.converter.LikelihoodConverter;

public class SafeSearchProcess {

	public static SafeSearch process(AnnotateImageResponse response) {
		
		SafeSearch safeSearch = new SafeSearch();
		
		safeSearch.setAdult(response.getSafeSearchAnnotation().getAdult());
		safeSearch.setAdultRating(LikelihoodConverter.likelihoodToNumber(response.getSafeSearchAnnotation().getAdult()));
		
		safeSearch.setSpoof(response.getSafeSearchAnnotation().getSpoof());
		safeSearch.setSpoofRating(LikelihoodConverter.likelihoodToNumber(response.getSafeSearchAnnotation().getSpoof()));
		
		safeSearch.setMedical(response.getSafeSearchAnnotation().getMedical());
		safeSearch.setMedicalRating(LikelihoodConverter.likelihoodToNumber(response.getSafeSearchAnnotation().getMedical()));
		
		safeSearch.setViolence(response.getSafeSearchAnnotation().getViolence());
		safeSearch.setViolenceRating(LikelihoodConverter.likelihoodToNumber(response.getSafeSearchAnnotation().getViolence()));
		
		return safeSearch;
		
	}
	
}
