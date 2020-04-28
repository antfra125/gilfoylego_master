module.exports = function () {

    this.Given(/^that I am on the "homepage"$/, async function () {
        await helpers.loadPage('http://localhost:8081');

    });



    /*-Background-----------------------------------------------------------------*/

    this.When(/^I click the "login" button$/, async function () {

        let loginButton = await this.findElement('#__BVID__65')
        this.click(loginButton);
    });

    this.When(/^I enter a <username> in the "username" field$/, async function (username) {

        let usernameField = await this.findElement('#__BVID__65')
        this.click(usernameField);
        usernameField.sendKeys(username);
    });

    this.When(/^I enter a <password> in the "password" field$/, async function (password) {

        let passwordField = await this.findElement('#__BVID__65')
        this.click(passwordField);
        passwordField.sendKeys(password);
    });

    this.When(/^I click the "login" button$/, async function () {

        let loginButton = await this.findElement('#app > main > div > div.d - flex.justify - content - center > form > div: nth - child(4) > span: nth - child(1) > button');
        this.click(loginButton);
    });

}