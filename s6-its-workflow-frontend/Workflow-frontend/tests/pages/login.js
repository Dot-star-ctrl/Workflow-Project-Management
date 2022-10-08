var loginCommands = {
    login () {
        this.waitForElementVisible("body")
            .waitForElementVisible(By.name('email'), 5000)
            .setValue(By.name('email'), "gminchev2000@gmail.com")
            .setValue(By.name('password'), "!Password!Password123")
            .click("@submit")
            .waitForElementVisible("#app", 5000)
    }
};
module.exports = {
    commands: [loginCommands],
    url: function() {
        return 'http://localhost:3000/';
    },
    elements: {
        email: {
            selector: By.name('email')
        },
        password: {
            selector: By.name('password')
        },
        submit: {
            selector: "button[type=submit]"
        },
    }
};
