import org.junit.Test;

public class TestFurmula {

	
	@Test
	public void test() {
		//����� ����������
		String pnames[]={"k","width","height"};
		//�� ��������
		String pvalues[]={"20","10","10"};
		//���������
		String sx="if(k>10,width*height,width+height)+2^2";
		//������� �������
		Formula f=new Formula(sx,pnames);
		//������� ���������
		System.out.println("������ 1: "+f.result(pvalues));
		
		//����� ����������
		pnames= new String[]{"radius","length","stoimost","skidka"};
		//�� ��������
		pvalues=new String[]{"5","100","0.80","15"};
		//���������
		sx="radius*length*Pi*stoimost*(100-skidka)/100";
		//������� �������
		f=new Formula(sx,pnames);
		//������� ���������
		System.out.println("������ 2: "+f.result(pvalues));
		
		//����� ����������
		pnames= new String[]{"stoimost","skidka"};
		//�� ��������
		pvalues=new String[]{"100","10"};
		//���������
		sx="stoimost*(100-skidka)/100";
		//������� �������
		f=new Formula(sx,pnames);
		//������� ���������
		System.out.println("������ 3: "+f.result(pvalues));
		
		//����� ����������
		pnames= new String[]{"x"};
		//�� ��������
		pvalues=new String[]{"13"};
		//���������
		sx="if(x<12,Sin(0.5)+10,Cos(0.5)-10)";
		//������� �������
		f=new Formula(sx,pnames);
		//������� ���������
		System.out.println("������ 4: "+f.result(pvalues));
		
		//����� ����������
		pnames= new String[]{};
		//�� ��������
		pvalues=new String[]{};
		//���������
		sx="12345.4321";
		//������� �������
		f=new Formula(sx,pnames);
		//������� ���������
		System.out.println("������ 5: "+f.result(pvalues));
		
		//����� ����������
		pnames= new String[]{"a","b"};
		//�� ��������
		pvalues=new String[]{"67.10","0"};
		//���������
		sx="a/b+1";
		//������� �������
		f=new Formula(sx,pnames);
		//������� ���������
		System.out.println("������ 6: "+f.result(pvalues));
		
		//����� ����������
		pnames= new String[]{};
		//�� ��������
		pvalues=new String[]{};
		//���������
		sx="-(-(-(-(-6+4))))/2";
		//������� �������
		f=new Formula(sx,pnames);
		//������� ���������
		System.out.println("������ 7: "+f.result(pvalues));
	}

}
