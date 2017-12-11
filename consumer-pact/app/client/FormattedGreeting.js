class FormattedGreeting {
    constructor(result) {
        this.result = result;
    }

    static fromJson(data) {
        return new FormattedGreeting(data.formattedGreeting);
    }
}

module.exports = FormattedGreeting;
