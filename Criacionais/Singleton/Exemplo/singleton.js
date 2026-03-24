class Singlenton {
    constructor() {
        if(Singlenton.instance == null) {
            Singlenton. instance = this;
            this.value = 0;
        }

        return Singlenton.instance;
    }

    increment() {
        this.value += 1;
        console.log(`Value: ${this.value}`)
    }
}

// Cliente
const s1 = new Singlenton();
const s2 = new Singlenton();

console.log(s1 === s2);

s1.increment();
s2.increment();
