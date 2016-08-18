package com.pranay.SerializationDemo;

import java.io.NotSerializableException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Emp implements Serializable {
	private static final long serialVersionUID = 1L;
	public String firstName;
	public String lastName;
}
class EmpChild extends Emp {
	private static final long serialVersionUID = 1L;
	public String middleName;

//	private void writeObject(ObjectOutputStream os) throws NotSerializableException {
//		throw new NotSerializableException("This class cannot be Serialized");
//	} 
}
