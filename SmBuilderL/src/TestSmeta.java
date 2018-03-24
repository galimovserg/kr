import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestSmeta {

	@Test
	public void test() {
		Smeta newsm=new Smeta();
		//создали материал
		Material m=new Material(3,"ручка(EROS_RS286)" ,"ручка-скобка" , new ArrayList<Parametr>(), "stoimost",10);
		m.addParametr(new Parametr("Стоимость", "stoimost", TypeName.floatType, "303.16"));
		//добавили его в смету
		newsm.addMaterial(m);
		System.out.println("Пример 1:материал 1 "+m.result());
		
		//создали новый материал
		m=new Material(2,"доска(брус)" ,"доска" , new ArrayList<Parametr>(), "width*height*lenght*10+50",1);
		m.addParametr(new Parametr("ширина(см)", "width", TypeName.floatType, "15"));
		m.addParametr(new Parametr("длина(м)", "lenght", TypeName.floatType, "2.5"));
		m.addParametr(new Parametr("толщина(см)", "height", TypeName.floatType, "2"));
		m.setValues(new String[]{"10","5","2"});
		//добавили его в смету
		newsm.addMaterial(m);
		System.out.println("Пример 1:материал 2 "+m.result());
		String res=newsm.result();
		System.out.println("Пример 1:итог "+res);
	}

}
