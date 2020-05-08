let { sleep } = require('./funcs');
module.exports = function () {

    let sleepTime = 7000;
    this.Given(/^that im on the home page$/, async function () {
        await helpers.loadPage('http://localhost:8080/search');
        await sleep(sleepTime)
        assert.equal(1, 1, "[message]");
    });
    this.When(/^and click on the serch bar and type in <hotelname>$/, async function (hotelname) {

    let serchField = await this.findElement('#__BVID__66__dialog_')
    this.click(serchField);
    serchField.sendKeys(hotelname);
});

this.When(/^enter a start date$/, async function () {

    let startDateButton = await this.findElement('#__BVID__66__dialog_');
    this.click(startDateButton);
    let startDate = await this.findElement('#__BVID__68__cell - 2020 - 07 -19_ > span')
    this.click(startDate)
});

this.When(/^enter a end date$/, async function () {

    let endDateButton = await this.findElement('#__BVID__66__dialog_');
    this.click(startDateButton);
    let endDate = await this.findElement('#__BVID__68__cell - 2020 - 07 -22_ > span')
    this.click(endDate)
});

this.When(/^hit search$/, async function () {

    let searchButton = await this.findElement('#app > main > div > div.d - flex.justify - content - center > form > div: nth - child(4) > span: nth - child(1) > button');
    this.click(searchButton);
});

this.Then(/^my frist search result should be <hotelname>$/, async function () {


});


/*---------------------------------------------------------------------------*/


this.When(/^and clcik on the search bar and type in <city>$/, async function (city) {

    let serchField = await this.findElement('#__BVID__65');
    this.click(serchField);
    serchField.sendKeys(city);
});



this.Then(/^my frist search result should be <city>$/, async function () {


});


/*---------------------------------------------------------------------------*/


this.When(/^and clcik on the search bar and type in <countries>$/, async function (countries) {

    let serchField = await this.findElement('#__BVID__65');
    this.click(serchField);
    serchField.sendKeys(countries);
});



this.Then(/^my frist search result should be <countries>$/, async function () {


});


/*---------------------------------------------------------------------------*/


this.When(/^and click on the search bar and type in "Norge"$/, async function () {

    let serchField = await this.findElement('#__BVID__65');
    this.click(serchField);
    serchField.sendKeys(Norge);
});




this.Then(/^my hotels results should be between start date and end date$/, async function () {

    let startDate = await this.findElement('#__BVID__68__cell - 2020 - 07 -19_ > span');
    let endDate = await this.findElement('#__BVID__68__cell - 2020 - 07 -22_ > span');
});


    /*-Background-----------------------------------------------------------------*/


}
