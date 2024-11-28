object chocolate {
    method nutrientes() = 5

    method tieneCacao() = true
}

class Animal {
    var hambre
    
    method comer(comida){
        if(not self.puedeComer(comida)) {
            throw new Exception(message = "No puede comer la comida")
        }

        hambre -= comida.nutrientes()
    }

    method puedeComer(comida)
}

class Gato inherits Animal {
    override method comer(comida){
        super(comida)
        self.decirMeow()
    }

    override method puedeComer(comida) = not comida.tieneCacao()
    
    method decirMeow(){
        console.println("meow")
    }
}