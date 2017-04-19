import java.util.HashMap;
import java.util.Stack;

public class Monedas {
	Stack<Integer> candidatos = new Stack<Integer>();
	
	public Monedas(){
		cargarMonedas();
	}
	
	public void cargarMonedas(){
		candidatos.push(1);
		candidatos.push(2);
		candidatos.push(5);
		candidatos.push(10);
		candidatos.push(50);
	}
	
	public HashMap<Integer, Integer> calcular(int monto){
		HashMap<Integer, Integer> mapa = new HashMap<Integer, Integer>();
		while(!candidatos.isEmpty()){
			if(monto >= candidatos.peek()){
				monto -= candidatos.peek();
				if(mapa.get(candidatos.peek()) == null){
					mapa.put(candidatos.peek(), 1);
				}else{					
					mapa.put(candidatos.peek(), mapa.get(candidatos.peek())+1);
				}
			}else{
				candidatos.pop();
			}
		}
		
		return mapa;
	}
	
	public static void main(String[] args) {
		
		Monedas m = new Monedas();
		System.out.println(m.calcular(10).toString());	
	}
}
