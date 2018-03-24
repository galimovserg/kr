import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestMaterial {

	@Test
	public void test() {
		//������������� ���������, �������
		/*
		 * ��� ������� � ����� �� ���� ID ��������,
		 * ������� � ��������� ����� ��� �����.
		 * */
		int id=0;
		//������������ ���������, �������
		String name="�����(��������)";
		//��� ������
		/*
		 * ���� �������� ������ ������� � ��,
		 * � ����� ������ �� ������.
		 * ��������� ����������������� �������
		 * 
		 * */
		String classname="������";
		//���������� �����������
		/*
		 * ����� ������� ���������,
		 * ��� �� ����� ��������� ����� ��� �����
		 * 
		 * */
		int count=1;
		//������� ��������� ���������, �������
		String sx="width*height*lenght*10+50";
		//������� ��������
		Material desk=new Material(id, name, classname, new ArrayList<Parametr>(), sx,count);
		//��������� ��������� � �� �������� �� ���������
		/*
		 * width, length, height - ����� ����������, �������
		 * ������������ � �������, ����������� ����� ����
		 * ������ ��������� � ������� ������� ��� �� ���� ������.
		 * 
		 * ������(��), �����(�), �������(��) - �������� ���������,
		 * ������� ����� ����������� � �������
		 * 
		 * TypeName.floatType - ��� ��� ������ ���������,
		 * ���� � ������ ����,�� ����� ��������� �������� � ������ TypeName
		 * 
		 * */
		desk.addParametr(new Parametr("������(��)", "width", TypeName.floatType, "15"));
		desk.addParametr(new Parametr("�����(�)", "lenght", TypeName.floatType, "2.5"));
		desk.addParametr(new Parametr("�������(��)", "height", TypeName.floatType, "2"));
		//�������� �������������� ���������
		String res=desk.result();
		System.out.println("������ 1: "+res+" ���.");
		
		
		id=1;
		name="�����(�������)";
		classname="������";
		count=2;
		sx="width*height*lenght*10+50";
		desk=new Material(id, name, classname, new ArrayList<Parametr>(), sx,count);
		desk.addParametr(new Parametr("������(��)", "width", TypeName.floatType, "15"));
		desk.addParametr(new Parametr("�����(�)", "lenght", TypeName.floatType, "9"));
		desk.addParametr(new Parametr("�������(��)", "height", TypeName.floatType, "2"));
		desk.setValues(new String[]{"15","2","1"});
		res=desk.result();
		System.out.println("������ 2: "+res+" ���.");
		//������� ���������
		desk.setStore();
		res=desk.result();
		System.out.println("������ 3: "+res+" ���.");
		
		
		id=2;
		name="�����(EROS_RS286)";
		classname="�����-������";
		count=10;
		sx="stoimost";
		desk=new Material(id, name, classname, new ArrayList<Parametr>(), sx,count);
		desk.addParametr(new Parametr("���������", "stoimost", TypeName.floatType, "303.16"));
		//desk.setValues(new String[]{"300"});
		res=desk.result();
		System.out.println("������ 4: "+res+" ���.");
	}

}
