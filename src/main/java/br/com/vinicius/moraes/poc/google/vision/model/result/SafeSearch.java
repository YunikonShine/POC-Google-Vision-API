package br.com.vinicius.moraes.poc.google.vision.model.result;

import com.google.cloud.vision.v1.Likelihood;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SafeSearch {

	private Likelihood adult;
	private Likelihood spoof;
	private Likelihood medical;
	private Likelihood violence;
	
	private Float adultRating;
	private Float spoofRating;
	private Float medicalRating;
	private Float violenceRating;
}
