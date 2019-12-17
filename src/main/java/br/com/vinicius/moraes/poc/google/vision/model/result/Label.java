package br.com.vinicius.moraes.poc.google.vision.model.result;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Label {

	private String description;

	private Float score;

}
