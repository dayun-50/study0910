package com.kedu.controllers;

import com.kedu.beans.SamsungTv;
import com.kedu.beans.Tv;
import com.kedu.factories.TvFactory;

public class Main {
	public static void main(String[] args) {
		
//		SamsungTv tv = new SamsungTv();
//		tv.powerOn();
//		tv.soundUp();
		
		Tv tv = TvFactory.getInstance(args[0]);
		tv.powerOn();
		tv.volumeUp();
		
		
		
	}
}
