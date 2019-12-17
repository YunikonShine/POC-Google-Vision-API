package br.com.vinicius.moraes.poc.google.vision.util.process;

import java.util.stream.Collectors;

import com.google.cloud.vision.v1.AnnotateImageResponse;

import br.com.vinicius.moraes.poc.google.vision.model.result.Web;
import br.com.vinicius.moraes.poc.google.vision.model.sub.WebEntity;
import br.com.vinicius.moraes.poc.google.vision.model.sub.WebUrl;

public class WebProcess {

	public static Web process(AnnotateImageResponse response) {
		
		Web web = new Web();
		
		web.setWebEntities(response.getWebDetection().getWebEntitiesList().stream().map(list -> {

			WebEntity webEntity = new WebEntity();

			webEntity.setEntityId(list.getEntityId());
			webEntity.setDescription(list.getDescription());
			webEntity.setScore(list.getScore());

			return webEntity;

		}).collect(Collectors.toList()));

		web.setFullMatchingImages(response.getWebDetection().getFullMatchingImagesList().stream().map(list -> {

			WebUrl webUrl = new WebUrl();

			webUrl.setUrl(list.getUrl());
			webUrl.setScore(list.getScore());

			return webUrl;

		}).collect(Collectors.toList()));

		web.setPartialMatchingImages(response.getWebDetection().getPartialMatchingImagesList().stream().map(list -> {

			WebUrl webUrl = new WebUrl();

			webUrl.setUrl(list.getUrl());
			webUrl.setScore(list.getScore());

			return webUrl;

		}).collect(Collectors.toList()));

		web.setPagesWithMatchingImages(response.getWebDetection().getPagesWithMatchingImagesList().stream().map(list -> {

			WebUrl webUrl = new WebUrl();

			webUrl.setUrl(list.getUrl());
			webUrl.setScore(list.getScore());

			return webUrl;

		}).collect(Collectors.toList()));

		return web;
		
	}

}
