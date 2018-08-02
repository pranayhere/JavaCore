package com.pranay.MovingAvg;

import java.util.List;

public class MAv {
	public static void main(String[] args) {
		double[] source = {10.4, 11.6, 10.1, 10.7, 11.9, 11.5, 10.7, 10.8, 10.6};
		double[] result = MA(2, source);
		System.out.println("val-----------------------min--------------------------avg-----------------------------max");
		for(int i=0; i<result.length; i++) {
			double min = result[i] - ((0.05)*result[i]);
			double max = result[i] + ((0.05)*result[i]);
			System.out.println(source[i]+"----------"+min+"-------"+result[i]+"-------------"+max);
		}
	}

	private static double[] MA(int period, double[] source) {
		double[] ma = new double[source.length];

		double sum = 0;
		for (int bar = 0; bar < period; bar++)
			sum += source[bar];

		ma[period - 1] = sum/period;

		for (int bar = period; bar < source.length; bar++)
			ma[bar] = ma[bar - 1] + source[bar]/period
			- source[bar - period]/period;
		return ma;
	}
}
