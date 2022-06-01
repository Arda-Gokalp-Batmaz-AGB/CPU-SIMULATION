
public class InstructionExecuter 
{
	private String binaryInstruction;
	private CPU cpu;
	private String result;
	public InstructionExecuter() {
		// TODO Auto-generated constructor stub
	}
	public InstructionExecuter(CPU cpu,String binaryInstruction)
	{
		this.cpu = cpu;
		this.binaryInstruction = binaryInstruction;

		//this.execute();
	}

	public void execute()
	{
		String opcode = binaryInstruction.substring(0,4);
		String xvalue = binaryInstruction.substring(4,binaryInstruction.length());
		String solution = "";
		if(opcode.equals("0000") || opcode.equals("0001"))
		{
			Branch br = new Branch(opcode,xvalue);
			br.performBranch(cpu);
		}
		else if(opcode.equals("0010") || opcode.equals("0011") || opcode.equals("0100"))
		{
			LoadStore ls = new LoadStore(opcode,xvalue);
			ls.performOperation(cpu);
		}
		else
		{
			ALU alu = new ALU(opcode,xvalue);
			alu.performOperation(cpu);
		}
		//result = solution;
		//result
	}

	public String getResult()
	{
		return result;
	}
}
