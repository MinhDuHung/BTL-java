import java.util.HashMap;

public class IDandPassword {
	HashMap<String, String> logininfo = new HashMap<String, String>();
	
	IDandPassword(){
		logininfo.put("a", "1");
	}
	
	protected HashMap getLoginInfo(){
		return logininfo;
	}
}
