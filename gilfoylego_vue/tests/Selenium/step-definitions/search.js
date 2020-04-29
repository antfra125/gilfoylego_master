let { sleep } = require('./funcs');
module.exports = function () {

    let sleepTime = 7000;
    this.Given(/^that im on the home page$/, async function () {
        await helpers.loadPage('http://localhost:8080/search');

        //assert.instanceOf(, "Expected a web element")

    });
    this.When(/^and click on the serch bar and type in <hotelname>$/, async function (hotelname) {
        await sleep(sleepTime);

    });


    /*-Background-----------------------------------------------------------------*/


}
