module.exports = function () {

    this.Given(/^that I am on the "homepage"$/, async function () {
        await helpers.loadPage('http://localhost:8080');
        await(2000);
    });
} 