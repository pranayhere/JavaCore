package com.pranay.GeeksForGeeks;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Item {
	String name;
	double size;
	
	public Item(String name, double size) {
		this.name = name;
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public double getSize() {
		return size;
	}
}

public class StreamsDemo {

	public static void main(String[] args) {
        //3 apple, 2 banana, others 1
        List<Item> items = Arrays.asList(
        		new Item("packetbeat-201 " ,   2.3),
        		new Item("pe-queue-jobs- " ,   4.2),
        		new Item("pe-queue-jobs- " ,     8),
        		new Item("pe-queue-queue " ,   5.1),
        		new Item("packetbeat-6.3 " , 116.3),
        		new Item("pe-queue-queue " ,   7.7),
        		new Item("pe-logstash-ba " ,     2),
        		new Item("pe-queue-jobs- " ,   2.5),
        		new Item("pe-queue-queue " ,  10.6),
        		new Item("packetbeat-6.3 " , 109.2),
        		new Item("pe-queue-queue " ,   9.1),
        		new Item("packetbeat-6.3 " , 115.3),
        		new Item("pe-mod-securit " ,  48.9),
        		new Item("pe-queue-queue " ,   9.2),
        		new Item("pe-queue-jobs- " ,     6),
        		new Item("packetbeat-201 " ,   2.3),
        		new Item("pe-queue-queue " ,   9.5),
        		new Item("pe-queue-queue " ,     7),
        		new Item("pe-queue-queue " ,   7.4),
        		new Item("pe-queue-queue " ,   9.4),
        		new Item("pe-queue-jobs- " ,   6.5),
        		new Item("packetbeat-6.3 " , 101.5),
        		new Item("pe-logstash-ba " ,  25.1),
        		new Item("pe-queue-queue " ,   4.2),
        		new Item("pe-logstash-ba " ,  36.3),
        		new Item("packetbeat-6.3 " , 109.3),
        		new Item("pe-queue-jobs- " ,   5.6),
        		new Item("packetbeat-6.3 " , 114.6),
        		new Item("pe-queue-jobs- " ,   6.6),
        		new Item("pe-queue-jobs- " ,   5.4),
        		new Item("pe-queue-jobs- " ,   6.2),
        		new Item("pe-queue-jobs- " ,   6.1),
        		new Item("packetbeat-6.3 " ,  40.2),
        		new Item("pe-queue-jobs- " ,   5.8),
        		new Item("pe-queue-jobs- " ,   6.5),
        		new Item("pe-queue-queue " ,   8.8),
        		new Item("packetbeat-201 " ,   1.8),
        		new Item("pe-queue-queue " ,   7.6),
        		new Item("pe-queue-jobs- " ,   5.7),
        		new Item("pe-queue-queue " ,   8.1),
        		new Item("packetbeat-201 " ,   2.3),
        		new Item("pe-queue-jobs- " ,   3.1),
        		new Item("packetbeat-6.3 " ,  40.5),
        		new Item("packetbeat-201 " ,   2.3)

        );

        Map<String, Double> sum = items.stream().collect(
                Collectors.groupingBy(Item::getName, Collectors.summingDouble(Item::getSize)));

        System.out.println(sum);

	}

}
