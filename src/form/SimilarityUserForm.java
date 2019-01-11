package form;

import model.Default;

public class SimilarityUserForm extends Default{
	private double similarity;//類似度

	public double getSimilarity() {
		return similarity;
	}

	public void setSimilarity(Double similarity) {
		this.similarity = similarity;
	}

	public int getSimilarityInt() {
		double tm= similarity*100000;
		int simInt = (int) (tm);
		return simInt;
	}
}
