package co.company.spring;

import co.company.spring.controller.Member;

public class LombokTest {
	public static void main(String[] args) {
		Member member = 
				Member.builder().id("").name("").build();
		// 그럼 생성자 여러개쓸때는 member = Member.builder()~~ 써야하는거야 Member member = Member.builder~ 써야하는거야
		
	}
}
