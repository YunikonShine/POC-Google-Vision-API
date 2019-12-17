package br.com.vinicius.moraes.poc.google.vision.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.google.cloud.vision.v1.AnnotateImageResponse;

import br.com.vinicius.moraes.poc.google.vision.model.VisionResult;
import br.com.vinicius.moraes.poc.google.vision.util.process.FaceProcess;
import br.com.vinicius.moraes.poc.google.vision.util.process.LabelProcess;
import br.com.vinicius.moraes.poc.google.vision.util.process.LandmarkProcess;
import br.com.vinicius.moraes.poc.google.vision.util.process.LogoProcess;
import br.com.vinicius.moraes.poc.google.vision.util.process.SafeSearchProcess;
import br.com.vinicius.moraes.poc.google.vision.util.process.TextProcess;
import br.com.vinicius.moraes.poc.google.vision.util.process.WebProcess;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

public class ResponseProcess {

	public static VisionResult process(AnnotateImageResponse response) {

		VisionResult result = new VisionResult();

		result.setFaces(FaceProcess.process(response));
		result.setLabels(LabelProcess.process(response));
		result.setLandmarks(LandmarkProcess.process(response));
		result.setLogos(LogoProcess.process(response));
		result.setTexts(TextProcess.process(response));
		
		result.setSafeSearch(SafeSearchProcess.process(response));
		result.setWeb(WebProcess.process(response));

		return result;

	}
	
	public static List<String> process(String response, Class<?> cClass) throws IOException {
		
		InputStream inputStream = cClass.getResourceAsStream("/models/pt-token.bin");
		TokenizerModel model = new TokenizerModel(inputStream);
		TokenizerME tokenizer = new TokenizerME(model);
		String[] tokens = tokenizer.tokenize(response);
		inputStream.close();

		List<String> returnList = new ArrayList<String>();

		for (String s : tokens) {
			String textFilter = "";
			for (Character c : s.toCharArray()) {
				if (Character.isLetterOrDigit(c)) {
					textFilter += c;
				}
			}
			if (textFilter.length() > 0) {
				returnList.add(textFilter);
			}
		}

		return returnList;
		
	}

}
