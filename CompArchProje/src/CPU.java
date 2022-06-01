import java.io.FileWriter;

public class CPU 
{
	public ACC ACC;
	public PC PC;
	public RAM ram;
	public InstructionFetcher insf;
	private String CI;
	public CPU()
	{
		ram = new RAM();
		insf = new InstructionFetcher();
		PC = new PC();
		ACC = new ACC();
		CI ="Initial State";
	}
	
	
	public void addInstruction(String ins)
	{
		insf.addInstruction(ins);
		System.out.println(insf);
	}
	
	private void executeInstruction(String ins)
	{
		InstructionDecoder decoder = new InstructionDecoder(ins);
		String decoded = decoder.getDecodedInstruction();
		//System.out.println(decoded);
		InstructionExecuter ex = new InstructionExecuter(this,decoded);
		ex.execute();
	}
	
	public void runTheProgram()
	{
		//UNSSIGNED SIGNED KONTROLLERÝ YAP
		int maxlength = insf.getInstructions().size();
		//System.out.println(Integer.toBinaryString(-16));
		//System.out.println(Integer.toBinaryString(+16));
		//System.out.println(Integer.toBinaryString(0x1000 | -32).substring(1));
		
//		  String binary = Integer.toBinaryString(1);
//		  System.out.println(binary); 
//		  long l = Long.parseLong(binary, 2); 
//		  int number = (int) l;
//		  System.out.println(number);  
		//instructionlara göre pcyi deiþtir eger branch ise farklý bir deðiþiklik diðerlerinde PC++
		while(PC.getPCvalue() < maxlength)
		{
			System.out.println(this);
			//System.out.println(ram);
			String currentIns = insf.getInstructions().get(PC.getPCvalue());
			CI = currentIns;
			executeInstruction(currentIns);
			//System.out.println(PC);
			//System.out.println(this);
			//System.out.println(ram);
		}
		System.out.println(this);
	}
	
	@Override
	public String toString()
	{
		String result = "Performed INS:" + CI + "\n"+ "CPU: PC:" + Converter.ConvertIntToStringBinary(PC.getPCvalue())+" (" +PC.getPCvalue()+ ")"+ ", ACC:" + Converter.ConvertIntToStringBinary(ACC.getACCvalue()) + " ("+ACC.getACCvalue()+")" + "\n" + ram + "\n";
		UserInterface.console_out = UserInterface.console_out + result + "\n";
		return result;
		//return "CPU: PC:" + Converter.ConvertIntToStringBinary(PC.getPCvalue())+" (" +PC.getPCvalue()+ ")"+ ", ACC:" + Converter.ConvertIntToStringBinary(ACC.getACCvalue()) + " ("+ACC.getACCvalue()+")"+ ", Performed INS:" + CI;
		//return "CPU: PC:" + Converter.ConvertIntToStringBinary(PC.getPCvalue())+" (" +PC.getPCvalue()+ ")"+ ", ACC:" + Converter.ConvertIntToStringBinary(ACC.getACCvalue()) + " ("+ACC.getACCvalue()+")"+ ", INSCOUNT:" + insf.getInstructions().size();
	}
	
}
