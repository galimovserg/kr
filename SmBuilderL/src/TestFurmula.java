import org.junit.Test;

public class TestFurmula {

	
	@Test
	public void test() {
		//имена параметров
		String pnames[]={"k","width","height"};
		//их значения
		String pvalues[]={"20","10","10"};
		//выражение
		String sx="if(k>10,width*height,width+height)+2^2";
		//Создаем формулу
		Formula f=new Formula(sx,pnames);
		//выводим результат
		System.out.println("Пример 1: "+f.result(pvalues));
		
		//имена параметров
		pnames= new String[]{"radius","length","stoimost","skidka"};
		//их значения
		pvalues=new String[]{"5","100","0.80","15"};
		//выражение
		sx="radius*length*Pi*stoimost*(100-skidka)/100";
		//Создаем формулу
		f=new Formula(sx,pnames);
		//выводим результат
		System.out.println("Пример 2: "+f.result(pvalues));
		
		//имена параметров
		pnames= new String[]{"stoimost","skidka"};
		//их значения
		pvalues=new String[]{"100","10"};
		//выражение
		sx="stoimost*(100-skidka)/100";
		//Создаем формулу
		f=new Formula(sx,pnames);
		//выводим результат
		System.out.println("Пример 3: "+f.result(pvalues));
		
		//имена параметров
		pnames= new String[]{"x"};
		//их значения
		pvalues=new String[]{"13"};
		//выражение
		sx="if(x<12,Sin(0.5)+10,Cos(0.5)-10)";
		//Создаем формулу
		f=new Formula(sx,pnames);
		//выводим результат
		System.out.println("Пример 4: "+f.result(pvalues));
		
		//имена параметров
		pnames= new String[]{};
		//их значения
		pvalues=new String[]{};
		//выражение
		sx="12345.4321";
		//Создаем формулу
		f=new Formula(sx,pnames);
		//выводим результат
		System.out.println("Пример 5: "+f.result(pvalues));
		
		//имена параметров
		pnames= new String[]{"a","b"};
		//их значения
		pvalues=new String[]{"67.10","0"};
		//выражение
		sx="a/b+1";
		//Создаем формулу
		f=new Formula(sx,pnames);
		//выводим результат
		System.out.println("Пример 6: "+f.result(pvalues));
		
		//имена параметров
		pnames= new String[]{};
		//их значения
		pvalues=new String[]{};
		//выражение
		sx="-(-(-(-(-6+4))))/2";
		//Создаем формулу
		f=new Formula(sx,pnames);
		//выводим результат
		System.out.println("Пример 7: "+f.result(pvalues));
	}

}
