
public class LoadStore {
	char type;
	String xvalue;	
	public LoadStore()
	{
		
	}
	public LoadStore(String opcode,String xvalue)
	{
		if(opcode.equals("0010"))
		{
			type = 'I';
		}
		else if(opcode.equals("0011"))
		{
			type = 'L';
		}
		else if(opcode.equals("0100"))
		{
			type = 'S';
		}
		this.xvalue = xvalue;		
	}
	
	public void performOperation(CPU cpu)
	{
		int x = Converter.ConvertStringBinaryToInt(xvalue);
		String[] ram = cpu.ram.getRamArray();
		if(type == 'I')
		{
			cpu.ACC.setACCvalue(x);
		}
		else if(type == 'L')
		{
			int v = Converter.ConvertStringBinaryToInt(ram[x]);
			cpu.ACC.setACCvalue(v);
		}
		else if(type == 'S')
		{
			ram[x] = Converter.ConvertIntToStringBinary(cpu.ACC.getACCvalue());			
		}
		cpu.PC.setPCvalue(cpu.PC.getPCvalue()+1);
	}
}
