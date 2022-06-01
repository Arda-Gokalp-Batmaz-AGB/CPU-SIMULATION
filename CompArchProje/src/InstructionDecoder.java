
public class InstructionDecoder {
	private String instruction;
	private String decodedInstruction;
	public InstructionDecoder()
	{
	}
	public InstructionDecoder(String ins)
	{
		this.instruction = ins;
		FindBinaryNotation();
	}

	private void FindBinaryNotation()
	{
		if(instruction.length() == 16)
		{
			//instruction
			String result = "";
			String menomic = instruction.substring(0,instruction.indexOf(" "));
			menomic = menomic.toUpperCase();
			switch (menomic) {
			case "BRZ":
				result = "0000";
				break;
			case "BRN":
				result = "0001";
				break;
			case "LDI":
				result = "0010";
				break;
			case "LDM":
				result = "0011";
				break;
			case "STR":
				result = "0100";
				break;
			case "ADD":
				result = "0101";
				break;
			case "SUB":
				result = "0110";
				break;
			case "MUL":
				result = "0111";
				break;
			case "DIV":
				result = "1000";
				break;
			case "NEG":
				result = "1001";
				break;
			case "LSL":
				result = "1010";
				break;
			case "LSR":
				result = "1011";
				break;
			case "XOR":
				result = "1100";
				break;
			case "NOT":
				result = "1101";
				break;
			case "AND":
				result = "1110";
				break;
			case "ORR":
				result = "1111";
				break;
			case "MOV":
				result = "";
				break;
			}

			result = result + instruction.substring(instruction.indexOf(" ")+1,instruction.length());

			decodedInstruction = result;			
		}
		else
		{
			System.out.println("You Entered An Invalid Instruction");
		}


	}
	public String getDecodedInstruction()
	{
		return decodedInstruction;
	}
}
