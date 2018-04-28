package com.jalja.db;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test {
	public static void main(String[] args) throws UnknownHostException {
		String addr = InetAddress.getLocalHost().getHostAddress();//获得本机IP
		System.out.println(addr);
	}
}
