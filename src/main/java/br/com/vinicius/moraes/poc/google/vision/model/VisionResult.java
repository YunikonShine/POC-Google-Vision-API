package br.com.vinicius.moraes.poc.google.vision.model;

import java.util.List;

import br.com.vinicius.moraes.poc.google.vision.model.result.Face;
import br.com.vinicius.moraes.poc.google.vision.model.result.Label;
import br.com.vinicius.moraes.poc.google.vision.model.result.Landmark;
import br.com.vinicius.moraes.poc.google.vision.model.result.Logo;
import br.com.vinicius.moraes.poc.google.vision.model.result.SafeSearch;
import br.com.vinicius.moraes.poc.google.vision.model.result.Text;
import br.com.vinicius.moraes.poc.google.vision.model.result.Web;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class VisionResult {

	private List<Face> faces;
	private List<Label> labels;
	private List<Landmark> landmarks;
	private List<Logo> logos;
	private List<Text> texts;
	
	private SafeSearch safeSearch;

	private Web web;

}
