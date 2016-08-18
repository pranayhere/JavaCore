package com.pranay.MutableObjectInImmuableClass;

public class MutableObjectInImmuableClass {
    public static void main(String[] args) {
          Address ad = new Address("33/1", "MKR", 560054);
          User usr = new User(99, "Navneet", 99999, ad);
          System.out.println(usr);
          System.out.println("\n** Modifying AD ref **");
          ad.aid = "44/2";
          ad.street = "BTM";
          ad.pin = 560087;
          System.out.println(usr);
          System.out.println("\n** Accessing Address and Modifying **");
          Address ref = usr.getAdd();
          ref.aid = "55/3";
          ref.street = "MHA";
          ref.pin = 56001;
          System.out.println(usr);
    }
}

final class User{
    private final int uid;
    private final String name;
    private final long phone;
    private final Address add;
    
    public User(int uid, String name, long phone, Address add) {
          this.uid = uid;
          this.name = name;
          this.phone = phone;
          this.add = add;
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
    public Address getAdd() {
          return add;
    }

    @Override
    public String toString() {
          return "User [uid=" + uid + ", name=" + name + ", phone=" + phone+ ", add=" + add + "]";
    }
}

class Address{
    String aid;
    int pin;
    String street;
    public Address(String aid, String street, int pin ) {
          this.aid = aid;
          this.pin = pin;
          this.street = street;
    }
    @Override
    public String toString() {
          return "Address [aid=" + aid + ", pin=" + pin + ", street=" + street+ "]";
    }
}
