package com.intuit;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

public class GmailInbox {

	public static void main(String[] args) throws MessagingException, IOException {

		String digitCode = readGmail();
		System.out.println("6 Digits Code = " +digitCode );
	}
	
	public static String readGmail() throws MessagingException, IOException {

			String finalStr = null;
			Properties props = new Properties();
	        props.setProperty("mail.store.protocol", "imaps");
	        Session session = Session.getDefaultInstance(props, null);

	        Store store = session.getStore("imaps");
	        store.connect("smtp.gmail.com", "qbbssunset@gmail.com","1234Test");

	        Folder inbox = store.getFolder("inbox");
	        inbox.open(Folder.READ_ONLY);
	        int messageCount = inbox.getMessageCount();

	        System.out.println("Total Messages:- " + messageCount);

	        Message[] messages = inbox.getMessages();
	        int count = messages.length;
	        System.out.println("------------------------------");
	        for (int i = 0; i < count; i++) {
	           //System.out.println("Mail Subject:- " + messages[i].getSubject());
	           if(messages[i].getSubject().equals("Your Intuit Account")){
	        	   String body = (String) messages[i].getContent();
	               //System.out.println(body);
	               
	               String start = "<p style=\"font-size:18px;font-weight:bold;margin:12px 0px 0px 0px; padding: 0px 0px 0px 0px;\">";
	               String end = "<!-- seek more help -->";
	               int from = body.indexOf(start)+start.length();
	               int to = body.indexOf(end);	               
	               finalStr = body.substring(from, to).split("<")[0].trim();
	               break;
	           }
	        }
			return finalStr;
	    }
}
