using System;

public interface Comida {

	public int Nutrientes();
	public bool ContieneCacao();
}

class Chocolate : Comida{
	public int Nutrientes() {
		return 5;
	}
	
	public bool ContieneCacao() {
		return true;
	}
}

public abstract class Animal{
	private int hambre;
	
	virtual public void Comer(Comida comida){
		if(!this.PuedeComer(comida)){
			throw new Exception("No puede comer la comida");
		}
		
		hambre -= comida.Nutrientes();
	}
		   
	abstract protected bool PuedeComer(Comida comida);
}

public class Gato: Animal{
	
	override public void Comer(Comida comida){
		base.Comer(comida);
		this.DecirMeow();
	}
	
	override protected bool PuedeComer(Comida comida){
		return !comida.ContieneCacao();
	}
	
	private void DecirMeow(){
		Console.Write("Meow");
	
	}

}
