let { $, sleep } = require('./funcs');
module.exports = function () {


    this.Given(/^that im on the search page$/, async function () {
        await helpers.loadPage('http://localhost:8080/search');
        await driver.findElement(by.css('#__BVID__11'));

    });
/*---------------------------------------------------------------------------*/

    this.When(/^I search for hotels in "([^"]*)"$/, async function (country) {
        let searchField = await driver.findElement(by.css('#__BVID__11'));
        searchField.sendKeys(country);
        await sleep(500);
        
    });

    this.Then(/^my frist search result should be a hotel in Norge$/, async function () {
        await driver.findElement(by.css('#app > main > div > div > div > form > div:nth-child(8) > div > div.container.my-4.p-5.grey-border.custom-link > div > div.col-sm-12.col-md-12.col-lg-8.px-4 > div:nth-child(2) > span > em'));

    });

    this.Then(/^my frist search result should be a hotel in Sverige$/, async function () {
        await driver.findElement(by.css('#app > main > div > div > div > form > div:nth-child(8) > div > div:nth-child(1) > div > div.col-sm-12.col-md-12.col-lg-8.px-4 > div:nth-child(2) > span > em'));


    });

    this.Then(/^my frist search result should be a hotel in Danmark$/, async function () {
        await driver.findElement(by.css('#app > main > div > div > div > form > div:nth-child(8) > div > div.container.my-4.p-5.grey-border.custom-link > div > div.col-sm-12.col-md-12.col-lg-8.px-4 > div:nth-child(2) > span > em'));


    });


    

    
}
