package com.pranay.testdome;

import java.util.HashMap;
import java.util.Map;

public class Song {
    private String name;
    private Song nextSong;

    public Song(String name) {
        this.name = name;
    }
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Song getNextSong() {
		return nextSong;
	}

	public void setNextSong(Song nextSong) {
        this.nextSong = nextSong;
    }

    public boolean isRepeatingPlaylist() {
    	Map<String, Integer> hm = new HashMap<String, Integer>();
    	Song currentSong = this;
    	while(true) {
	    	if (hm.containsKey(currentSong.getName()))
	    		return true;
	    	else {
	    		hm.put(currentSong.getName(), 1);
	    		currentSong = currentSong.getNextSong();
	    		if (currentSong == null)
	    			return false;
	    	}
	    }
    }

    public static void main(String[] args) {
        Song first = new Song("Hello");
        Song second = new Song("Eye of the tiger");

        first.setNextSong(second);
        second.setNextSong(first);

        System.out.println(first.isRepeatingPlaylist());
    }
}