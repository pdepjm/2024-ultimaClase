interface Comida {
    nutrientes(): number
    tieneCacao(): boolean
}

class Chocolate implements Comida {
    nutrientes(): number {
        return 5;
    }
    tieneCacao(): boolean {
        return true;
    }
}

abstract class Animal {
    hambre: number

    comer(comida: Comida): void{
        if(!this.puedeComer(comida)){
            throw new Error("No puede comer la comida")
        }

        this.hambre -= comida.nutrientes()
    }

    abstract puedeComer(comida: Comida): boolean
}

class Gato extends Animal {
    override comer(comida: Comida): void{
        super.comer(comida)
        this.decirMeow()
    }

    override puedeComer(comida: Comida): boolean{
        return !comida.tieneCacao()
    }

    decirMeow(): void{
        console.log("meow")
    }
}