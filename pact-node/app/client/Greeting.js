class Greeting {
    constructor(name) {
        this.name = name;
    }

    static fromJson(data) {
        return new Greeting(data.name);
    }
}

module.exports = Greeting;
