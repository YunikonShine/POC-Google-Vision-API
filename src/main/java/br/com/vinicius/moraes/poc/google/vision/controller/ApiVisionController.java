package br.com.vinicius.moraes.poc.google.vision.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gcp.vision.CloudVisionTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.Feature.Type;

import br.com.vinicius.moraes.poc.google.vision.model.VisionResult;
import br.com.vinicius.moraes.poc.google.vision.util.ResponseProcess;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ApiVisionController {

	@Autowired
	private CloudVisionTemplate cloudVisionTemplate;

	@PostMapping("/types")
	@ApiOperation(value = "Process image for all types")
	@ApiResponses({ @ApiResponse(code = 200, message = "Ok", response = VisionResult.class),
			@ApiResponse(code = 500, message = "Internal error") })
	public ResponseEntity<VisionResult> testAllTypes(
			@RequestParam(name = "Image to process", required = true) @NotNull(message = "File is required") MultipartFile file) {

		AnnotateImageResponse response = cloudVisionTemplate.analyzeImage(file.getResource(), Type.FACE_DETECTION,
				Type.LANDMARK_DETECTION, Type.LOGO_DETECTION, Type.LABEL_DETECTION, Type.SAFE_SEARCH_DETECTION,
				Type.IMAGE_PROPERTIES, Type.CROP_HINTS, Type.WEB_DETECTION, Type.DOCUMENT_TEXT_DETECTION,
				Type.PRODUCT_SEARCH, Type.OBJECT_LOCALIZATION);

		return ResponseEntity.ok(ResponseProcess.process(response));

	}

	@PostMapping("/text")
	@ApiOperation(value = "Extract text from image")
	@ApiResponses({ @ApiResponse(code = 200, message = "Ok"), @ApiResponse(code = 500, message = "Internal error") })
	public ResponseEntity<Map<String, List<String>>> testExtractText(
			@RequestParam(name = "Image to process", required = true) @NotNull(message = "File is required") MultipartFile file)
			throws IOException {

		Map<String, List<String>> ret = new HashMap<String, List<String>>();

		ret.put("Google Return", Arrays.asList(cloudVisionTemplate.extractTextFromImage(file.getResource())));
		ret.put("List Return",
				ResponseProcess.process(cloudVisionTemplate.extractTextFromImage(file.getResource()), getClass()));

		return ResponseEntity.ok(ret);

	}

}