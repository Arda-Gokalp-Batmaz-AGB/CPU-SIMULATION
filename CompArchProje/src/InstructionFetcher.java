import java.util.ArrayList;
import java.util.List;

public class InstructionFetcher {
	
	List<String> instructionList;
	public InstructionFetcher()
	{
		instructionList = new ArrayList<String>();
	}
	
	public void addInstruction(String ins)
	{
		instructionList.add(ins);
	}
	
	public List<String> getInstructions()
	{
		return instructionList;
	}
	public void ClearInstructions()
	{
		instructionList = new ArrayList<String>();
	}	
	@Override
	public String toString()
	{
		return instructionList.toString();
	}
}
