package enums;

public class PruebaCafes {
	public static void main(String[] args){
		TipoCafe tc;
		tc = TipoCafe.IRLANDES;
		
		System.out.println(tc);
		
		for(TipoCafe tipoCafe : TipoCafe.values()){
			System.out.println(tipoCafe);
		}
		
		for(TamanioCafe tamanioCafe : TamanioCafe.values()){
			System.out.println(tamanioCafe + " tiene una capacidad de  " + tamanioCafe.getCapacidad());
		}
	}
}
