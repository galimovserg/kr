
public class Parametr {
	
	private String caption;
	private String name;
	private TypeName type;
	//значение
	private String value;
	//значение по умолчанию
	private String valuestore;
	Parametr(String caption,String name,TypeName type,String valuestore){
		this.caption=caption;
		this.name=name;
		this.type=type;
		this.value=String.valueOf(valuestore.toCharArray());
		this.valuestore=String.valueOf(valuestore.toCharArray());
		
	}
	String getCaption(){
		return caption;
	}
	String getName(){
		return name;
	}
	TypeName getType(){
		return type;
	}
	String getValue(){
		return value;
	}
	
	void setValue(String val){
		value=String.valueOf(val.toCharArray());
	}
	void setStore(){
		value=String.valueOf(valuestore.toCharArray());
	}
	public String toString(){
		return "";
	}
	Parametr copy(){
		return new Parametr(caption, name, type.copy(), valuestore);
	}
}
