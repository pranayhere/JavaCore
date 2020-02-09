package com.pranay.GeeksForGeeks;

public class AngleBetweenHandsOfClock {
	public static void main(String[] args) {
		int hour = 12, minutes = 30;
		double angle = angleClock(hour, minutes);
		System.out.println(angle);
	}

	public static double angleClock(int h, int m) {
		if (h == 12)
			h = 0;
		if (m == 60)
			m = 0;

		double hour_angle = (double) (0.5 * (h * 60 + m));
		double minute_angle = (double) (6 * m);

		double angle = Math.abs(hour_angle - minute_angle);
		angle = Math.min(360 - angle, angle);
		return angle;
	}
}
