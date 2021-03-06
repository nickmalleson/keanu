package io.improbable.keanu.distributions.continuous;

import java.util.Random;

import static org.apache.commons.math3.special.Gamma.gamma;

public class ChiSquared {

    public static double sample(int k, Random random) {
        assert (k >= 1);
        return Gamma.sample(0.0, 2.0, 0.5 * (double) k, random);
    }

    public static double pdf(int k, double x) {
        if (x > 0) {
            double halfK = (double) k / 2;
            double numerator = Math.pow(x, halfK - 1) * Math.exp(-x / 2);
            double denominator = Math.pow(2, halfK) * gamma(halfK);
            return numerator / denominator;
        } else {
            return 0;
        }
    }

    public static double logPdf(int k, double x) {
        assert (x > 0);
        double halfK = (double) k / 2;
        double numerator = ((halfK - 1) * Math.log(x)) - (x / 2);
        double denominator = (halfK * Math.log(2) + Math.log(gamma(halfK)));
        return numerator - denominator;
    }

}