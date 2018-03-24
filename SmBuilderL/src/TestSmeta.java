import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestSmeta {

	@Test
	public void test() {
		Smeta newsm=new Smeta();
		//������� ��������
		Material m=new Material(3,"�����(EROS_RS286)" ,"�����-������" , new ArrayList<Parametr>(), "stoimost",10);
		m.addParametr(new Parametr("���������", "stoimost", TypeName.floatType, "303.16"));
		//�������� ��� � �����
		newsm.addMaterial(m);
		System.out.println("������ 1:�������� 1 "+m.result());
		
		//������� ����� ��������
		m=new Material(2,"�����(����)" ,"�����" , new ArrayList<Parametr>(), "width*height*lenght*10+50",1);
		m.addParametr(new Parametr("������(��)", "width", TypeName.floatType, "15"));
		m.addParametr(new Parametr("�����(�)", "lenght", TypeName.floatType, "2.5"));
		m.addParametr(new Parametr("�������(��)", "height", TypeName.floatType, "2"));
		m.setValues(new String[]{"10","5","2"});
		//�������� ��� � �����
		newsm.addMaterial(m);
		System.out.println("������ 1:�������� 2 "+m.result());
		String res=newsm.result();
		System.out.println("������ 1:���� "+res);
	}

}
