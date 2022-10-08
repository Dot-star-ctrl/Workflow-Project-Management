module.exports = {
    "Create task": browser => {
        //create an object for login
        let login = browser.page.login()

        //execute the login method from //tests/pages/login.js file
        login.navigate().login();

        browser
            .url("http://localhost:3000/workspaces/23/projects/23")
            .waitForElementVisible(".new-task", 5000)
            .click(".v-navigation-drawer__scrim")
            .click("button[id=new-task]")
            .waitForElementVisible(".create-task-dialog", 5000)
            .setValue("input[id=task-title]",'New Task')
            .setValue("textarea[id=task-description]",'Test description')
            .click("button[type=submit]")
            .waitForElementVisible(".v-expansion-panel", 5000)
    },

    "Update task": browser => {
        browser
            .url("http://localhost:3000/workspaces/23/projects/23")
            .click(".v-navigation-drawer__scrim")
            .waitForElementVisible(".v-expansion-panel-title", 5000)
            .click("button[id=task-panel]")
            .pause(1000)
            .click("button[id=edit-task]")
            .waitForElementVisible(".create-task-dialog", 5000)
            .setValue("input[id=task-title]",' UPDATED')
            .setValue("textarea[id=task-description]",' UPDATED')
            .click("button[type=submit]")
            .waitForElementVisible(".v-expansion-panel", 5000)
    },

    "Delete task": browser => {
        browser
            .url("http://localhost:3000/workspaces/23/projects/23")
            .click(".v-navigation-drawer__scrim")
            .waitForElementVisible(".v-expansion-panel-title", 5000)
            .click("button[id=task-panel]")
            .pause(1000)
            .click("button[id=delete-task]")
            .waitForElementVisible(".delete-task-card", 5000)
            .pause(1000)
            .click("button[id=confirm-delete-task]")
            .end()
    }
};
