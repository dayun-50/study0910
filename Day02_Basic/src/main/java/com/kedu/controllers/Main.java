package com.kedu.controllers;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.kedu.beans.SamsungTv;
import com.kedu.beans.Tv;

public class Main {
	public static void main(String[] args) {
		
//		SamsungTv tv = new SamsungTv();
//		tv.powerOn();
//		tv.soundUp();
		
//		Tv tv = TvFactory.getInstance(args[0]);
//		tv.powerOn();
//		tv.volumeUp();
		
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("ctx.xml");
		
		Tv tv = ctx.getBean(Tv.class); //Tv를 상속받은 SamsungTv를 리턴시켜준다.
//		System.out.println(((SamsungTv)tv).getBrand());
//		System.out.println(((SamsungTv)tv).getPrice());

//		ctx.getBean(Tv.class);
//		ctx.getBean(Tv.class);
//		ctx.getBean(Tv.class);
//		ctx.getBean(Tv.class);
		//일캐해도 애초에 스프링은 디폴트가 싱글턴이라서 한번만 생성되고 실행됨 ㅇㅇ
		
		tv.volumeUp();
		
	}
}
