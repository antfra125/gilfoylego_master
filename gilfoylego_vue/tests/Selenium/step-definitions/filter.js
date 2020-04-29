

/* module.exports = function () {

    this.Given(/^that I´m at the search page$/, async function () {
        await helpers.loadPage('http://localhost:8081');

    });

    

    this.When(/^and i clickt on the serchbar$/, async function () {

        let serchField = await this.findElement('#__BVID__65')
        this.click(serchField);
    });

    this.When(/^And typted in "Sweden"$/, async function () {
        
        let serchField = await this.findElement('#__BVID__65')
        serchField.sendKeys(hotelname);
    });

    this.When(/^enter a start date$/, async function () {

        let startDateButton = await this.findElement('#__BVID__66__dialog_');
        this.click(startDateButton);
        let startDate = await this.findElement('#__BVID__68__cell - 2020 - 07 -19_ > span');
        this.click(startDate)
    });

    this.When(/^enter a end date$/, async function () {

        let endDateButton = await this.findElement('#__BVID__66__dialog_');
        this.click(startDateButton);
        let endDate = await this.findElement('#__BVID__68__cell - 2020 - 07 -22_ > span');
        this.click(endDate)
    });

    this.When(/^click search$/, async function () {

        let searchButton = await this.findElement('#app > main > div > div.d - flex.justify - content - center > form > div: nth - child(4) > span: nth - child(1) > button');
        this.click(searchButton);
    });

    this.Then(/^i should be at the result page$/, async function () {

        let poolCheckBox = await this.findElement('#__BVID__110 > div: nth-child(1) > div: nth - child(1)');
    });


    -Background-----------------------------------------------------------------


    this.When(/^i click the check box for childenterainment$/, async function () {

        let childEnterainmentCheckBox = await this.findElement('#__BVID__110 > div: nth - child(1) > div: nth - child(1)');
        this.click(childEnterainmentCheckBox);
    });

    this.When(/^the results should change to show only hotels with childenterainment$/, async function () {

        let childEnterainmentCheckBox = await this.findElement('#__BVID__110 > div: nth - child(1) > div: nth - child(1)');
        this.click(childEnterainmentCheckBox);
    });


    ---------------------------------------------------------------------------


    this.When(/^i click the check box for "pool"$/, async function () {

        let childEnterainmentCheckBox = await this.findElement('#__BVID__110 > div: nth - child(1) > div: nth - child(1)');
        this.click(childEnterainmentCheckBox);
    });

    this.When(/^the results should change to show only hotels with "pool"$/, async function () {

        let childEnterainmentCheckBox = await this.findElement('#__BVID__110 > div: nth - child(1) > div: nth - child(1)');
        this.click(childEnterainmentCheckBox);
    });


    ---------------------------------------------------------------------------


    this.When(/^i click the check box for "nightenterainment"$/, async function () {

        let childEnterainmentCheckBox = await this.findElement('#__BVID__110 > div: nth - child(1) > div: nth - child(1)');
        this.click(childEnterainmentCheckBox);
    });

    this.When(/^the results should change to show only hotels that have a "nightenterainment"$/, async function () {

        let childEnterainmentCheckBox = await this.findElement('#__BVID__110 > div: nth - child(1) > div: nth - child(1)');
        this.click(childEnterainmentCheckBox);
    });


    ---------------------------------------------------------------------------


    this.When(/^i click the check box for "resturang"$/, async function () {

        let childEnterainmentCheckBox = await this.findElement('#__BVID__110 > div: nth - child(1) > div: nth - child(1)');
        this.click(childEnterainmentCheckBox);
    });

    this.When(/^the results should change to show only hotels with "resturang"$/, async function () {

        let childEnterainmentCheckBox = await this.findElement('#__BVID__110 > div: nth - child(1) > div: nth - child(1)');
        this.click(childEnterainmentCheckBox);
    });


    ---------------------------------------------------------------------------
}

 */