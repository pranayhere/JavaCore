package com.pranay.pubMatic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class pubMatic {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Emp1> list = new ArrayList<Emp1>();
		List<Emp1> subgroup = new ArrayList<Emp1>();

		for(int i=0; i<163; i++) {
			Emp1 e = new Emp1();

			String name, city, industry, Descipline, experience;
			String line = br.readLine();
			String[] arr = line.split(",");

			name = arr[1];
			city = arr[2];
			industry = arr[3];
			Descipline = arr[4];
			experience = arr[5];

			e.setName(name);
			e.setCity(city);
			e.setIndustry(industry);
			e.setExperience(experience);
			e.setDescipline(Descipline);

			list.add(e);
		}

		ListIterator<Emp1> aItr = list.listIterator();
		for(int i = 0; i < list.size(); i++) {
			Emp1 e1 = list.get(i);
			if(e1.getIsUsed()==1)
				continue;
			e1.setIsUsed(1);
			subgroup.add(e1);
			for(int j = 0; j < list.size(); j++) {
				Emp1 e2 = list.get(j);
				if(e2.getIsUsed()==1)
					continue;
				if(e1.getCity().equals(e2.getCity())) {
					if(!containsDescipline(subgroup, e2.getDescipline())) {
						if(!containsExperience(subgroup, e2.getExperience())) {
							subgroup.add(e2);
							e2.setIsUsed(1);
						}
					}
				}
				if(subgroup.size() >= 4 ) {
					System.out.println("subgroup is : ");
					for(Emp1 e:subgroup)
						System.out.println(e.toString());
					subgroup.clear();
					break;
				}
			}
		}
	}
	public static boolean containsDescipline(Collection<Emp1> c, String descipline) {
		for(Emp1 o : c) {
			if(o != null && o.getDescipline().equals(descipline)) {
				return true;
			}
		}
		return false;
	}

	public static boolean containsExperience(Collection<Emp1> c, String experience) {
		for(Emp1 o : c) {
			if(o != null && o.getExperience().equals(experience)) {
				return true;
			}
		}
		return false;
	}
}