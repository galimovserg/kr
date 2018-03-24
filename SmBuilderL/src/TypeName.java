
public class TypeName {
		    String tname;
		    
		    static final TypeName intType=new TypeName("int");
		    static final TypeName floatType=new TypeName("float");
		    static final TypeName booleanType=new TypeName("boolean");
		    static final TypeName comboboxType=new TypeName("combobox");
		    static final TypeName stringType=new TypeName("string");
		    public TypeName(String name) {
		      tname = name;
		    }
		    TypeName copy(){
		    	return new TypeName(tname);
		    }
		    public String toString() {
		      return tname;
		    }
	}