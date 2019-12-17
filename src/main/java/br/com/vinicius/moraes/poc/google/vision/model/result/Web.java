package br.com.vinicius.moraes.poc.google.vision.model.result;

import java.util.List;

import br.com.vinicius.moraes.poc.google.vision.model.sub.WebEntity;
import br.com.vinicius.moraes.poc.google.vision.model.sub.WebUrl;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Web {

	private List<WebEntity> webEntities;
	private List<WebUrl> fullMatchingImages;
	private List<WebUrl> partialMatchingImages;
	private List<WebUrl> pagesWithMatchingImages;

	
}
