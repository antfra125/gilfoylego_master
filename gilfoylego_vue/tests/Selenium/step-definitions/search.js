let { $, sleep } = require('./funcs');
module.exports = function () {


    this.Given(/^that im on the search page$/, async function () {
        await helpers.loadPage('http://localhost:8080/search');
        await driver.findElement(by.css('#__BVID__32'));

    });


    
} 