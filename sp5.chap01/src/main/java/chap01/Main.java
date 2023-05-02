package chap01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(AppContext.class);
		Greater g = ctx.getBean("greater",Greater.class);
		String msg = g.great("스프링");
		System.out.println(msg);
		ctx.close();
	}

}
