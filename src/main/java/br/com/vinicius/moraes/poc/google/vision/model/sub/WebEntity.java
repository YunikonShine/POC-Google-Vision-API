package br.com.vinicius.moraes.poc.google.vision.model.sub;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WebEntity {
	
	private String entityId;
	private String description;
	
	private Float score;
	
}
