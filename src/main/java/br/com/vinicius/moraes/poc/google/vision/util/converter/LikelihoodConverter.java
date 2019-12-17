package br.com.vinicius.moraes.poc.google.vision.util.converter;

import com.google.cloud.vision.v1.Likelihood;

public class LikelihoodConverter {

	public static float likelihoodToNumber(Likelihood likelihood) {

		switch (likelihood) {

		case UNKNOWN:
			return 0f;
		case VERY_UNLIKELY:
			return 0.2f;
		case UNLIKELY:
			return 0.4f;
		case POSSIBLE:
			return 0.6f;
		case LIKELY:
			return 0.8f;
		case VERY_LIKELY:
			return 1f;
		case UNRECOGNIZED:
			return 0f;
		default:
			return 0f;

		}

	}

}
