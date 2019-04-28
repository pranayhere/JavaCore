package com.pranay.GeeksForGeeks;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

public class Friend {
	private static List<String> visited = new ArrayList<>();
    private Collection<Friend> friends;
    private String email;

    public Friend(String email) {
        this.email = email;
        this.friends = new ArrayList<Friend>();
    }

    public String getEmail() {
        return email;
    }

    public Collection<Friend> getFriends() {
        return friends;
    }

    public void addFriendship(Friend friend) {
        friends.add(friend);
        friend.getFriends().add(this);
    }             

    public boolean canBeConnected(Friend friend) {
    	System.out.println("this : " + this.getEmail());	
    	System.out.println("friend : "+ friend.getEmail());
    	
    	if (visited.contains(this.getEmail())) {
    		System.out.println("Here to return");
    		return false;
    	}
    	
    	visited.add(this.getEmail());

    	if (this.getFriends() == null) {
    		System.out.println("No friends return");
    		return false;
    	}
    	if (this.getEmail() == friend.getEmail()) {
    		System.out.println("Yeyyy");
    		return true;
    	}
    	Collection<Friend> friends= this.getFriends();
    	friends.forEach(f -> System.out.print(" - " + f.getEmail() + " "));
    	System.out.println();
    	
    	for(Friend f : friends) {
    		System.out.println("here : " +f.getEmail());
    		boolean res = f.canBeConnected(friend);
    		System.out.println("Res ::: "+res);
    		if (res);
    			return true;
    	}
    	return false;
    }

    public static void main(String[] args) {
        Friend a = new Friend("A");
        Friend b = new Friend("B");
        Friend c = new Friend("C");

        a.addFriendship(b);
        b.addFriendship(c);
        System.out.println(b.canBeConnected(c));
    }
}