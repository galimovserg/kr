import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestMaterial {

	@Test
	public void test() {
		//идентификатор материала, объекта
		/*
		 * Как правило в любых БД есть ID элеменов,
		 * почитай в интернете зачем они нужны.
		 * */
		int id=0;
		//наименование материала, объекта
		String name="Доска(сосновая)";
		//имя класса
		/*
		 * этот параметр больше полезен в БД,
		 * в нашем случае на складе.
		 * позволяет структуризировать каталог
		 * 
		 * */
		String classname="дерево";
		//количество экземпляров
		/*
		 * очень удобная штуковина,
		 * тут не нужно объяснять зачем она нужна
		 * 
		 * */
		int count=1;
		//формула стоимости материала, объекта
		String sx="width*height*lenght*10+50";
		//создаем материал
		Material desk=new Material(id, name, classname, new ArrayList<Parametr>(), sx,count);
		//добавляем параметры и их значения по умолчанию
		/*
		 * width, length, height - имена параметров, которые
		 * используются в формуле, естественно могут быть
		 * другие параметры с другими именами или не быть вообще.
		 * 
		 * ширина(см), длина(м), толщина(см) - название параметра,
		 * которое будет отображатся в таблице
		 * 
		 * TypeName.floatType - это тип данных параметра,
		 * есть и другие типы,по типам подробнее посмотри в классе TypeName
		 * 
		 * */
		desk.addParametr(new Parametr("ширина(см)", "width", TypeName.floatType, "15"));
		desk.addParametr(new Parametr("длина(м)", "lenght", TypeName.floatType, "2.5"));
		desk.addParametr(new Parametr("толщина(см)", "height", TypeName.floatType, "2"));
		//вызываем вычислительную процедуру
		String res=desk.result();
		System.out.println("Пример 1: "+res+" руб.");
		
		
		id=1;
		name="Доска(дубовая)";
		classname="дерево";
		count=2;
		sx="width*height*lenght*10+50";
		desk=new Material(id, name, classname, new ArrayList<Parametr>(), sx,count);
		desk.addParametr(new Parametr("ширина(см)", "width", TypeName.floatType, "15"));
		desk.addParametr(new Parametr("длина(м)", "lenght", TypeName.floatType, "9"));
		desk.addParametr(new Parametr("толщина(см)", "height", TypeName.floatType, "2"));
		desk.setValues(new String[]{"15","2","1"});
		res=desk.result();
		System.out.println("Пример 2: "+res+" руб.");
		//сбросим параметры
		desk.setStore();
		res=desk.result();
		System.out.println("Пример 3: "+res+" руб.");
		
		
		id=2;
		name="ручка(EROS_RS286)";
		classname="ручка-скобка";
		count=10;
		sx="stoimost";
		desk=new Material(id, name, classname, new ArrayList<Parametr>(), sx,count);
		desk.addParametr(new Parametr("Стоимость", "stoimost", TypeName.floatType, "303.16"));
		//desk.setValues(new String[]{"300"});
		res=desk.result();
		System.out.println("Пример 4: "+res+" руб.");
	}

}
