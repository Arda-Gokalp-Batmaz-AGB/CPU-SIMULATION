
public class Branch {
	char type;
	String xvalue;
	public Branch()
	{
		
	}
	public Branch(String opcode,String xvalue)
	{
		if(opcode.equals("0000"))
		{
			type = 'Z';
		}
		else if(opcode.equals("0001"))
		{
			type = 'N';
		}
		this.xvalue = xvalue;
	}
	
	public void performBranch(CPU cpu)
	{
		int x = Converter.ConvertStringBinaryToInt(xvalue);
		if(type == 'Z')
		{
			if(cpu.ACC.getACCvalue() == 0)
			{
				cpu.PC.setPCvalue(cpu.PC.getPCvalue()+x);
			}
			else
			{
				cpu.PC.setPCvalue(cpu.PC.getPCvalue()+1);
			}
			//if(cpu.a)
		}
		else if (type == 'N')
		{
			if(cpu.ACC.getACCvalue() < 0)
			{
				cpu.PC.setPCvalue(cpu.PC.getPCvalue()+x);
			}
			else
			{
				cpu.PC.setPCvalue(cpu.PC.getPCvalue()+1);
			}			
		}
	}
}
