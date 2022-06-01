
public class Converter {


	public static String ConvertBinaryToHex(String v)
	{
		int temp = ConvertStringBinaryToInt(v);
		return Integer.toString(temp,16);	
	}
	public static String ConvertIntToHex(int v)
	{
		return Integer.toString(v,16);	
	}
	public static String ConvertHexToBinary()
	{
		return "";
	}
	public static int ConvertStringBinaryToInt(String v)
	{
		
		if(v.charAt(0) == '0')//postive
		{
			int count = 32 - v.length();
			for (int i = 0; i < count; i++) 
			{
				v = "0" + v;
			}
		}
		else if(v.charAt(0) == '1')//negative
		{
			int count = 32 - v.length();
			for (int i = 0; i < count; i++) 
			{
				v = "1" + v;
			}

		}
		
		long l = Long.parseLong(v, 2); 
		int number = (int) l;
		
		return number;	
	}
	public static String ConvertIntToStringBinary(int v)
	{
		
		String binVersion = Integer.toBinaryString(v);
		if(v>=0)//postive
		{
			int count = 12 - binVersion.length();
			if(count >= 0)
			{
				for (int i = 0; i < count; i++) 
				{
					binVersion = "0" + binVersion;
				}
			}
			else
			{
				count = count * -1;
				binVersion = binVersion.substring(count+1,binVersion.length());
			}

		}
		else if(v<0)//negative
		{
			int count = 12 - binVersion.length();
			if(count >= 0)
			{
				for (int i = 0; i < count; i++) 
				{
					binVersion = "1" + binVersion;
				}
			}
			else
			{
				count = count * -1;
				binVersion = binVersion.substring(count,binVersion.length());
			}

		}
		return binVersion;	
	}
	
	
//	public static int ConvertBinaryToDecimal()
//	{
//		return 0;
//	}
//	public static String ConvertDecimalToBinary()
//	{
//		int a = 101;
//		return "";
//	}
//	public static int ConvertHexToDecimal()
//	{
//		return 0;
//	}
	
}
