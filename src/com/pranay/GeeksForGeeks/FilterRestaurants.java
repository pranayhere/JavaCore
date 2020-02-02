package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

class Restaurent {
	int id;
	int rating;
	int veganFriendly;
	int price;
	int distance;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Restaurent)) return false;
		Restaurent that = (Restaurent) o;
		return veganFriendly >= that.veganFriendly &&
				price <= that.price &&
				distance <= that.distance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(veganFriendly, price, distance);
	}

	@Override
	public String toString() {
		return "Restaurent{" +
				"id=" + id +
				", rating=" + rating +
				", veganFriendly=" + veganFriendly +
				", price=" + price +
				", distance=" + distance +
				'}';
	}
}

public class FilterRestaurants {
	public static void main(String[] args) {
		int[][] restaurants = {{1,4,1,40,10},{2,8,0,50,5},{3,8,1,30,4},{4,10,0,10,3},{5,1,1,15,1}};
		//		int[][] restaurants = {{1,4,1,40,10},{2,8,0,50,5},{3,8,1,30,4},{4,10,0,10,3},{5,1,1,15,1}};
		int veganFriendly = 0, maxPrice = 50, maxDistance = 10;
		List<Integer> ans = filterRestaurants(restaurants, veganFriendly, maxPrice, maxDistance);
		System.out.println(ans);
	}

	private static List<Integer> filterRestaurants(int[][] res, int vf, int mp, int md) {
		List<Restaurent> list = new ArrayList<>();
		for (int i = 0; i<res.length; i++) {
			Restaurent r = new Restaurent();
			r.id = res[i][0];
			r.rating = res[i][1];
			r.veganFriendly = res[i][2];
			r.price = res[i][3];
			r.distance = res[i][4];

			list.add(r);
		}

		Restaurent criteria = new Restaurent();
		criteria.veganFriendly = vf;
		criteria.price = mp;
		criteria.distance = md;

		List<Restaurent> filtered = new ArrayList<>();
		for (Restaurent rest: list) {
			if (rest.equals(criteria)) {
				filtered.add(rest);
			}
		}

		Collections.sort(filtered, new Comparator<Restaurent>() {
			@Override
			public int compare(Restaurent o1, Restaurent o2) {
				int val1 = Integer.compare(o2.rating, o1.rating);
				if (val1 == 0) {
					return Integer.compare(o2.id, o1.id);
				} else {
					return val1;
				}

			}
		});

		System.out.println(filtered);
		List<Integer> ans = new ArrayList<>();
		for (Restaurent restaurent: filtered) {
			ans.add(restaurent.id);
		}

		return ans;
	}
}
