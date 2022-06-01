
public class ACC {
	private int ACCvalue;
	
	public ACC()
	{
		ACCvalue = 0;
	}
	public int getACCvalue() {
		return ACCvalue;
	}

	public void setACCvalue(int accvalue) {
		ACCvalue = accvalue;
	}
	@Override
	public String toString()
	{
		return String.valueOf(ACCvalue);
		
	}
}
