import java.util.ArrayList;
public class Formula {
    /*
     * ��� ��������� �������,
     * ����� �� ����� ��������� ��������� �������,
     * ��������� ����������� ������� � ���������.
     * 
     * ���� �� ������������� ���������:
     * �������� ��������� � ��������� ������������ ��� ���������
     * ������ �������� ����������
     * � ������� ���������.
     * ��������� ������ ���������� � �������, � �� ����������� ��
     * ��������� ����������� �������, ���� ��� �������������.
     * ��� ������� �������� ����������:
     * x, width, x5, x55
     * � �.�.
     * 
     * ��������� �������� �� ���� �������� ����������,
     * ���������� ���������� ��������, ��� �� �������� ����������.
     * 
     * ������������� �������������� ��������� ��� �������� �������,
     * ������� ������� ����� ����� �������� ��������� �� ��������.
     * ��� ������� ������:
     * 	if(x>10,x+5,x-5)
     * ��� x>10 ������� ������ �������� ��������� x+5,
     * � ����� ������ x-5,
     * ��� ���� ����������� ������ ���� ���������.
     * 
     * ��� ��� ��������?
     * 
     * ��� ����� ������, ����� ����������� �� ������� �������
     * ���������� ��������� � ������� ����������� ������� ��� ������ �������.
     * 
     * */

        //����� �������� ������ ���������
        public char sx[];
        
        //� ���� ���� �������� �������� ���������
        public String listparamname[];//�����
        public String listparamvalue[];//��������
       
        
        //�������� �� ������
        /*
         * �������� ��� ������,
         * �������� ��� ������� �� ����
         * */
        private int errors;
        //��������� �� ������
        private  int i;
        //���������� ���������� ���������
        /*
         * ��� ���������� ����� ������� � ��������� �������,
         * �� ��������� ������ ���� ����� � ����������� �� ����������
         * �������� �������.
         * */
        private int blockedout=0;
        //����������� �������
        /*
         * ������ ���������, � ������ ����������, �������
         * ������������ � ���� ���������
         * */
        Formula(String sx, String listparamn[]){
        	this.sx=sx.toCharArray();
        	this.listparamname=listparamn;
        	
        }
        //��������� ���� ������ ��� ���
        boolean hadError(){
        	if(errors==0){
        		return false;
        	}else{
        		return true;
        	}
        }

        //��������� ���������
        //�������� �������� ����������, �� ������� ����������� ���������
        public  String result(String listparametrv[]){
            i=0;//��������� �������
            errors=0;//�������� ������
            listparamvalue=listparametrv;//������������� �������� ����������
            String rt=String.valueOf(ress());
            if (errors==0){return rt;}else {return "ERROR";}

        }
        private boolean isequals(int bindex,char s[],String substr){
            int ii=0;
            if (s.length>=bindex+substr.length()){
                for (ii=0;ii<substr.length();ii++){
                    if (s[bindex+ii]!=substr.toCharArray()[ii]){return false;}
                }}else {return false;}
            i+=substr.length()-1;
            return true;
        }
        
        //������� - ����������� �������, ����� ���������� �����
        private  double ress(){
            //�������� ��������, ����������� ��������� local1
            double itog=0;
            //����� ������� ����������� ��� ���������, ������� local2
            double local1=1;
            //����� ������� �����������
            double local2=0;
            //���������� �������
            double local3=0;
            //���������� ������� ������ �����
            double stepdrob=0.1;
            //true ���� ���� ������� ����� � local2 ����� false(���������� �� ���)
            boolean drob=false;
            //type1 ���������� ��� ������ ������� � local1 � local2(���������� ��������) ��������
            //��� ��������� (app,split ��������������)
            int app=1,split=2;
            int type=app;
            //���������� ������� ���������� ���������� � local2
            boolean stepen=false;
            

            //����� �� ���������� ��������� ���� �� �������� ��� �������, ��� �� �������� �� �����
            while (sx.length>i&&sx[i]!=')'&&sx[i]!=',') {
            	//��������� ������ ������ ������
                switch (sx[i]) {

                    //region standart
                    case '(': {
                        i++;
                        local2 = ress();
                        drob = false;
                        break;
                    }
                    case '+':case '-': {
                        if (stepen){
                            local2=Math.pow(local3,local2);
                            local3=0;
                            stepen=false;
                        }
                        drob = false;
                        if (type == app) {
                            itog = itog + local1 * local2;
                        } else {
                            if (Math.abs(local2)==0){errors=1;itog=0;}else {
                            itog = itog + local1 / local2;
                            }
                        }
                        if (sx[i]=='+'){local1 = 1;}else {local1 = -1;}
                        local2 = 0;
                        type=app;
                        break;
                    }

                    case '*':case '/':{
                        if (stepen){
                            local2=Math.pow(local3,local2);
                            local3=0;
                            stepen=false;
                        }
                        drob = false;

                            if (type == app) {
                                local1 = local1 * local2;
                            } else {
                            	if (Math.abs(local2)==0){
                            		errors=1;
                            		local1=0;
                            	}else {
                            		local1 = local1 / local2;
                            	}
                        }
                        if (sx[i]=='*'){type=app;}else{type=split;}
                        local2=0;
                        break;
                    }

                    case '^':{
                        drob=false;
                        if (stepen){
                            local2=Math.pow(local3,local2);

                            if (type == app) {
                                local1 = local1 * local2;
                            } else {
                                if (Math.abs(local2)==0){errors=1;local1 =0;}else{
                                local1 = local1 / local2;
                                }
                            }
                        }

                        stepen=true;
                        local3=local2;
                        local2=0;

                        break;
                    }
                    case '.': {
                        drob=true;
                        stepdrob=0.1;
                        break;
                    }
                    case '=':{
                        if (stepen){
                            local2=Math.pow(local3,local2);
                        }
                        if (type==app){
                            itog=itog+local1*local2;
                        }else { itog=itog+local1/local2;}

                        i++;
                        local2=ress();



                        if (local2==itog){return 1.;}else {return  0.;}

                    }
                    case '>':{
                        if (stepen){
                            local2=Math.pow(local3,local2);
                        }
                        if (type==app){
                            itog=itog+local1*local2;
                        }else { itog=itog+local1/local2;}

                        i++;
                        local2=ress();



                        if (local2<itog){return 1.;}else {return  0.;}

                    }
                    case '<':{
                        if (stepen){
                            local2=Math.pow(local3,local2);
                        }
                        if (type==app){
                            itog=itog+local1*local2;
                        }else { itog=itog+local1/local2;}

                        i++;
                        local2=ress();



                        if (local2>itog){return 1.;}else {return  0.;}

                    }

                    case '0':case '1':case '2':case '3':case '4':case '5':case '6':case '7':case '8':case '9':{

                        if (drob){
                            local2=local2+stepdrob*Double.parseDouble(sx[i]+"");
                            stepdrob*=0.1;
                        }else {local2=local2*10+Double.parseDouble(sx[i]+"");}
                        break;

                    }

                    //endregion
                    default:{

                        if (isequals(i,sx,"if(")){
                            i++;
                            local2=Math.signum(ress());
                            double ffg1,ffg2;

                            if (blockedout==0) {

                                if (local2 == 0) {
                                    i++;
                                    blockedout = 1;
                                    ress();
                                    blockedout = 0;
                                    i++;
                                    ffg2 = ress();
                                    local2 = ffg2;
                                } else {
                                    i++;
                                    ffg1 = ress();
                                    i++;
                                    blockedout = 1;
                                    ress();
                                    blockedout = 0;
                                    local2 = ffg1;
                                }
                            }else{
                                i++;
                                ress();
                                i++;
                                ress();
                            }





                        }else
                        if (isequals(i,sx,"Mod(")){
                            i++;
                            local2=Math.round(ress());
                            i++;
                            long lk=Math.round(ress());
                            local2=Math.round(local2)%lk;

                        }else
                        if (isequals(i,sx,"Round(")){
                            i++;
                            local2=Math.round(ress());

                        }else
                        if (isequals(i,sx,"Sign(")){
                            i++;
                            local2=Math.signum(ress());


                        }else
                        if (isequals(i,sx,"Random(")){
                            i++;
                            local2=Math.random()*ress();


                        }else
                        if (isequals(i,sx,"Abs(")){
                            i++;
                            local2=Math.abs(ress());

                        }else
                        if (isequals(i,sx,"Ln(")){
                            i++;
                            local2=Math.log(ress());

                        }else if (isequals(i,sx,"Exp(")){
                            i++;
                            local2=Math.exp(ress());

                        }else if (isequals(i,sx,"Pi")){

                            local2=Math.PI;
                        }else if (isequals(i,sx,"Sin(")){
                            i++;
                            local2=Math.sin(ress());

                        }else if (isequals(i,sx,"Cos(")){
                            i++;
                            local2=Math.cos(ress());

                        }else if (isequals(i,sx,"Tg(")){
                            i++;
                            local2=Math.tan(ress());

                        }if (isequals(i,sx,"cTg(")){
                            i++;
                            local2=1/Math.tan(ress());
                        }else{
                        	int lenmax=0;
                            int jk=0;
                            int j;
                            if (listparamname!=null){

                                for (j=0;j<listparamname.length;j++){
                                   if (listparamname[j]!="") {
                                      int k=i;
                                       if (isequals(i, sx, listparamname[j])) {
                                           if (listparamname[j].length() > lenmax) {
                                               lenmax = listparamname[j].length();
                                               jk = j;

                                           }

                                       }
                                       i=k;
                                   }

                                }
                                if (lenmax>0){
                                   
                                    local2=Double.valueOf(listparamvalue[jk]);
                                    i=i+listparamname[jk].length()-1;
                                 

                                }
                            }
                        }



                        break;
                    }

                }
                i++;
            }

            if (stepen){
                local2=Math.pow(local3,local2);
            }
            if (type==app){
                itog=itog+local1*local2;
            }else { if (Math.abs(local2)==0){errors=1;itog=0;}else{itog=itog+local1/local2;}}

            return itog;

        }

        

    
}

