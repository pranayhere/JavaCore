package com.pranay.MakeMutableObjectAsImmuable;

public class MakeMutableObjectAsImmuable {
    public static void main(String[] args) {
          Address1 ad = new Address1("33/1", "MKR", 560054);
          User1 usr = new User1(99, "Navneet", 99999, ad);
          System.out.println(usr);
          System.out.println("\n** Modifying AD ref **");
          ad.aid = "44/2";
          ad.street = "BTM";
          ad.pin = 560087;
          System.out.println(usr);
          System.out.println("\n** Accessing Address and Modifying **");
          Address1 ref = usr.getAdd();
          ref.aid = "55/3";
          ref.street = "MHA";
          ref.pin = 56001;
          System.out.println(usr);
    }
}

final class User1{
    private final int uid;
    private final String name;
    private final long phone;
    private final Address1 add;
    
    public User1(int uid, String name, long phone, Address1 add) {
          this.uid = uid;
          this.name = name;
          this.phone = phone;
          this.add = new Address1(add.aid,add.street,add.pin);
    }
    
    public int getUid() {
          return uid;
    }

    public String getName() {
          return name;
    }

    public long getPhone() {
          return phone;
    }
    
    public Address1 getAdd() {
          return  new Address1(add.aid,add.street,add.pin);
    }

    @Override
    public String toString() {
          return "User1 [uid=" + uid + ", name=" + name + ", phone=" + phone+ ", add=" + add + "]";
    }
}

class Address1{
    String aid;
    int pin;
    String street;
    public Address1(String aid, String street, int pin ) {
          this.aid = aid;
          this.pin = pin;
          this.street = street;
    }
    @Override
    public String toString() {
          return "Address1 [aid=" + aid + ", pin=" + pin + ", street=" + street+ "]";
    }
}

