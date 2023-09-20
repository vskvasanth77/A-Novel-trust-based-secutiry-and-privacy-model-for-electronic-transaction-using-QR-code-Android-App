package com.example.smartbus;

import java.io.IOException;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

public class Callservice {

	private static String NAMESPACE="http://Reg/";
	private static String URL="http://192.168.43.73:8080/Reg_Service/Registration?WSDL";

public static String registerService(String username, String password,String email,String phone_number, String method) {
	// TODO Auto-generated method stub
	String restex=null;
	SoapObject soap=new SoapObject(NAMESPACE, method);
	soap.addProperty("user_name",username);
	soap.addProperty("password",password);
	soap.addProperty("email",email);
	soap.addProperty("phone_number",phone_number);
	SoapSerializationEnvelope envelope=new SoapSerializationEnvelope(SoapEnvelope.VER11);
	envelope.setOutputSoapObject(soap);
	HttpTransportSE http=new HttpTransportSE(URL);
	try {
		http.call(NAMESPACE+method, envelope);
		SoapPrimitive primitive =(SoapPrimitive) envelope.getResponse();
		restex=primitive.toString();
		
	} catch (IOException e) {
		e.printStackTrace();
		return "error";
		
	} catch (XmlPullParserException e) {
		e.printStackTrace();
		return "error";
		
	}
	
	return restex;

}

public static String BankDetailsService(String name, String accountno,String cvv,String expirydate, String method) {
	// TODO Auto-generated method stub
	String restex=null;
	SoapObject soap=new SoapObject(NAMESPACE, method);
	soap.addProperty("name",name);
	soap.addProperty("accountno",accountno);
	soap.addProperty("cvv",cvv);
	soap.addProperty("expirydate",expirydate);
	SoapSerializationEnvelope envelope=new SoapSerializationEnvelope(SoapEnvelope.VER11);
	envelope.setOutputSoapObject(soap);
	HttpTransportSE http=new HttpTransportSE(URL);
	try {
		http.call(NAMESPACE+method, envelope);
		SoapPrimitive primitive =(SoapPrimitive) envelope.getResponse();
		restex=primitive.toString();
		
	} catch (IOException e) {
		e.printStackTrace();
		return "error";
		
	} catch (XmlPullParserException e) {
		e.printStackTrace();
		return "error";
		
	}
	
	return restex;

}
public static String Recharge(String uname, String cvv,String reamnt, String method) {
	// TODO Auto-generated method stub
	String restex=null;
	SoapObject soap=new SoapObject(NAMESPACE, method);
	soap.addProperty("name",uname);
	//soap.addProperty("accountno",accountno);
	soap.addProperty("cvv",cvv);
	soap.addProperty("reamnt",reamnt);
	SoapSerializationEnvelope envelope=new SoapSerializationEnvelope(SoapEnvelope.VER11);
	envelope.setOutputSoapObject(soap);
	HttpTransportSE http=new HttpTransportSE(URL);
	try {
		http.call(NAMESPACE+method, envelope);
		SoapPrimitive primitive =(SoapPrimitive) envelope.getResponse();
		restex=primitive.toString();
		
	} catch (IOException e) {
		e.printStackTrace();
		return "error";
		
	} catch (XmlPullParserException e) {
		e.printStackTrace();
		return "error";
		
	}
	
	return restex;

}



public static String loginService(String username, String password,String method) {
	// TODO Auto-generated method stub
	String restex=null;
	SoapObject soap=new SoapObject(NAMESPACE, method);
	soap.addProperty("user_name",username);
	soap.addProperty("password",password);
	SoapSerializationEnvelope envelope=new SoapSerializationEnvelope(SoapEnvelope.VER11);
	envelope.setOutputSoapObject(soap);
	HttpTransportSE http=new HttpTransportSE(URL);
	try {
		http.call(NAMESPACE+method, envelope);
		SoapPrimitive primitive =(SoapPrimitive) envelope.getResponse();
		restex=primitive.toString();
		
	} catch (IOException e) {
		e.printStackTrace();
		return "error";
		
	} catch (XmlPullParserException e) {
		e.printStackTrace();
		return "error";
		
	}
	
	return restex;

}


public static String payService(String s1, String s2,String method) {
	// TODO Auto-generated method stub
	String restex=null;
	SoapObject soap=new SoapObject(NAMESPACE, method);
	soap.addProperty("username",s1);
	soap.addProperty("cvv",s2);
	SoapSerializationEnvelope envelope=new SoapSerializationEnvelope(SoapEnvelope.VER11);
	envelope.setOutputSoapObject(soap);
	HttpTransportSE http=new HttpTransportSE(URL);
	try {
		http.call(NAMESPACE+method, envelope);
		SoapPrimitive primitive =(SoapPrimitive) envelope.getResponse();
		restex=primitive.toString();
		
	} catch (IOException e) {
		e.printStackTrace();
		return "error";
		
	} catch (XmlPullParserException e) {
		e.printStackTrace();
		return "error";
		
	}
	
	return restex;

}

public static String payUpdate(String cvv, String amountresult,String method) {
	// TODO Auto-generated method stub
	String restex=null;
	SoapObject soap=new SoapObject(NAMESPACE, method);
	soap.addProperty("cvv",cvv);
	soap.addProperty("amount",amountresult);
	SoapSerializationEnvelope envelope=new SoapSerializationEnvelope(SoapEnvelope.VER11);
	envelope.setOutputSoapObject(soap);
	HttpTransportSE http=new HttpTransportSE(URL);
	try {
		http.call(NAMESPACE+method, envelope);
		SoapPrimitive primitive =(SoapPrimitive) envelope.getResponse();
		restex=primitive.toString();
		
	} catch (IOException e) {
		e.printStackTrace();
		return "error";
		
	} catch (XmlPullParserException e) {
		e.printStackTrace();
		return "error";
		
	}
	
	return restex;

}



public static String BuslistService(String timee, String bus,String method) {
	// TODO Auto-generated method stub
	String restex=null;
	SoapObject soap=new SoapObject(NAMESPACE, method);
	soap.addProperty("timee",timee);
	soap.addProperty("bus",bus);
	SoapSerializationEnvelope envelope=new SoapSerializationEnvelope(SoapEnvelope.VER11);
	envelope.setOutputSoapObject(soap);
	HttpTransportSE http=new HttpTransportSE(URL);
	try {
		http.call(NAMESPACE+method, envelope);
		SoapPrimitive primitive =(SoapPrimitive) envelope.getResponse();
		restex=primitive.toString();
		
	} catch (IOException e) {
		e.printStackTrace();
		return "error";
		
	} catch (XmlPullParserException e) {
		e.printStackTrace();
		return "error";
		
	}
	
	return restex;

}

public static String TicketamountService(String from, String to,String method) {
	// TODO Auto-generated method stub
	String restex=null;
	SoapObject soap=new SoapObject(NAMESPACE, method);
	soap.addProperty("from",from);
	soap.addProperty("to",to);
	SoapSerializationEnvelope envelope=new SoapSerializationEnvelope(SoapEnvelope.VER11);
	envelope.setOutputSoapObject(soap);
	HttpTransportSE http=new HttpTransportSE(URL);
	try {
		http.call(NAMESPACE+method, envelope);
		SoapPrimitive primitive =(SoapPrimitive) envelope.getResponse();
		restex=primitive.toString();
		
	} catch (IOException e) {
		e.printStackTrace();
		return "error";
		
	} catch (XmlPullParserException e) {
		e.printStackTrace();
		return "error";
		
	}
	
	return restex;

}
public static String getDeviceList1(String from,String to,String method) {
	String restex=null;
	SoapObject soap=new SoapObject(NAMESPACE, method);
	soap.addProperty("from",from);
	soap.addProperty("to",to);
//	soap.addProperty("password",password);
	SoapSerializationEnvelope envelope=new SoapSerializationEnvelope(SoapEnvelope.VER11);
	envelope.setOutputSoapObject(soap);
	HttpTransportSE http=new HttpTransportSE(URL);
	try {
		http.call(NAMESPACE+method, envelope);
		SoapPrimitive primitive =(SoapPrimitive) envelope.getResponse();
		restex=primitive.toString();
		
	} catch (IOException e) {
		e.printStackTrace();
		return "error";
		
	} catch (XmlPullParserException e) {
		e.printStackTrace();
		return "error";
		
	}
	
	return restex;

}
public static String bookService(String qrvalue, String username,String busno,String from,String to,String time,String cost,String payment,String cvv,String method) {
	// TODO Auto-generated method stub
	String restex=null;
	SoapObject soap=new SoapObject(NAMESPACE, method);
	soap.addProperty("qrvalue",qrvalue);
	soap.addProperty("username",username);
	soap.addProperty("busno",busno);
	soap.addProperty("from",from);
	soap.addProperty("to",to);
	soap.addProperty("time",time);
	soap.addProperty("cost",cost);
	soap.addProperty("payment",payment);
	soap.addProperty("cvv",cvv);
	SoapSerializationEnvelope envelope=new SoapSerializationEnvelope(SoapEnvelope.VER11);
	envelope.setOutputSoapObject(soap);
	HttpTransportSE http=new HttpTransportSE(URL);
	try {
		http.call(NAMESPACE+method, envelope);
		SoapPrimitive primitive =(SoapPrimitive) envelope.getResponse();
		restex=primitive.toString();
		
	} catch (IOException e) {
		e.printStackTrace();
		return "error";
		
	} catch (XmlPullParserException e) {
		e.printStackTrace();
		return "error";
		
	}
	
	return restex;

}

}

