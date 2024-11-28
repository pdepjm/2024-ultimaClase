interface Comida {
	public int nutrientes();
	public boolean contieneCacao();
}

class Chocolate implements Comida{
    
    @Override
	public int nutrientes() {
		return 5;
	}

	@Override
	public boolean contieneCacao() {
		return true;
	}
}

abstract class Animal{
	private int hambre;
	
	public void comer(Comida comida) throws Exception{
		if(!this.puedeComer(comida)){
			throw new Exception("No puede comer la comida");
		}
		
		this.hambre -= comida.nutrientes();
	}
		   
	abstract boolean puedeComer(Comida comida);
}

class Gato extends Animal{

    @Override
    public void comer(Comida comida) throws Exception{
        super.comer(comida);
        this.decirMeow();
    }

    @Override
    boolean puedeComer(Comida comida) {
        return !comida.contieneCacao();
    }

    private void decirMeow(){
        System.out.println("Meow");
    }

}