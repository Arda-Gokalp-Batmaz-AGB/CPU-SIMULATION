
public class ALU {
	String opcode;
	String xvalue;
	public ALU()
	{

	}
	public ALU(String opcode,String xvalue)
	{
		this.opcode = opcode;
		this.xvalue = xvalue;
	}
	public void performOperation(CPU cpu)
	{
		int x = Converter.ConvertStringBinaryToInt(xvalue);
		String[] ram = cpu.ram.getRamArray();
		int operand = Converter.ConvertStringBinaryToInt(ram[x]);
		String binAcc = Converter.ConvertIntToStringBinary(cpu.ACC.getACCvalue());

		if(opcode.equals("0101"))
		{
			int sum = cpu.ACC.getACCvalue()+operand;
			cpu.ACC.setACCvalue(sum);
		}
		else if(opcode.equals("0110"))
		{
			int sub = cpu.ACC.getACCvalue()-operand;
			cpu.ACC.setACCvalue(sub);
		}
		else if(opcode.equals("0111"))
		{
			int mul = cpu.ACC.getACCvalue()*operand;
			cpu.ACC.setACCvalue(mul);
		}
		else if(opcode.equals("1000"))
		{
			if(operand != 0)
			{
				int div = cpu.ACC.getACCvalue()/operand;
				cpu.ACC.setACCvalue(div);	
			}
			else
			{
				System.out.println("YOU CANT DIVIDE A NUMBER BY ZERO!");
			}
		}
		else if(opcode.equals("1001"))
		{
			int neg = cpu.ACC.getACCvalue()*-1;
			cpu.ACC.setACCvalue(neg);
		}	
		else if(opcode.equals("1010"))//shlift left
		{
			//int neg = cpu.ACC.getACCvalue()*-1;
			//			int temp = x;
			//			
			//			while(temp > 0)
			//			{
			//				binAcc = binAcc.substring(1,binAcc.length()) + "0";
			//				temp--;
			//			}
			//			int newAcc = Converter.ConvertStringBinaryToInt(binAcc);
			//			cpu.ACC.setACCvalue(newAcc);
			int newAcc = cpu.ACC.getACCvalue() << x;
			cpu.ACC.setACCvalue(newAcc);
		}	
		else if(opcode.equals("1011"))//right left
		{
			//int neg = cpu.ACC.getACCvalue()*-1;
			//			int temp = x;
			//			
			//			while(temp > 0)
			//			{
			//				binAcc = "0"+binAcc.substring(0,binAcc.length()-1);
			//				temp--;
			//			}
			//			int newAcc = Converter.ConvertStringBinaryToInt(binAcc);
			//			cpu.ACC.setACCvalue(newAcc);
			int newAcc = cpu.ACC.getACCvalue() >> x;
			cpu.ACC.setACCvalue(newAcc);
		}
		else if(opcode.equals("1100"))
		{
			int ans = cpu.ACC.getACCvalue()^operand;
			//String ansBin = Converter.ConvertIntToStringBinary(ans);
			cpu.ACC.setACCvalue(ans);
		}
		else if(opcode.equals("1101"))
		{
			int ans = ~cpu.ACC.getACCvalue();
			cpu.ACC.setACCvalue(ans);
		}
		else if(opcode.equals("1110"))
		{
			int ans =  cpu.ACC.getACCvalue() & operand;
			cpu.ACC.setACCvalue(ans);
		}
		else if(opcode.equals("1111"))
		{
			int ans =  cpu.ACC.getACCvalue() | operand;
			cpu.ACC.setACCvalue(ans);
		}
		cpu.PC.setPCvalue(cpu.PC.getPCvalue()+1);
	}
	//private sum
	//sub ,shft metolarý

}

//
//public static int getSum(int p, int q)
//{
//    int result = p ^ q; // + without carry 0+0=0, 0+1=1+0=1, 1+1=0
//    int carry = (p & q) << 1; // 1+1=2
//    if (carry != 0) {
//        return getSum(result, carry);
//    }
//    return result;
//}
//public static void sumOfTwoNumberUsingBinaryOperation(int a,int b)
//{
//    int c = a&b;
//    int r = a|b;
//    while(c!=0)
//    {
//        r =r <<1;
//        c = c >>1;      
//    }
//    System.out.println("Result:\t" + r);    
//}
//public String add(int a, int b){  
//    while (b != 0){
//        int carry = (a & b) ;
//
//        a = a ^ b; 
//
//        b = carry << 1;
//    }
//    return Integer.toBinaryString(a);
//}