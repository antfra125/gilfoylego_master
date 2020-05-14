let { $, sleep } = require('./funcs');
 module.exports = function () {

   
     this.Given(/^that I am on the homepage$/, async function () {
         await helpers.loadPage('http://localhost:8080/');
         await driver.findElement(by.css('#__BVID__7'));   

     });
     

     this.When(/^I click the account button$/, async function () {
         let profilbutton = await driver.findElement(by.css('#__BVID__7'));
         profilbutton.click();
         await driver.findElement(by.css('#__BVID__7 > ul > div > li > a'));
         
     });


     this.When(/^I click on loggin in the dropdown menu$/, async function () {
         let logginButton = await driver.findElement(by.css('#__BVID__7 > ul > div > li > a'));
         logginButton.click();
         await driver.findElement(by.css('#__BVID__11'));
         
     });


     this.When(/^I enter the username "([^"]*)"$/, async function (username) {
         let usernameFiled = await driver.findElement(by.css('#__BVID__11'));
         usernameFiled.sendKeys(username);
         await driver.findElement(by.css('#__BVID__12')); 

     });
    
    
     this.When(/^I enter the password "([^"]*)"$/, async function (password) {
         let passwordFiled = await driver.findElement(by.css('#__BVID__12'));
         passwordFiled.sendKeys(password);
         await driver.findElement(by.css('#app > main > div > form > div.form-group.text-center'));

     });



     this.When(/^I click the login button$/, async function () {
         let logginButton = await driver.findElement(by.css('#app > main > div > form > div.form-group.text-center'));
        logginButton.click();  
        
     });


     this.Then(/^I should be logged in$/, async function () {
         let profilbutton = await driver.findElement(by.css('#__BVID__7'));
         profilbutton.click();
         await sleep(1000);
         await driver.findElement(by.css('#__BVID__7 > ul > div > li:nth-child(2)'));      

     });


     this.Then(/^I should still be logged out$/, async function () {
         let profilbutton = await driver.findElement(by.css('#__BVID__7'));
         profilbutton.click();
         await sleep(1000);
         await driver.findElement(by.css('#__BVID__7 > ul > div > li > a'));
     });
} 