
public class PC {
	private int PCvalue;
	
	public PC()
	{
		PCvalue = 0;
	}
	public int getPCvalue() {
		return PCvalue;
	}

	public void setPCvalue(int pCvalue) {
		PCvalue = pCvalue;
	}
	@Override
	public String toString()
	{
		return String.valueOf(PCvalue);
		
	}
}
