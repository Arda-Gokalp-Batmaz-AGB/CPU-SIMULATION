
public class RAM {
	
	private String[] ramArray;
	
	public RAM()
	{
		ramArray = new String[4096];
		for (int i = 0; i < ramArray.length; i++) {
			ramArray[i] = "0";
		}
	}

	public String[] getRamArray() {
		return ramArray;
	}

	public void setRamArray(String[] ramArray) {
		this.ramArray = ramArray;
	}
	public String toString()
	{
		String result = "RAM: ";
		for (int i = 0; i < ramArray.length; i++) {
			result = result + Converter.ConvertIntToHex(i) + ":" + ramArray[i] + ", ";
		}
		return result;
	}

}


//
//private long[][] ramArray;
//
//public RAM()
//{
//	ramArray = new long[2048][2048];
//}
//
//public long[][] getRamArray() {
//	return ramArray;
//}
//
//public void setRamArray(long[][] ramArray) {
//	this.ramArray = ramArray;
//}